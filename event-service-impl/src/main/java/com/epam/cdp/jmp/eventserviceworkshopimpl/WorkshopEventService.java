package com.epam.cdp.jmp.eventserviceworkshopimpl;

import com.epam.cdp.jmp.eventserviceapi.EventService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkshopEventService implements EventService {

    @Override
    public List<String> getEvents() {
        return Stream.of(
                "Ws_topic_1",
                "Ws_topic_2",
                "Ws_topic_3",
                "Ws_topic_4",
                "Ws_topic_5").map(WorkshopEventService::addPrefix).collect(Collectors.toList());
    }

    static String addPrefix(String input) {
        return "Workshop: " + input;
    }

}
