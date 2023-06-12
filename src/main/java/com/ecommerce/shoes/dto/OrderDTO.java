package com.ecommerce.shoes.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDTO {

    private Long id;

    @NotNull
    private Date orderDate;

    private Date shippingDate;

    private String orderStatus;

    private BigDecimal orderTotal;

}
