package com.davita.cwow.patientdietorder.repository;

import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PatientDietOrderSearchRepository extends ElasticsearchRepository<PatientDietOrderSearch, String> {
}
