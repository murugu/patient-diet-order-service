#!/usr/bin/env bash
set -e

# Export the docker machine IP
set +e
# check if we run machine?
docker-machine status default > /dev/null  2>&1
# if yes - result will be 0, if not 1
result=$?
set -e
if [[ $result == 1 ]]
then
    echo "you're using native docker. If not, review the setup"
    export DOCKER_IP=localhost
else
    echo "you're using docker machine. If not, review the setup"
    eval "$(docker-machine env default)"
    export DOCKER_IP=$(docker-machine ip default)
fi
echo DOCKER_IP set to $DOCKER_IP

# rebuild maven project and create docker images
mvn clean
mvn install

# stop and remove docker container
set +e
docker stop microservices-davita_patient-diet-order-service
docker rm microservices-davita_patient-diet-order-service
set -e

# run docker container for the project image
docker run --name microservices-davita_patient-diet-order-service \
    -d -e SPRING_PROFILES_ACTIVE=docker \
    -e DOCKER_IP=$DOCKER_IP davita/patient-diet-order-service
#    -add-host elasticsearch:$DOCKER_IP \
#    -add-host mysql:$DOCKER_IP \
#    -add-host redis:$DOCKER_IP \
#    -add-host zookeeper:$DOCKER_IP \
#    -add-host kafka:$DOCKER_IP
