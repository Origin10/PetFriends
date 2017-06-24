package com.bookstore.service;

import com.bookstore.domain.*;
import com.bookstore.domain.Mem;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			Mem mem);
	
	Order findOne(Long id);
}
