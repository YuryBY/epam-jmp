package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Event extends ResourceSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eventId;

    private String title;

    private Address address;

    private String speaker;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;

    @JsonCreator
    public Event() {
    }

    @JsonCreator
    public Event(@JsonProperty("title") String title,
                 @JsonProperty("address") Address address,
                 @JsonProperty("speaker") String speaker,
                 @JsonProperty("eventType") EventType eventType,
                 @JsonProperty("dateTime") LocalDateTime dateTime) {
        this.title = title;
        this.address = address;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", place='" + address + '\'' +
                ", speaker='" + speaker + '\'' +
                ", eventType=" + eventType +
                ", dateTime=" + dateTime +
                '}';
    }
}
