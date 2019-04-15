package com.epam.cdp.jmp.eventservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Email {
    String value;
}
