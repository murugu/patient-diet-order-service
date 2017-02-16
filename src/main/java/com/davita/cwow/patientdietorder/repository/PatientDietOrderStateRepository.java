package com.davita.cwow.patientdietorder.repository;

import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PatientDietOrderStateRepository extends CrudRepository<PatientDietOrderState, String> {

}
