package com.davita.cwow.patientdietorder.repository;

import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderDto;
import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderReporting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PatientDietOrderReportingRepository extends JpaRepository<PatientDietOrderReporting, String> {

}
