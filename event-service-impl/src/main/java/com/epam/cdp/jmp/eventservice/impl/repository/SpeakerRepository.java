package com.epam.cdp.jmp.eventservice.impl.repository;

import com.epam.cdp.jmp.eventservice.dto.Speaker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Repository
public interface SpeakerRepository extends MongoRepository<Speaker, BigInteger> {
//public interface SpeakerRepository extends CrudRepository<Speaker, Long> {
//    List<Speaker> findByTitle(String title);
}
