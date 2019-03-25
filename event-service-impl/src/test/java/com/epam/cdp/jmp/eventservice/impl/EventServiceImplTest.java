package com.epam.cdp.jmp.eventservice.impl;


import com.epam.cdp.jmp.eventservice.api.EventService;
import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.impl.repository.EventRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceImplTest {
    int eventFieldsIndex = 1;
    long eventId = 0L;
    String title = "the_title_" + eventFieldsIndex;

    @InjectMocks
    private EventService eventService = new EventServiceImpl();

    @Mock
    EventRepository eventRepositoryMock;

    @Before
    public void setUp() {
        Event event = TestUtils.createEvent(eventFieldsIndex);
        when(eventRepositoryMock.findAll()).thenReturn(new ArrayList<Event>() {{
            add(event);
        }});
        when(eventRepositoryMock.findById(event.getEventId())).thenReturn(Optional.of(event));
        when(eventRepositoryMock.save(any(Event.class))).thenReturn(event);
    }

    @Test
    public void testCreateEvent() {
        Event event = TestUtils.createEvent(eventFieldsIndex);
        Assert.assertEquals(eventId, eventService.createEvent(event).getEventId());
    }

    @Test
    public void testGetEvent() {
        Assert.assertEquals(eventId, eventService.getEvent(eventId).getEventId());
    }

    @Test
    public void testGetAllEvents() {
        List<Event> events = eventService.getAllEvents();
        Assert.assertEquals(eventId, events.get(0).getEventId());
        Assert.assertEquals(title, events.get(0).getTitle());
    }

    @Test
    public void testGetAllEventsByTitle() {
        List<Event> events = eventService.getAllEventsByTitle(title);
        Assert.assertEquals(eventId, events.get(0).getEventId());
    }
}
