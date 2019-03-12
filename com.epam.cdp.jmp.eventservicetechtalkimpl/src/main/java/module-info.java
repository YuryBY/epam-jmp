module com.epam.cdp.jmp.eventservicetechtalkimpl {
    exports com.epam.cdp.jmp.eventservicetechtalkimpl;
    requires com.epam.cdp.jmp.eventserviceapi;

    provides com.epam.cdp.jmp.eventserviceapi.EventService
            with com.epam.cdp.jmp.eventservicetechtalkimpl.TechTalkEventService;
}