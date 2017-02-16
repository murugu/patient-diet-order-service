package com.davita.cwow.patientdietorder.event;

import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderDto;

public class PatientDietOrderEvent extends CommandEvent {

    public enum Action {CREATE, UPDATE, DELETE}

    private Action action;

    private PatientDietOrderDto patientDietOrderDto;

    //TODO empty constructor needed for json binding only. Think of how to avoid it
    public PatientDietOrderEvent() {
        super();
    }

    public PatientDietOrderEvent(Action action, PatientDietOrderDto patientDietOrderDto) {
        super();
        this.action = action;
        this.patientDietOrderDto = patientDietOrderDto;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public PatientDietOrderDto getPatientDietOrderDto() {
        return patientDietOrderDto;
    }

    public void setPatientDietOrderDto(PatientDietOrderDto patientDietOrderDto) {
        this.patientDietOrderDto = patientDietOrderDto;
    }

    @Override
    public String toString() {
        return "PatientDietOrderEvent{" +
                "action='" + action + '\'' +
                ", patientDietOrderDto=" + patientDietOrderDto +
                '}';
    }
}
