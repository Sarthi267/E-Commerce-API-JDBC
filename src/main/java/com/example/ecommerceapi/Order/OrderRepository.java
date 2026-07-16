package com.example.ecommerceapi.Order;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
    List<Order> findByStatus(String status);
    List<Order> findByUserIdAndStatus(Long userId, String status);
    List<Order> findByPaymentStatus(String PaymentStatus);
    List<Order> findByUserIdAndPaymentStatus(Long userId, String PaymentStatus);
    List<Order> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
    List<Order> findByCreatedAtAfter(LocalDateTime createdAt);
    List<Order> findByCreatedAtBefore(LocalDateTime createdAt);
    List<Order> findByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);
    List<Order> findByUpdatedAtAfter(LocalDateTime updatedAt);
    List<Order> findByUpdatedAtBefore(LocalDateTime updatedAt);
}
