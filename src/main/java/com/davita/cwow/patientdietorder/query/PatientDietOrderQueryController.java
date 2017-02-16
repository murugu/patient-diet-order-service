package com.davita.cwow.patientdietorder.query;

import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderSearch;
import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderState;
import com.davita.cwow.patientdietorder.repository.PatientDietOrderSearchRepository;
import com.davita.cwow.patientdietorder.repository.PatientDietOrderStateRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/patientdietorders")
class PatientDietOrderQueryController {

	private final PatientDietOrderStateRepository patientDietOrderStateRepository;
	private final PatientDietOrderSearchRepository patientDietOrderSearchRepository;

	@Autowired
	public PatientDietOrderQueryController(PatientDietOrderStateRepository patientDietOrderStateyRepository, PatientDietOrderSearchRepository patientDietOrderSearchRepository) {
		this.patientDietOrderStateRepository = patientDietOrderStateyRepository;
		this.patientDietOrderSearchRepository = patientDietOrderSearchRepository;
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping(method = RequestMethod.GET, value = "/cache-values")
	public Collection<String> values() {
		return StreamSupport
				.stream(patientDietOrderStateRepository.findAll().spliterator(), false)
				.map(PatientDietOrderState::getValue)
				.collect(Collectors.toList());
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping(method = RequestMethod.GET, value = "/search-values")
	public Collection<String> searchValues() {
		return StreamSupport
				.stream(patientDietOrderSearchRepository.findAll().spliterator(), false)
				.map(PatientDietOrderSearch::getValue)
				.collect(Collectors.toList());
	}

	public Collection<String> fallback() {
		return new ArrayList<>();
	}

}


