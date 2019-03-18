package com.epam.cdp.jmp.eventservice.controller.beans;

import com.epam.cdp.jmp.eventservicedto.Event;

public class CreateEventRequest {
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
