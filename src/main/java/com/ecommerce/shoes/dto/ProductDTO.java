package com.ecommerce.shoes.dto;

import java.util.Set;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.ecommerce.shoes.model.Brand;
import com.ecommerce.shoes.model.Category;
import com.ecommerce.shoes.model.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private Long id;

	@NotBlank(message = "Title is required")
	private String title;

	@Min(value = 0, message = "Stock must be greater than or equal to 0")
	private int stock;

	@DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
	private double price;

	
	private String picture;

	private Set<Size> sizes;

	private Set<Brand> brands;

	private Set<Category> categories;

}
