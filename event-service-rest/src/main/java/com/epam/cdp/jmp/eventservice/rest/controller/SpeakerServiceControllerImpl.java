package com.epam.cdp.jmp.eventservice.rest.controller;

import com.epam.cdp.jmp.eventservice.api.SpeakerService;
import com.epam.cdp.jmp.eventservice.dto.Speaker;
import com.epam.cdp.jmp.eventservice.rest.controller.api.SpeakerServiceController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/l2/v3.0/event-service/speakers")
@Api(
        value = "event-service",
        description = "Speakers CRUD operations endpoint"
)
public class SpeakerServiceControllerImpl implements SpeakerServiceController {

    @Autowired
    private SpeakerService speakerService;

    @PostMapping(path = "/create")
    public Speaker createSpeaker(@RequestBody Speaker speaker) {
        return speakerService.createSpeaker(speaker);
    }

    @PostMapping(path = "/update")
    public Speaker updateSpeaker(@RequestBody Speaker speaker) {
        return speakerService.updateSpeaker(speaker);
    }

    @GetMapping
    public List<Speaker> getAllSpeakers() {
        return speakerService.getAllSpeakers();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpeaker(@PathVariable(name = "id") BigInteger id) {
        Speaker speaker = speakerService.getSpeaker(id);
        ResponseEntity responseEntity;
        if (speaker != null) {
            responseEntity = ResponseEntity.ok(speaker);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteSpeaker(@PathVariable(name = "id") BigInteger id) {
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
