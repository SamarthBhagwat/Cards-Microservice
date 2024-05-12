package com.example.bankapplication.cards.mapper;

import com.example.bankapplication.cards.dto.CardDto;
import com.example.bankapplication.cards.entity.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardDto mapCardToCardDto(Card card){
        CardDto cardDto = new CardDto();
        cardDto.setMobileNumber(card.getMobileNumber());
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setAmountUsed(card.getAmountUsed());
        cardDto.setAvailableAmount(card.getAvailableAmount());
        return cardDto;
    }
}
