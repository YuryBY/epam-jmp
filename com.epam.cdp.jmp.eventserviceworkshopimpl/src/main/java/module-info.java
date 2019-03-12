import com.epam.cdp.jmp.eventserviceapi.EventService;
import com.epam.cdp.jmp.eventserviceworkshopimpl.WorkshopEventService;

module com.epam.cdp.jmp.eventserviceworkshopimpl {
    exports com.epam.cdp.jmp.eventserviceworkshopimpl;
    requires com.epam.cdp.jmp.eventserviceapi;

    provides EventService
            with WorkshopEventService;
}