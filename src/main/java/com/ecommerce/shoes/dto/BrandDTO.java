package com.ecommerce.shoes.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

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
@Validated
public class BrandDTO {


    private Long id;


    private ProductDTO product;

    @NotEmpty(message = "Name is required")
    private String name;
	
}
