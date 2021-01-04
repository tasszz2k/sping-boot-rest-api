package com.bananleafnewspaper.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.bananleafnewspaper.entity")
@SpringBootApplication
public class SpingBootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingBootRestApiApplication.class, args);
    }

}
