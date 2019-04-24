package com.epam.cdp.jmp.eventservice.rest.controller;

import com.epam.cdp.jmp.eventservice.api.EventService;
import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.rest.controller.api.EventServiceController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PostMapping(path = "/update")
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping(path = "/title/{title}")
    public List<Event> getAllEventsByTitle(@PathVariable(name = "title") String title) {
        return eventService.getAllEventsByTitle(title);
    }

    @GetMapping(path = "/{id}")
    public Event getEvent(@PathVariable(name = "id") BigInteger id) {
        return eventService.getEvent(id);
    }

    @DeleteMapping(path = "/{id}")
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
