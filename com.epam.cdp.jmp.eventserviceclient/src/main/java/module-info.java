module com.epam.cdp.jmp.eventserviceclient {
    requires com.epam.cdp.jmp.eventserviceapi;
    exports com.epam.cdp.jmp.eventserviceclient;

    uses com.epam.cdp.jmp.eventserviceapi.EventService;
}