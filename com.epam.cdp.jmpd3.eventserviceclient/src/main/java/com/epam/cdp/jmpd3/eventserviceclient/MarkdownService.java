package com.epam.cdp.jmpd3.eventserviceclient;

import com.epam.cdp.jmpd3.eventserviceapi.EventService;

import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class MarkdownService {

//    public static void formatList(ServiceLoader<EventService> services) {
//        for (EventService service : services) {
//            System.out.println(service.getEvents());
//        }
//    }

    public static String formatList(ServiceLoader<EventService> services) {
        return services.stream()
                .map(input -> "* " + input)
                .collect(Collectors.joining("\n"));
    }

}
