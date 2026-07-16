package com.example.ecommerceapi.CustomQuery;

public record CustomJoinDTO(
  Long userId, //order
  String shippingAddress, //order
  double totalAmount, //order
  int quantity, //orderItem
  double priceAtPurchase, //orderItem
  double subtotal, //orderItem
  String name, //product
  String description, //product
  String category //product
) {

}

