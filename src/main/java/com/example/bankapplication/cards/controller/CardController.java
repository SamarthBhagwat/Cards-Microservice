package com.example.bankapplication.cards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardController {

    @GetMapping("/")
    public String sayHello(){
        return "HELLO WORLD";
    }
}
