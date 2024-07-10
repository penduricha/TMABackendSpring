package com.example.springWeekTwo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    //@GetMapping
    @RequestMapping("/welcome")
    public String getHelloWorld(){
        return "Hello World";
    }
}
