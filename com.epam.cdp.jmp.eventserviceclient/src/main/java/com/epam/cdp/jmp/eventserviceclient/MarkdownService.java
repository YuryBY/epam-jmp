package com.epam.cdp.jmp.eventserviceclient;

import com.epam.cdp.jmp.eventserviceapi.EventService;

import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class MarkdownService {

    public static String formatList(ServiceLoader<EventService> services) {
        return services.stream()
                .map(input -> "* " + input)
                .collect(Collectors.joining("\n"));
    }

}
