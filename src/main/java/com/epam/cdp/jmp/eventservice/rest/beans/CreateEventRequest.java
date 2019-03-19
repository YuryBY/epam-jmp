package com.epam.cdp.jmp.eventservice.rest.beans;


import com.epam.cdp.jmp.eventservice.dto.Event;

public class CreateEventRequest {
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
