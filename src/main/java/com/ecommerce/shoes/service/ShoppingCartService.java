package com.ecommerce.shoes.service;

import com.ecommerce.shoes.model.Article;
import com.ecommerce.shoes.model.CartItem;
import com.ecommerce.shoes.model.ShoppingCart;
import com.ecommerce.shoes.model.User;


public interface ShoppingCartService {

	ShoppingCart getShoppingCart(User user);
	
	int getItemsNumber(User user);
	
	CartItem findCartItemById(Long cartItemId);
	
	CartItem addArticleToShoppingCart(Article article, User user, int qty, String size);
		
	void clearShoppingCart(User user);
	
	void updateCartItem(CartItem cartItem, Integer qty);

	void removeCartItem(CartItem cartItem);
	
}
