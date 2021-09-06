package com.example.simpleboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //make json with controller
public class ControllerTest {
    @GetMapping("/test")
    public String test(){
        return "Test Complete";
    }
}
