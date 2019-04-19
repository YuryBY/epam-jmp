package com.epam.cdp.jmp.eventservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

//    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private long addressId;
//    private ObjectId id;

    private String city;

    private String street;

    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, country);
    }

    //    @JsonCreator
//    public Address() {
//    }
//
//    @JsonCreator
//    public Address(@JsonProperty("city") String city,
//                   @JsonProperty("street") String street,
//                   @JsonProperty("country") String country) {
//        this.city = city;
//        this.street = street;
//        this.country = country;
//    }


}
