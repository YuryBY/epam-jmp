package com.epam.cdp.jmp.eventservice.rest.controller.api;

import com.epam.cdp.jmp.eventservice.dto.Event;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.util.List;

public interface EntityServiceController<T> {

    @ApiOperation(response = List.class, produces = "application/json", value = "Returns a list of events")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    List<T> getAll();

    @ApiOperation(response = List.class, produces = "application/json", value = "Returns a list of events by title")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    List<T> getAllByTitle(@ApiParam("Title of the event") String title);

    @ApiOperation(response = Event.class, produces = "application/json", value = "Returns an event by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    Event getEvent(@ApiParam("Id of the event") BigInteger id);

    @ApiOperation(response = Event.class, produces = "application/json", value = "Deletes an event by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Event.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    ResponseEntity<?> deleteEvent(@ApiParam("Id of the event") BigInteger id);

}
