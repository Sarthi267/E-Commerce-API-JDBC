package com.example.ecommerceapi.CustomQuery;

public record CustomJoinDTO(
  Long userId,
  String shippingAddress,
  double totalAmount,
  int quantity,
  double priceAtPurchase,
  double subtotal,
  String name,
  String description,
  String category
) {

}

