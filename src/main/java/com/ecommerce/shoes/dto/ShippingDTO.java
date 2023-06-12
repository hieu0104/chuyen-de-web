package com.ecommerce.shoes.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShippingDTO {

    private Long id;

    @NotBlank(message = "Receiver name is required")
    private String receiver;

  
    private AddressDTO address;

    @OneToOne
    private OrderDTO order;

    // Các getter và setter
}
