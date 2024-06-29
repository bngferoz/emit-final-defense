package com.feroz.ecommerce.service;

import com.feroz.ecommerce.dto.Purchase;
import com.feroz.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
