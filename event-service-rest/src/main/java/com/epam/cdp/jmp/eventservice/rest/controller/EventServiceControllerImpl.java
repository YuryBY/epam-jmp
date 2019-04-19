package com.epam.cdp.jmp.eventservice.rest.controller;

import com.epam.cdp.jmp.eventservice.api.EventService;
import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.rest.controller.api.EventServiceController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Api(
        value = "event-service",
        description = "Events CRUD operations endpoint"
)
@RestController
@RequestMapping("/l2/v3.0/event-service/events")
public class EventServiceControllerImpl implements EventServiceController {

    @Autowired
    private EventService eventService;

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        Event storedEvent = eventService.createEvent(event);
        ResponseEntity responseEntity;
        if (storedEvent != null) {
            responseEntity = ResponseEntity.ok(storedEvent);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllEvents() {
        List<Event> allEvents = eventService.getAllEvents();
        ResponseEntity responseEntity;
        if (allEvents != null && !allEvents.isEmpty()) {
            responseEntity = ResponseEntity.ok(allEvents);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @GetMapping(path = "/title/{title}", produces = "application/json")
    public ResponseEntity<?> getAllEventsByTitle(@PathVariable(name = "title") String title) {
        List<Event> allEvents = eventService.getAllEventsByTitle(title);
        ResponseEntity responseEntity;
        if (allEvents != null && !allEvents.isEmpty()) {
            responseEntity = ResponseEntity.ok(allEvents);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getEvent(@PathVariable(name = "id") BigInteger id) {
        Event event = eventService.getEvent(id);
        ResponseEntity responseEntity;
        if (event != null) {
            responseEntity = ResponseEntity.ok(event);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> deleteEvent(@PathVariable(name = "id") BigInteger id) {
        ResponseEntity responseEntity;
        try {
            eventService.deleteEvent(id);
            responseEntity = ResponseEntity.ok(id);
        } catch (Exception ex) {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

}
