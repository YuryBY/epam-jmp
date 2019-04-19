package com.epam.cdp.jmp.eventservice.impl.repository;

import com.epam.cdp.jmp.eventservice.dto.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, BigInteger> {
    //public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByTitle(String title);
}

