package com.example.bankapplication.cards.service.impl;

import com.example.bankapplication.cards.dto.CardDto;
import com.example.bankapplication.cards.entity.Card;
import com.example.bankapplication.cards.enums.CardType;
import com.example.bankapplication.cards.exception.CardAlreadyExistsException;
import com.example.bankapplication.cards.exception.ResourceNotFoundException;
import com.example.bankapplication.cards.mapper.CardMapper;
import com.example.bankapplication.cards.repository.CardRepository;
import com.example.bankapplication.cards.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardMapper cardMapper;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Card> card = cardRepository.findByMobileNumber(mobileNumber);
        if(card.isPresent()){
            throw new CardAlreadyExistsException(String.format("Card with mobile number %s already exists" , mobileNumber));
        }
        Card newCard = createDefaultCard(mobileNumber);
        cardRepository.save(newCard);
    }

    @Override
    public CardDto fetchCardDetails(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return cardMapper.mapCardToCardDto(card);
    }

    @Override
    public void updateCardDetails(CardDto cardDto) {
        Card card = cardRepository.findByMobileNumber(cardDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", cardDto.getMobileNumber())
        );
        card = cardMapper.mapCardDtoToCard(cardDto, card);
        cardRepository.save(card);
    }

    @Override
    public void deleteCardDetails(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardRepository.deleteById(card.getCardId());
    }

    private static Card createDefaultCard(String mobileNumber){
        Card card = new Card();
        card.setMobileNumber(mobileNumber);
        String cardNumber = generateCardNumber();
        card.setCardNumber(cardNumber);
        card.setCardType(CardType.CREDIT_CARD);
        card.setTotalLimit(1_00_000);
        card.setAmountUsed(0);
        card.setAvailableAmount(1_00_000);
        return card;
    }

    private static String generateCardNumber(){
        Long randomNumber = (1000000000L + new Random().nextInt(1000000000));
        return randomNumber.toString();
    }
}
