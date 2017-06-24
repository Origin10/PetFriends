package com.bookstore.service;

import com.bookstore.domain.Payment;
import com.bookstore.domain.MemPayment;

public interface PaymentService {
	Payment setByMemPayment(MemPayment memPayment, Payment payment);
}
