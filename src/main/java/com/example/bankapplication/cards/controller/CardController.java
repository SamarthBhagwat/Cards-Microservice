package com.example.bankapplication.cards.controller;

import com.example.bankapplication.cards.dto.ResponseDto;
import com.example.bankapplication.cards.service.ICardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    ICardService cardService;

    @GetMapping("/")
    public String sayHello(){
        return "HELLO WORLD";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam @Valid
                               @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
                               String mobileNumber){
        cardService.createCard(mobileNumber);
        ResponseDto successResponse = new ResponseDto(HttpStatus.CREATED.toString() , "Card created successfully");
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);

    }
}
