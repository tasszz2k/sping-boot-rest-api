package com.bananleafnewspaper.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAPI {

    @GetMapping("/test")
    public ResponseEntity<String> testSpringBoot() {
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/")
    public ResponseEntity<String> sayHello() {

        System.err.println("HELLO");
        return ResponseEntity.ok("Success");
    }
}
