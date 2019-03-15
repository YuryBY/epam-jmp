package com.epam.cdp.jmp.eventserviceapi;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Long id, Event event);

    Event getEvent(Long id);

    void deleteEvent(Long id);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);

}
