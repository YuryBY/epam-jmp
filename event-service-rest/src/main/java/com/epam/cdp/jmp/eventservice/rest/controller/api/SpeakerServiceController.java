package com.epam.cdp.jmp.eventservice.rest.controller.api;

import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.dto.Speaker;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.util.List;


public interface SpeakerServiceController {

    @ApiOperation(response = Speaker.class, value = "Create new speaker")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Speaker.class),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    Speaker createSpeaker(@ApiParam("speaker itself") Speaker speaker);

    @ApiOperation(response = Speaker.class, value = "Update existing speaker")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Speaker.class),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    Speaker updateSpeaker(@ApiParam("speaker to update") Speaker speaker);

    @ApiOperation(response = List.class, produces = "application/json", value = "Returns a list of all speakers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    List<Speaker> getAllSpeakers();

    @ApiOperation(response = Event.class, produces = "application/json", value = "Returns an speaker by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Speaker.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    ResponseEntity<?> getSpeaker(@ApiParam("Id of the speaker") BigInteger id);

    @ApiOperation(response = Event.class, produces = "application/json", value = "Deletes an speaker by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Speaker.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    ResponseEntity<?> deleteSpeaker(@ApiParam("Id of the speaker") BigInteger id);

}
