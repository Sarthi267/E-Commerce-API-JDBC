package com.example.ecommerceapi.Order;

import com.example.ecommerceapi.Listing.Listing;
import com.example.ecommerceapi.Listing.ListingRepository;
import com.example.ecommerceapi.OrderItem.OrderItem;
import com.example.ecommerceapi.OrderItem.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ListingRepository listingRepository;

    @Transactional
    public Order placeOrder(Order order, List<OrderItem> items) {
        Order savedOrder = orderRepository.save(order);
        for(OrderItem item : items) {
            Listing listing = listingRepository.findById(item.getListingId())
                    .orElseThrow(() -> new RuntimeException("Listing not found"));

            if (listing.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock");

            }
            item.setPriceAtPurchase(listing.getPrice());
            item.setOrderId(savedOrder.getId());
            item.setSubtotal(item.getPriceAtPurchase() * item.getQuantity());
            listing.setStock(listing.getStock() - item.getQuantity());
            listingRepository.save(listing);
            orderItemRepository.save(item);
        }
        return savedOrder;
    }
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
    public Order updateOrder(Long id, Order updatedOrder) {
        if(!orderRepository.existsById(id)){
            throw new RuntimeException("Order does not exist with id: " + id);
        }
        updatedOrder.setId(id);
        return orderRepository.save(updatedOrder);
    }
    public void deleteOrder(Long orderId) {
        if(!orderRepository.existsById(orderId)){
            throw new RuntimeException("Order does not exist with id: " + orderId);
        } else {
            orderRepository.deleteById(orderId);
        }
    }
    public List<Order> getAllOrders() {
     return orderRepository.findAll();
    }
    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatus(status);
    }
    public List<Order> findByUserIdAndStatus(Long userId, String status) {
        return orderRepository.findByUserIdAndStatus(userId, status);
    }
    public List<Order> findByPaymentStatus(String paymentStatus) {
        return orderRepository.findByPaymentStatus(paymentStatus);
    }
    public List<Order> findByUserIdAndPaymentStatus(Long userId, String paymentStatus) {
        return orderRepository.findByUserIdAndPaymentStatus(userId, paymentStatus);
    }
    public List<Order> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return orderRepository.findByCreatedAtBetween(start, end);
    }
    public List<Order> findByUpdatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return orderRepository.findByUpdatedAtBetween(start, end);
    }
    public List<Order> findByUpdatedAtAfter(LocalDateTime updatedAt) {
        return orderRepository.findByUpdatedAtAfter(updatedAt);
    }
    public List<Order> findByUpdatedAtBefore(LocalDateTime updatedAt) {
        return orderRepository.findByUpdatedAtBefore(updatedAt);
    }
    public List<Order> findByCreatedAtAfter(LocalDateTime createdAt) {
        return orderRepository.findByCreatedAtAfter(createdAt);
    }
    public List<Order> findByCreatedAtBefore(LocalDateTime createdAt) {
        return orderRepository.findByCreatedAtBefore(createdAt);
    }

}
