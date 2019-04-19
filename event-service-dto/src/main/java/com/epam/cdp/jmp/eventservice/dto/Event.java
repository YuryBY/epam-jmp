package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

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
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long eventId;
    private ObjectId id;

    private String title;

    private Address address;

    @DBRef
    private String speaker;

    //    @Enumerated(EnumType.STRING)
    @Field("type")
    private EventType eventType;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Field("date")
    private LocalDateTime dateTime;

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
                 String speaker,
                 EventType eventType,
                 LocalDateTime dateTime) {
        this.title = title;
        this.address = address;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(address, event.address) &&
                Objects.equals(speaker, event.speaker) &&
                eventType == event.eventType &&
                Objects.equals(dateTime, event.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, address, speaker, eventType, dateTime);
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title +
                ", place='" + address + '\'' +
                ", speaker='" + speaker + '\'' +
                ", eventType=" + eventType +
                ", dateTime=" + dateTime +
                '}';
    }
}
