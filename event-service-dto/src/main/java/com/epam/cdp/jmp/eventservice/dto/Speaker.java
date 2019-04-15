package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Speaker {
    //    BigInteger id;
    long speakerId;
    String firstName;
    String lastName;
    Email email;

    @JsonCreator
    public Speaker() {
    }

    @JsonCreator
    public Speaker(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("email") Email email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
