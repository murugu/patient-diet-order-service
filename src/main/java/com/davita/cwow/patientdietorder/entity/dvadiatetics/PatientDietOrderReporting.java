package com.davita.cwow.patientdietorder.entity.dvadiatetics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "PatientDietOrder")
public class PatientDietOrderReporting {

    @Id
    private String id;

    private String value;

    public PatientDietOrderReporting() {
    }

    public PatientDietOrderReporting(PatientDietOrderDto dto) {
        setId(dto.getId());
        setValue(dto.getValue());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PatientDietOrderReporting{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}