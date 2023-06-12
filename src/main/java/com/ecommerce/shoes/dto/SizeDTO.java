package com.ecommerce.shoes.dto;

import javax.validation.constraints.NotEmpty;

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
public class SizeDTO {
   
    private Long id;

    private ProductDTO product;
    
    @NotEmpty
    private String value;
 
}

