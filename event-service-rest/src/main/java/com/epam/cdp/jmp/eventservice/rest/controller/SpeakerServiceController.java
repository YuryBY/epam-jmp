package com.epam.cdp.jmp.eventservice.rest.controller;

import com.epam.cdp.jmp.eventservice.api.SpeakerService;
import com.epam.cdp.jmp.eventservice.dto.Email;
import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.dto.Speaker;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/l2/v2.0/event-service/speakers")
@Api(
        value = "event-service",
        description = "Speakers CRUD operations endpoint"
)
public class SpeakerServiceController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping(path = "/create", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(response = Speaker.class, value = "Create new speaker")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Speaker.class),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
    ResponseEntity<?> createSpeaker(
            @ApiParam("Speaker's first name") @RequestParam(name = "firstName") String firstName,
            @ApiParam("Speaker's last name") @RequestParam(name = "lastName") String lastName,
            @ApiParam("Speaker's email") @RequestParam(name = "email") Email email) {
        Speaker speaker = new Speaker(firstName, lastName, email);
        Speaker storedSpeaker = speakerService.createSpeaker(speaker);
        ResponseEntity responseEntity;
        if (storedSpeaker != null) {
            responseEntity = ResponseEntity.ok(storedSpeaker);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(response = List.class, produces = "application/json", value = "Returns a list of speakers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
    ResponseEntity<?> getAllSpeakers() {
        List<Speaker> allSpeakers = speakerService.getAllSpeakers();
        ResponseEntity responseEntity;
        if (allSpeakers != null && !allSpeakers.isEmpty()) {
            responseEntity = ResponseEntity.ok(allSpeakers);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

//    @RequestMapping(path = "/title/{title}", method = RequestMethod.GET, produces = "application/json")
//    @ApiOperation(response = List.class, produces = "application/json", value = "Returns a list of speakers by title")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success", response = List.class),
//            @ApiResponse(code = 204, message = "Not found"),
//            @ApiResponse(code = 500, message = "Internal Server Error")})
//    public @ResponseBody
//    ResponseEntity<?> getAllSpeakersByTitle(@ApiParam("Title of the event") @PathVariable(name = "title") String title) {
//        List<Event> allEvents = speakerService.getAllEventsByTitle(title);
//        ResponseEntity responseEntity;
//        if (allEvents != null && !allEvents.isEmpty()) {
//            responseEntity = ResponseEntity.ok(allEvents);
//        } else {
//            responseEntity = ResponseEntity.noContent().build();
//        }
//        return responseEntity;
//    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(response = Event.class, produces = "application/json", value = "Returns an speaker by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Speaker.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
    ResponseEntity<?> getEvent(@ApiParam("Id of the speaker") @PathVariable(name = "id") BigInteger id) {
        Speaker speaker = speakerService.getSpeaker(id);
        ResponseEntity responseEntity;
        if (speaker != null) {
            responseEntity = ResponseEntity.ok(speaker);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(response = Event.class, produces = "application/json", value = "Deletes an speaker by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Speaker.class),
            @ApiResponse(code = 204, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public @ResponseBody
        //TODO to improve delete method
    ResponseEntity<?> deleteSpeaker(@ApiParam("Id of the speaker") @PathVariable(name = "id") BigInteger id) {
        ResponseEntity responseEntity;
        try {
            speakerService.deleteSpeaker(id);
            responseEntity = ResponseEntity.ok(id);
        } catch (Exception ex) {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

}
