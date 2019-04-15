package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Address {
    String city;
    String street;
    String country;

    @JsonCreator
    public Address() {
    }

    @JsonCreator
    public Address(@JsonProperty("city") String city,
                   @JsonProperty("street") String street,
                   @JsonProperty("country") String country) {
        this.city = city;
        this.street = street;
        this.country = country;
    }


}
