package com.example.showbookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShowBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowBookingSystemApplication.class, args);
    }

}
