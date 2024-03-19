package com.ceetech.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${dev.name}")
    private String devName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello world, its me again " + devName;
    }

    @GetMapping("/java")
    public String softwareDev() {
        return "Geek mode!";
    }
}
