package com.epam.cdp.jmpd3.eventserviceclient;

import com.epam.cdp.jmpd3.eventserviceapi.EventService;

import java.util.ServiceLoader;

public class EventServiceClient {

    public static void main(String[] args) {
        System.out.println("Topics List:");
        System.out.println(MarkdownService.formatList(ServiceLoader.load(EventService.class)));
    }

    private static void formatList(ServiceLoader<EventService> services) {
        for (EventService service : services) {
            System.out.println(service.getEvents());
        }
    }

    public static ServiceLoader<EventService> loadEventServiceImpls() {
        return ServiceLoader.load(EventService.class);
    }

//    public static void printServices(ServiceLoader<EventService> services) {
//        for (EventService service : services) {
//            System.out.println(service.getEvents());
//        }
//    }

}
