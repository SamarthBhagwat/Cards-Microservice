package com.example.bankapplication.cards.entity;

import com.example.bankapplication.cards.enums.CardType;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Card extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private String mobileNumber;
    @Column(updatable = false)
    private String cardNumber;
    private CardType cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;

}
