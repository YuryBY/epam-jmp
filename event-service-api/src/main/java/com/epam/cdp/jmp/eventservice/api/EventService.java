package com.epam.cdp.jmp.eventservice.api;

import com.epam.cdp.jmp.eventservice.dto.Event;

import java.math.BigInteger;
import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Event event);

    Event getEvent(BigInteger id);

    void deleteEvent(BigInteger id);

    void deleteAllEvents();

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);

}
