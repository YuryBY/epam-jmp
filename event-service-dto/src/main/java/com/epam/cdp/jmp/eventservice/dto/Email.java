package com.epam.cdp.jmp.eventservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
public class Email {

//    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private long emailId;
//    private ObjectId id;

    @Field("email")
    private final String value;

    @Component
    static class EmailToStringConverter implements Converter<Email, String> {

        @Override
        public String convert(Email input) {
            return input == null ? null : input.value;
        }
    }

    @Component
    static class StringToEmailConverter implements Converter<String, Email> {

        @Override
        public Email convert(String input) {
            return StringUtils.hasText(input) ? new Email(input) : null;
        }
    }
}
