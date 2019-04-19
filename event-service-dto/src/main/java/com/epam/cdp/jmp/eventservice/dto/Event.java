package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

//import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "events")
public class Event {
//public class Event extends ResourceSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long eventId;
    private BigInteger id;

    private String title;

    @Indexed(unique = true)
    private Address address;

    @DBRef
    private Speaker speaker;

    //    @Enumerated(EnumType.STRING)
    @Field("type")
    private EventType eventType;

////    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @Field("date")
//    private LocalDateTime dateTime;

//    @JsonCreator
//    public Event() {
//    }

//    @JsonCreator
//    public Event(@JsonProperty("title") String title,
//                 @JsonProperty("address") Address address,
//                 @JsonProperty("speaker") String speaker,
//                 @JsonProperty("eventType") EventType eventType,
//                 @JsonProperty("dateTime") LocalDateTime dateTime) {
//        this.title = title;
//        this.address = address;
//        this.speaker = speaker;
//        this.eventType = eventType;
//        this.dateTime = dateTime;
//    }

    @JsonCreator
    public Event(String title,
                 Address address,
                 Speaker speaker,
                 EventType eventType) {
        this.title = title;
        this.address = address;
        this.speaker = speaker;
        this.eventType = eventType;
    }

}
