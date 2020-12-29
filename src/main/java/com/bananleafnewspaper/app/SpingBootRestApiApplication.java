package com.bananleafnewspaper.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.bananleafnewspaper.entity"})  // scan JPA entities
@SpringBootApplication
public class SpingBootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingBootRestApiApplication.class, args);
    }

}
