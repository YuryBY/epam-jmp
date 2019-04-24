package com.epam.cdp.jmp.eventservice.api;

import com.epam.cdp.jmp.eventservice.dto.Speaker;

import java.math.BigInteger;
import java.util.List;

public interface SpeakerService {

    Speaker createSpeaker(Speaker speaker);

    Speaker updateSpeaker(Speaker speaker);

    Speaker getSpeaker(BigInteger id);

    void deleteSpeaker(BigInteger id);

    List<Speaker> getAllSpeakers();

}