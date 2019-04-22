package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Field("city")
    private String city;

    @Field("street")
    private String street;

    @Field("country")
    private String country;

    @JsonCreator
    public Address(@JsonProperty("city") String city,
                   @JsonProperty("street") String street,
                   @JsonProperty("country") String country) {
        this.city = city;
        this.street = street;
        this.country = country;
    }
}
