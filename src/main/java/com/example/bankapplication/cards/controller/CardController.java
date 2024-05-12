package com.example.bankapplication.cards.controller;

import com.example.bankapplication.cards.dto.CardDto;
import com.example.bankapplication.cards.dto.ResponseDto;
import com.example.bankapplication.cards.service.ICardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api")
public class CardController {

    @Autowired
    ICardService cardService;

    @GetMapping("/")
    public String sayHello(){
        return "HELLO WORLD";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam
                               @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
                               String mobileNumber){
        cardService.createCard(mobileNumber);
        ResponseDto successResponse = new ResponseDto(HttpStatus.CREATED.toString() , "Card created successfully");
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);

    }

    @GetMapping("/fetch")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestParam
                                                        @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
                                                    String mobileNumber){
        CardDto cardDto = cardService.fetchCardDetails(mobileNumber);
        return new ResponseEntity<>(cardDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCardDetails(@RequestBody @Valid CardDto cardDto){
        cardService.updateCardDetails(cardDto);
        ResponseDto successResponse = new ResponseDto(HttpStatus.OK.toString(), "Successfully updated card details");
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCardDetails(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
                                                         String mobileNumber){
        cardService.deleteCardDetails(mobileNumber);
        ResponseDto successResponse = new ResponseDto(HttpStatus.OK.toString(), "Successfully deleted card details");
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}
