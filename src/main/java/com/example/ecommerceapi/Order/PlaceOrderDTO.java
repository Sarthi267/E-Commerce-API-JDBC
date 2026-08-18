package com.example.ecommerceapi.Order;

import com.example.ecommerceapi.OrderItem.OrderItem;

import java.util.List;

public record PlaceOrderDTO (
        Order order,
        List<OrderItem> items
){
}
