package com.epam.cdp.jmpd3.eventservicetechtalkimpl;

import com.epam.cdp.jmpd3.eventserviceapi.EventService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TechTalkEventService implements EventService {
    @Override
    public List<String> getEvents() {
        return Stream.of(
                "Java 8 and 9, 10, 11+\n",
                "REST API - Architecture\n",
                "ELK Stack Log Itelligence\n",
                "Monitoring and troubleshooting\n",
                "Concurrency and Multi-threading Architecture\n",
                "Modern Web App Architecture\n",
                "Antipatterns\n",
                "Microservices\n",
                "Architecture of high-load/BigData projects\n",
                "Database Transaction Isolation and Locking\n",
                "React").map(TechTalkEventService::addPrefix).collect(Collectors.toUnmodifiableList());
    }

    static String addPrefix(String input) {
        return "Tech-talk: " + input;
    }

}
