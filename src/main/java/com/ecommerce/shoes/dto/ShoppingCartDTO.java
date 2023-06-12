package com.ecommerce.shoes.dto;

import java.util.List;

import com.ecommerce.shoes.model.CartItem;

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
public class ShoppingCartDTO {
	
	private List<CartItem> cartItems;

}
