package com.davita.cwow.patientdietorder.entity.dvadiatetics;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(indexName = "patientdietorders", type = "patientdietorder")
public class PatientDietOrderSearch {

    @Id
    private String id;

//    @Field(
//            type = FieldType.String,
//            index = FieldIndex.analyzed,
//            searchAnalyzer = "standard",
//            indexAnalyzer = "standard",
//            store = true
//    )
    private String value;

    public PatientDietOrderSearch() {
    }

    public PatientDietOrderSearch(PatientDietOrderDto dto) {
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
        return "PatientDietOrderSearch{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}