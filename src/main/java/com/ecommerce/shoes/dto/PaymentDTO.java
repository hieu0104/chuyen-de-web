package com.ecommerce.shoes.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

   
    private Long id;

    @NotBlank(message = "Payment type is required")
    private String type;

    @NotBlank(message = "Card name is required")
    private String cardName;

    @CreditCardNumber(message = "Invalid card number")
    private String cardNumber;

    @Min(value = 1, message = "Expiry month must be between 1 and 12")
    @Max(value = 12, message = "Expiry month must be between 1 and 12")
    private int expiryMonth;

    @Min(value = 2023, message = "Expiry year must be in the future")
    private int expiryYear;

    @Min(value = 100, message = "CVC must be a 3-digit number")
    @Max(value = 999, message = "CVC must be a 3-digit number")
    private int cvc;

    @NotBlank(message = "Holder name is required")
    private String holderName;

    private OrderDTO order;

    // Các getter và setter
}
