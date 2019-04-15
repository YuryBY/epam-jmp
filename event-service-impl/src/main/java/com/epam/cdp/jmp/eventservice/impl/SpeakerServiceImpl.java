package com.epam.cdp.jmp.eventservice.impl;

import com.epam.cdp.jmp.eventservice.api.SpeakerService;
import com.epam.cdp.jmp.eventservice.dto.Speaker;
import com.epam.cdp.jmp.eventservice.impl.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerRepository speakerRepository;

    @Override
    public Speaker createSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    @Override
    public Speaker updateSpeaker(long id, Speaker speaker) {
        return speakerRepository.existsById(id) ? speakerRepository.save(speaker) : null;
    }

    @Override
    public Speaker getSpeaker(long id) {
        Optional<Speaker> event = speakerRepository.findById(id);
        return event.orElse(null);
    }

    @Override
    public void deleteSpeaker(Long id) {
        speakerRepository.deleteById(id);
    }

    @Override
    public List<Speaker> getAllSpeakers() {
        return (List<Speaker>) speakerRepository.findAll();
    }
}
