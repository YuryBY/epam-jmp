package com.epam.cdp.jmp.eventservice.rest.controller;

import com.epam.cdp.jmp.eventservice.api.EventService;
import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.rest.beans.CreateEventRequest;
import com.epam.cdp.jmp.eventservice.rest.beans.EventRequestFailure;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/l0/v1.0/event-service")
@Api(
        value = "event-service",
        description = "Add method is implemented here"
)
public class EventServiceControllerL0 {

    @Autowired
    private EventService eventService;

    @ModelAttribute
    LocalDateTime initLocalDate() {
        return LocalDateTime.now();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(response = Event.class, value = "Create an event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 200, message = "Internal Server Error", response = EventRequestFailure.class)})
    public @ResponseBody ResponseEntity<?> createEvent(CreateEventRequest createEventRequest) {
        Event event = eventService.createEvent(createEventRequest.getEvent());
        ResponseEntity responseEntity;
        if (event != null) {
            responseEntity = ResponseEntity.ok(event);
        } else {
            responseEntity = ResponseEntity.ok(new EventRequestFailure("Internal Server Error"));
        }
        return responseEntity;
    }
}
