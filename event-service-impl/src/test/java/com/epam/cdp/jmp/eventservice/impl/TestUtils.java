package com.epam.cdp.jmp.eventservice.impl;

import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.dto.EventType;

import java.time.LocalDateTime;

public class TestUtils {
    public static Event createEvent(int eventFieldsIndex) {
        return new Event("the_title_" + eventFieldsIndex, "the_place_" + eventFieldsIndex, "the_speaker_" + eventFieldsIndex, EventType.TECHTALK, LocalDateTime.now());
    }

}
