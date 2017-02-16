package com.davita.cwow.patientdietorder;

import com.davita.cwow.patientdietorder.repository.PatientDietOrderReportingRepository;
import com.davita.cwow.patientdietorder.repository.PatientDietOrderStateRepository;
import com.davita.cwow.patientdietorder.repository.PatientDietOrderSearchRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableBinding({Sink.class, Source.class})
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
@EnableFeignClients
//@EnableResourceServer
//@EnableOAuth2Client
@EnableHystrix
@EnableJpaRepositories(basePackageClasses = {PatientDietOrderReportingRepository.class})
@EnableElasticsearchRepositories(basePackageClasses = {PatientDietOrderSearchRepository.class})
@EnableRedisRepositories(basePackageClasses = {PatientDietOrderStateRepository.class})
public class PatientDietOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientDietOrderServiceApplication.class, args);
    }
}

