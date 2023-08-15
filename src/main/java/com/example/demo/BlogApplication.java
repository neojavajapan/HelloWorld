package com.example.demo;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaAuditing
public class BlogApplication {

    public static void main(String[] args) {
	SpringApplication.run(BlogApplication.class, args);
    }

    @PostConstruct
    public void init() {
	TimeZone.setDefault(TimeZone.getTimeZone("JST"));
    }

}
