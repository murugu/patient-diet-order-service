package com.davita.cwow.patientdietorder.event;

import java.util.Date;
import java.util.UUID;

public abstract class BaseEvent {

    private final String eventId;

    private final Date eventDate;

    public BaseEvent() {
        //TODO improve UUID generation strategy
        //TODO review timestamp generation
        this.eventId = UUID.randomUUID().toString();
        this.eventDate = new Date();
    }

    public String getEventId() {
        return eventId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getEventType() {
        return this.getClass().getName();
    }
}
