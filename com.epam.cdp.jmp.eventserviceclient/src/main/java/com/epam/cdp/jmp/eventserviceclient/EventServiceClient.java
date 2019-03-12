package com.epam.cdp.jmp.eventserviceclient;

import com.epam.cdp.jmp.eventserviceapi.EventService;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class EventServiceClient {

    public static void main(String[] args) {
        System.out.println("Topics List:");
        List<EventService> servicesList = new ArrayList<>();
        ServiceLoader.load(EventService.class).forEach(servicesList::add);
        System.out.println(servicesList);
//        List<String> events = new ArrayList<>();
//        servicesList.stream().map(EventService::getEvents).forEach(events::addAll);
//        System.out.println(events);
//        System.out.println(servicesList);
//
//        System.out.println("!");

    }

}
