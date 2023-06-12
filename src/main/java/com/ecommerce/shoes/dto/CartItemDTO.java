package com.ecommerce.shoes.dto;

import javax.validation.constraints.Min;
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
public class CartItemDTO {

  
    private Long id;

    @Min(value = 1, message = "Số lượng phải lớn hơn hoặc bằng 1")
    private int qty;

    @NotBlank(message = "Kích cỡ không được để trống")
    private String size;

}
