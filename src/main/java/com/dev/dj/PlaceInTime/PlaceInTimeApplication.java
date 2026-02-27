package com.dev.dj.PlaceInTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PlaceInTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaceInTimeApplication.class, args);
    }

}
