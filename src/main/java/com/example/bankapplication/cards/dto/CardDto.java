package com.example.bankapplication.cards.dto;

import com.example.bankapplication.cards.enums.CardType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CardDto {

    @NotBlank(message = "Mobile number cannot be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
    private String mobileNumber;

    @NotBlank(message = "Card number cannot be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
    private String cardNumber;

    @NotBlank(message = "Card type cannot be blank")
    private CardType cardType;

    @NotBlank(message = "Mobile number cannot be blank")
    @Positive
    @Min(10000)
    private int totalLimit;

    @NotBlank(message = "Mobile number cannot be blank")
    @Positive
    private int amountUsed;

    @NotBlank(message = "Mobile number cannot be blank")
    @Positive
    private int availableAmount;
}
