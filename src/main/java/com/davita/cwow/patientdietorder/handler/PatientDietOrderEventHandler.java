package com.davita.cwow.patientdietorder.handler;

import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderReporting;
import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderSearch;
import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderState;
import com.davita.cwow.patientdietorder.event.*;
import com.davita.cwow.patientdietorder.repository.PatientDietOrderReportingRepository;
import com.davita.cwow.patientdietorder.repository.PatientDietOrderSearchRepository;
import com.davita.cwow.patientdietorder.repository.PatientDietOrderStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(Sink.class)
@MessageEndpoint
public class PatientDietOrderEventHandler extends BaseEventHandler {

    @Autowired private PatientDietOrderStateRepository patientDietOrderStateRepository;
    @Autowired private PatientDietOrderSearchRepository patientDietOrderSearchRepository;
    @Autowired private PatientDietOrderReportingRepository patientDietOrderReportingRepository;

    @StreamListener(Sink.INPUT)
    public void handlePatientDietOrderCreateEvent(@Payload PatientDietOrderEvent event) {
        PatientDietOrderEvent.Action action = event.getAction();
        if(action == null) {
            throw new RuntimeException("action can't be empty");
        } else {
            switch (action) {
                case CREATE:
                    // save new order to DB
                    this.patientDietOrderReportingRepository.save(new PatientDietOrderReporting(event.getPatientDietOrderDto()));
                    // save new order to Cache
                    this.patientDietOrderStateRepository.save(new PatientDietOrderState(event.getPatientDietOrderDto()));
                    // save new order to ElasticSearch
                    this.patientDietOrderSearchRepository.save(new PatientDietOrderSearch(event.getPatientDietOrderDto()));
                    break;
                case UPDATE:
                    // update order in DB
                    this.patientDietOrderReportingRepository.save(new PatientDietOrderReporting(event.getPatientDietOrderDto()));
                    // update order in Cache
                    this.patientDietOrderStateRepository.save(new PatientDietOrderState(event.getPatientDietOrderDto()));
                    // update order in ElasticSearch
                    this.patientDietOrderSearchRepository.save(new PatientDietOrderSearch(event.getPatientDietOrderDto()));
                    break;
                case DELETE:
                    // soft delete order in DB
                    this.patientDietOrderReportingRepository.delete(new PatientDietOrderReporting(event.getPatientDietOrderDto()));
                    // delete order in Cache
                    this.patientDietOrderStateRepository.delete(new PatientDietOrderState(event.getPatientDietOrderDto()));
                    // delete order in ElasticSearch
                    this.patientDietOrderSearchRepository.delete(new PatientDietOrderSearch(event.getPatientDietOrderDto()));
                    break;
                default:
                    throw new RuntimeException("unknown action type");

            }
        }
    }

}
