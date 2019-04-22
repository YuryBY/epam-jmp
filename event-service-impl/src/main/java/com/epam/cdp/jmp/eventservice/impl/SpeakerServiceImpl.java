package com.epam.cdp.jmp.eventservice.impl;

import com.epam.cdp.jmp.eventservice.api.SpeakerService;
import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.dto.Speaker;
import com.epam.cdp.jmp.eventservice.impl.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    @Override
    public Speaker createSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    @Override
    public Speaker updateSpeaker(BigInteger id, Speaker speaker) {
        return speakerRepository.existsById(id) ? speakerRepository.save(speaker) : null;
    }

    @Override
    public Speaker getSpeaker(BigInteger id) {
        Optional<Speaker> event = speakerRepository.findById(id);
        return event.orElse(null);
    }

    @Override
    public void deleteSpeaker(BigInteger id) {
        speakerRepository.deleteById(id);
    }

    @Override
    public List<Speaker> getAllSpeakers() {
        return (List<Speaker>) speakerRepository.findAll();
    }

//    @Override
//    public List<Event> getAllEventsByTitle(String title) {
//        return (List<Event>) speakerRepository.findAll()findAll();
//    }
}
