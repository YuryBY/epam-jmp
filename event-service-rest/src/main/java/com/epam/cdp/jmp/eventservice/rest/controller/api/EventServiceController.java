package com.epam.cdp.jmp.eventservice.rest.controller.api;

import com.epam.cdp.jmp.eventservice.dto.Event;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.util.List;

public interface EventServiceController {

    @ApiOperation(response = Event.class, value = "Create new event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    Event createEvent(@ApiParam("event itself") Event event);

    @ApiOperation(response = Event.class, value = "Update existing event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    Event updateEvent(@ApiParam("event to update") Event event);

    @ApiOperation(response = List.class, produces = MediaType.APPLICATION_JSON_VALUE, value = "Returns a list of all events")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    List<Event> getAllEvents();

    @ApiOperation(response = List.class, produces = MediaType.APPLICATION_JSON_VALUE, value = "Returns a list of events by title")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    List<Event> getAllEventsByTitle(@ApiParam("Title of the event") String title);

    @ApiOperation(response = Event.class, produces = MediaType.APPLICATION_JSON_VALUE, value = "Returns an event by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    Event getEvent(@ApiParam("Id of the event") BigInteger id);

    @ApiOperation(response = Event.class, produces = MediaType.APPLICATION_JSON_VALUE, value = "Deletes an event by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    ResponseEntity<?> deleteEvent(@ApiParam("Id of the event") BigInteger id);

}
