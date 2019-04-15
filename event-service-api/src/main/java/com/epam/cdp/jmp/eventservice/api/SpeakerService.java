package com.epam.cdp.jmp.eventservice.api;

import com.epam.cdp.jmp.eventservice.dto.Speaker;

import java.util.List;

public interface SpeakerService {

    Speaker createSpeaker(Speaker speaker);

    Speaker updateSpeaker(long id, Speaker speaker);

    Speaker getSpeaker(long id);

    void deleteSpeaker(Long id);

    List<Speaker> getAllSpeakers();

}
