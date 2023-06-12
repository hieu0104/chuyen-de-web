package com.ecommerce.shoes.service;

import java.util.List;

import com.ecommerce.shoes.model.Order;
import com.ecommerce.shoes.model.Payment;
import com.ecommerce.shoes.model.Shipping;
import com.ecommerce.shoes.model.ShoppingCart;
import com.ecommerce.shoes.model.User;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, Shipping shippingAddress, Payment payment, User user);
	
	List<Order> findByUser(User user);
	
	Order findOrderWithDetails(Long id);
}
