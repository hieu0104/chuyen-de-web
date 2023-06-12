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
public class CategoryDTO {
	
	private Long id;
	private ProductDTO product;

	@NotEmpty
	private String name;

	// Constructors, getters, setters, etc.
}
