package com.epam.cdp.jmp.eventservicetechtalkimpl;

import com.epam.cdp.jmp.eventserviceapi.EventService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TechTalkEventService implements EventService {

    @Override
    public List<String> getEvents() {
        return Stream.of(
                "Java 8 and 9, 10, 11+",
                "REST API - Architecture",
                "ELK Stack Log Itelligence",
                "Monitoring and troubleshooting",
                "Concurrency and Multi-threading Architecture",
                "Modern Web App Architecture",
                "Antipatterns",
                "Microservices",
                "Architecture of high-load/BigData projects",
                "Database Transaction Isolation and Locking",
                "React").map(TechTalkEventService::addPrefix).collect(Collectors.toUnmodifiableList());
    }

    static String addPrefix(String input) {
        return "Tech-talk: " + input;
    }

}
