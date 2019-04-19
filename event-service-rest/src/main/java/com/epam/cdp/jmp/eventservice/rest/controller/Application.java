package com.epam.cdp.jmp.eventservice.rest.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;


@SpringBootApplication(scanBasePackages={"com.epam.cdp.jmp"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}
