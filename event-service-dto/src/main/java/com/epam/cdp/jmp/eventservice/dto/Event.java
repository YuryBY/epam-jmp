package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "events")
public class Event {

    private BigInteger id;

    private String title;

    private Address address;

    @DBRef
    private Speaker speaker;

    //    @Enumerated(EnumType.STRING)
    @Field("type")
    private EventType eventType;

    //    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Field("date")
    private LocalDateTime dateTime;

    @JsonCreator
    public Event(@JsonProperty("title") String title,
                 @JsonProperty("address") Address address,
                 @JsonProperty("speaker") Speaker speaker,
                 @JsonProperty("eventType") EventType eventType,
                 @JsonProperty("dateTime") LocalDateTime dateTime) {
        this.title = title;
        this.address = address;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }
}
