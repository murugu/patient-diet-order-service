package com.davita.cwow.patientdietorder.entity.dvadiatetics;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class PatientDietOrderDto extends BaseDto {

    private String id;

    private String value;

    public PatientDietOrderDto() {
    }

    public PatientDietOrderDto(String id) {
        super();
        this.id = id;
    }

    public PatientDietOrderDto(String id, String value) {
        super();
        this.id = id;
        this.value = value;
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