package com.davita.cwow.patientdietorder.entity.dvadiatetics;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("patientdietorders")
public class PatientDietOrderState {

    @Id
    private String id;

    private String value;

    public PatientDietOrderState() {
    }

    public PatientDietOrderState(PatientDietOrderDto dto) {
        super();
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
        return "PatientDietOrderDto{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}