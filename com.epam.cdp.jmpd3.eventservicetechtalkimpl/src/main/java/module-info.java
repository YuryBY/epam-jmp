module com.epam.cdp.jmpd3.eventservicetechtalkimpl {
    exports com.epam.cdp.jmpd3.eventservicetechtalkimpl;
    requires com.epam.cdp.jmpd3.eventserviceapi;

    provides com.epam.cdp.jmpd3.eventserviceapi.EventService
            with com.epam.cdp.jmpd3.eventservicetechtalkimpl.TechTalkEventService;
}