package com.epam.cdp.jmp.eventservicedto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Event {

    @JsonTypeInfo.Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    @Setter
    private long id;
    private String title;
    private String place;
    private String speaker;
    private EventType eventType;
    private Date dateTime;


}
