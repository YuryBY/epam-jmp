package com.epam.cdp.jmp.eventservicedto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
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

    private String place;

    private String speaker;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private LocalDateTime dateTime;

    @JsonCreator
    public Event() {
    }

    @JsonCreator
    public Event(@JsonProperty("title") String title,
                 @JsonProperty("place") String place,
                 @JsonProperty("speaker") String speaker,
                 @JsonProperty("eventType") EventType eventType,
                 @JsonProperty("dateTime") LocalDateTime dateTime) {
        this.title = title;
        this.place = place;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

}
