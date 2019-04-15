package com.epam.cdp.jmp.eventservice.impl.repository;

import com.epam.cdp.jmp.eventservice.dto.Speaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends CrudRepository<Speaker, Long> {
//    List<Speaker> findByTitle(String title);
}
