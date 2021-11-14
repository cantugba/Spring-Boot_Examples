package com.springBootExamples.flyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class FlywayApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlywayApplication.class,args);
    }
}