package com.epam.cdp.jmp.eventservice.rest.controller;

import com.epam.cdp.jmp.eventservice.api.EventService;
import com.epam.cdp.jmp.eventservice.dto.Event;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/l3/v3.0/event-service/events")
@Api(
        value = "event-service",
        description = "Events CRUD operations endpoint"
)
public class EventServiceControllerL3 {
    @Autowired
    private EventService eventService;

    @ModelAttribute
    LocalDateTime initLocalDate() {
        return LocalDateTime.now();
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
            for (Event event : allEvents) {
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(event.getId()).toUri();
//                event.add(new Link(location.toString()));
            }
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
            for (Event event : allEvents) {
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(event.getId()).toUri();
//                event.add(new Link(location.toString()));
            }
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
    ResponseEntity<?> getIvent(@ApiParam("Id of the event") @PathVariable(name = "id") BigInteger id) {
        Event event = eventService.getEvent(id);
        ResponseEntity responseEntity;
        if (event != null) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(event.getId()).toUri();
//            event.add(new Link(location.toString()));
            responseEntity = ResponseEntity.ok(event);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

}
