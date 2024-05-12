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

    public Card mapCardDtoToCard(CardDto cardDto, Card card){
        card.setMobileNumber(cardDto.getMobileNumber());
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setAvailableAmount(cardDto.getAvailableAmount());
        return card;
    }
}
