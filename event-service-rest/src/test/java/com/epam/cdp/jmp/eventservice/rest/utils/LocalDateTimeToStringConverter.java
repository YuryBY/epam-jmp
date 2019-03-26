package com.epam.cdp.jmp.eventservice.rest.utils;

import cucumber.api.Transformer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToStringConverter extends Transformer<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public LocalDateTime transform(String value) {
        return LocalDateTime.parse(value, FORMATTER);
    }

}
