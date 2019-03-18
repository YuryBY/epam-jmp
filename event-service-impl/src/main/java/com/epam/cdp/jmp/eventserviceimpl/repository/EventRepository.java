package com.epam.cdp.jmp.eventserviceimpl.repository;

import com.epam.cdp.jmp.eventservicedto.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
//    public List<Event> findAll() {
//        return null;
//    }

    List<Event> findByTitle(String title);

}
