package com.epam.cdp.jmp.eventservice.impl.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.epam.cdp.jmp.eventservice")
@EntityScan("com.epam.cdp.jmp.eventservice.dto")
@EnableJpaRepositories(basePackages = "com.epam.cdp.jmp.eventservice.impl.repository")
public class TestApp {
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }
}
