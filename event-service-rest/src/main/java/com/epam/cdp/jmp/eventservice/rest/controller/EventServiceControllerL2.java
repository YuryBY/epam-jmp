package com.epam.cdp.jmp.eventservice.rest.controller;

import com.epam.cdp.jmp.eventservice.api.EventService;
import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.dto.EventType;
import com.epam.cdp.jmp.eventservice.rest.beans.EventRequestFailure;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/l2/v2.0/event-service/events")
@Api(
        value = "event-service",
        description = "Events CRUD operations endpoint"
)
public class EventServiceControllerL2 {
    @Autowired
    private EventService eventService;

    @RequestMapping(path = "/create", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(response = Event.class, value = "Create new event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
    ResponseEntity<?> createEvent(
            @ApiParam("Title of the event") @RequestParam(name = "title") String title,
            @ApiParam("Place of the event") @RequestParam(name = "place") String place,
            @ApiParam("Speaker of the event") @RequestParam(name = "speaker") String speaker,
            @ApiParam("Event type") @RequestParam(name = "eventType") EventType eventType,
            @ApiParam("Date of the event") @RequestParam(name = "dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
        Event event = new Event(title, place, speaker, eventType, dateTime);
        Event storedEvent = eventService.createEvent(event);
        ResponseEntity responseEntity;
        if (storedEvent != null) {
            responseEntity = ResponseEntity.ok(storedEvent);
        } else {
            responseEntity = ResponseEntity.ok(new EventRequestFailure("Internal Server Error"));
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(response = List.class, produces = "application/json", value = "Returns a list of events")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
    ResponseEntity<?> getAllEvents() {
        List<Event> allEvents = eventService.getAllEvents();
        ResponseEntity responseEntity;
        if (allEvents != null && !allEvents.isEmpty()) {
            responseEntity = ResponseEntity.ok(allEvents);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @RequestMapping(path = "/title/{title}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(response = List.class, produces = "application/json", value = "Returns a list of events by title")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
    ResponseEntity<?> getAllEventsByTitle(@ApiParam("Title of the event") @PathVariable(name = "title") String title) {
        List<Event> allEvents = eventService.getAllEventsByTitle(title);
        ResponseEntity responseEntity;
        if (allEvents != null && !allEvents.isEmpty()) {
            responseEntity = ResponseEntity.ok(allEvents);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(response = Event.class, produces = "application/json", value = "Returns an event by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
    ResponseEntity<?> getEvent(@ApiParam("Id of the event") @PathVariable(name = "id") Long id) {
        Event event = eventService.getEvent(id);
        ResponseEntity responseEntity;
        if (event != null) {
            responseEntity = ResponseEntity.ok(event);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(response = Event.class, produces = "application/json", value = "Deletes an event by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
        //TODO to improve delete method
    ResponseEntity<?> deleteEvent(@ApiParam("Id of the event") @PathVariable(name = "id") Long id) {
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
