package com.feroz.ecommerce.dto;

import lombok.Data;

import java.util.Set;

import com.feroz.ecommerce.entity.Address;
import com.feroz.ecommerce.entity.Customer;
import com.feroz.ecommerce.entity.Order;
import com.feroz.ecommerce.entity.OrderItem;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
