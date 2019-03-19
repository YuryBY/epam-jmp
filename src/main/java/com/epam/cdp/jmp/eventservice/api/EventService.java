package com.epam.cdp.jmp.eventservice.api;

import com.epam.cdp.jmp.eventservice.dto.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Long id, Event event);

    Event getEvent(Long id);

    void deleteEvent(Long id);

    void deleteAllEvents();

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);

}
