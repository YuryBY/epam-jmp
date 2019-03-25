package com.epam.cdp.jmp.eventservice.impl.repository;


import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.impl.TestUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class EventRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;

    @After
    public void cleanUp() {
        entityManager.clear();
    }

    @Test
    public void testFindByTitle() {
        Event event = TestUtils.createEvent(1);
        entityManager.persist(event);
        entityManager.flush();
        List<Event> events = eventRepository.findByTitle(event.getTitle());
        Assert.assertEquals(event.getTitle(), events.get(0).getTitle());
    }

    @Test
    public void testFindAll() {
        int quantity = 10;
        for (int i = 0; i < quantity; i++) {
            Event event = TestUtils.createEvent(i);
            entityManager.persist(event);
        }
        entityManager.flush();
        List<Event> events = (List<Event>) eventRepository.findAll();
        Assert.assertEquals(quantity, events.size());
    }
}
