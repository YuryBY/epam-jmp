package com.epam.cdp.jmpd3.eventservicetechtalkimpl;

import com.epam.cdp.jmpd3.eventserviceapi.EventService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkshopEventService implements EventService {

    @Override
    public List<String> getEvents() {
        return Stream.of(
                "Workshop_topic_1\n",
                "Workshop_topic_2\n",
                "Workshop_topic_3\n",
                "Workshop_topic_4\n",
                "Workshop_topic_5\n").map(WorkshopEventService::addPrefix).collect(Collectors.toUnmodifiableList());
    }

    static String addPrefix(String input) {
        return "Workshop: " + input;
    }

}
