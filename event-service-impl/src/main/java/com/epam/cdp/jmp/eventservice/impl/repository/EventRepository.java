package com.epam.cdp.jmp.eventservice.impl.repository;

import com.epam.cdp.jmp.eventservice.dto.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EventRepository extends MongoRepository<Event, BigInteger> {
}

