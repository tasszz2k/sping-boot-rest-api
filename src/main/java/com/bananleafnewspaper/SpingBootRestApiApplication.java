package com.bananleafnewspaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.bananleafnewspaper.entity"})  // scan JPA entities
//@SpringBootApplication(scanBasePackages = {"com.bananleafnewspaper.api"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@EnableJpaRepositories("com.bananleafnewspaper.repository")
//@ComponentScan(basePackages = {"com.bananleafnewspaper.app"})
public class SpingBootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingBootRestApiApplication.class, args);
    }

}
