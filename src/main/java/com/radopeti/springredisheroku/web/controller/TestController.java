package com.radopeti.springredisheroku.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public ResponseEntity<String> getHiOnIndexPage() {
        return ResponseEntity.ok("Hi on the index page!");
    }

    @GetMapping("/hi")
    public ResponseEntity<String> getHi() {
        return ResponseEntity.ok("Hi!");
    }

}
