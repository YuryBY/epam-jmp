package com.epam.cdp.jmp.eventservice.impl;

import com.epam.cdp.jmp.eventservice.api.EventService;
import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.impl.repository.EventRepository;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {


    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.existsById(event.getId()) ? eventRepository.save(event) : null;
//        eventRepository.
//        Optional<Event> storedEvent = eventRepository.findById(id);
//        Event result = null;
//        if(storedEvent.isPresent()){
//            event.setEventId(storedEvent.get().getEventId());
//            result = storedEvent.get();
//            eventRepository.deleteById(id);
//        }
//        return result;
    }

    @Override
    public Event getEvent(BigInteger id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    @Override
    public void deleteEvent(BigInteger id) {
        eventRepository.deleteById(id);
//        Optional<Event> event = eventRepository.findById(id);
//        Event result = null;
//        if(event.isPresent()){
//            result = event.get();
//            eventRepository.deleteById(id);
//        }
//        return result;
    }

    @Override
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    @Override
    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        MongoOperations mongoOps = new MongoTemplate(new MongoClient(), MongoConfig.dbName);
        return mongoOps.find(TextQuery.queryText(new TextCriteria().matchingAny(title)), Event.class);
    }
}
