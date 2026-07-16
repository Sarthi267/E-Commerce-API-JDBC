package com.example.ecommerceapi.OrderItem;

import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderItemRepository extends ListCrudRepository <OrderItem, Long> {
    List<OrderItem> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
    List<OrderItem> findByCreatedAtAfter(LocalDateTime createdAt);
    List<OrderItem> findByCreatedAtBefore(LocalDateTime createdAt);
    List<OrderItem> findByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);
    List<OrderItem> findByUpdatedAtAfter(LocalDateTime updatedAt);
    List<OrderItem> findByUpdatedAtBefore(LocalDateTime updatedAt);
    List<OrderItem> findByOrderId(Long orderId);
    List<OrderItem> findByListingId(Long listingId);
    List<OrderItem> findByOrderIdAndListingId(Long orderId, Long listingId);
}
