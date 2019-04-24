package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "speakers")
public class Speaker {

    BigInteger id;

    private String firstName;

    private String lastName;

    private Email email;

    @JsonCreator
    public Speaker(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("email") Email email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
