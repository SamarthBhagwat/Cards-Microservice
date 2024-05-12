package com.example.bankapplication.cards.service;

import com.example.bankapplication.cards.dto.CardDto;

public interface ICardService {

    void createCard(String mobileNumber);

    CardDto fetchCardDetails(String mobileNumber);

    void updateCardDetails(CardDto cardDto);

    void deleteCardDetails(String mobiileNumber);
}
