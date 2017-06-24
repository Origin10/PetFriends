package com.bookstore.service;

import com.bookstore.domain.BillingAddress;
import com.bookstore.domain.MemBilling;

public interface BillingAddressService {
	BillingAddress setByMemBilling(MemBilling memBilling, BillingAddress billingAddress);
}
