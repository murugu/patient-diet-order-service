package com.davita.cwow.patientdietorder.command;

import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderDto;
import com.davita.cwow.patientdietorder.event.PatientDietOrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patientdietorders")
class PatientDietOrderCommandController {

	private final MessageChannel channel;

	@Autowired
	public PatientDietOrderCommandController(Source channels) {
		this.channel = channels.output();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody PatientDietOrderDto patientDietOrderDto) {
		// generate random ID in create
		patientDietOrderDto.setId(UUID.randomUUID().toString());
		// send create event with the DTO
		this.channel.send(
				MessageBuilder
						.withPayload(new PatientDietOrderEvent(PatientDietOrderEvent.Action.CREATE, patientDietOrderDto))
						.build());
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody PatientDietOrderDto patientDietOrderDto) {
		// send create event with the DTO
		this.channel.send(
				MessageBuilder
						.withPayload(new PatientDietOrderEvent(PatientDietOrderEvent.Action.UPDATE, patientDietOrderDto))
						.build());
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable String id) {
		// send create event with the DTO
		this.channel.send(
				MessageBuilder
						.withPayload(new PatientDietOrderEvent(PatientDietOrderEvent.Action.DELETE, new PatientDietOrderDto(id, null)))
						.build());
	}
}
