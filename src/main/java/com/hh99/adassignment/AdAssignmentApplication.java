package com.hh99.adassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AdAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdAssignmentApplication.class, args);
    }

}
