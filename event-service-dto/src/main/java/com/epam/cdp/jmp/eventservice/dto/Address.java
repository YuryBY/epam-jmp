package com.epam.cdp.jmp.eventservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
public class Address {

//    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private long addressId;
//    private ObjectId id;

    @Field("address")
    private final String address;

//    @Field("Address: City")
//    private String city;
//
//    @Field("Address: Street")
//    private String street;
//
//    @Field("Address: Country")
//    private String country;

    @Component
    static class AddressToStringConverter implements Converter<Address, String> {

        @Override
        public String convert(Address input) {
            return input == null ? null : input.address;
        }
    }

    @Component
    static class StringToAddressConverter implements Converter<String, Address> {

        @Override
        public Address convert(String input) {
            return StringUtils.hasText(input) ? new Address(input) : null;
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Address address = (Address) o;
//        return Objects.equals(city, address.city) &&
//                Objects.equals(street, address.street) &&
//                Objects.equals(country, address.country);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(city, street, country);
//    }

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
