package com.example.ecommerceapi.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping
    public OrderItem save(@RequestBody OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
    @GetMapping
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderItemRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public OrderItem update(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        orderItem.setId(id);
        return orderItemRepository.save(orderItem);
    }
    @GetMapping("/{id}")
    public OrderItem findById(@PathVariable Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("OrderItem not found at Id: " + id));
    }
    @GetMapping("/created-after")
    public List<OrderItem> findByCreatedAfter(@RequestParam LocalDateTime createdAt) {
        return orderItemRepository.findByCreatedAtAfter(createdAt);
    }
    @GetMapping("/created-between")
    public List<OrderItem> findByCreatedBetween(@RequestParam LocalDateTime start,
                                            @RequestParam LocalDateTime end) {
        return orderItemRepository.findByCreatedAtBetween(start, end);
    }
    @GetMapping("/created-before")
    public List<OrderItem> findByCreatedBefore(@RequestParam LocalDateTime createdAt) {
        return orderItemRepository.findByCreatedAtBefore(createdAt);
    }
    @GetMapping("/updated-after")
    public List<OrderItem> findByUpdatedAfter(@RequestParam LocalDateTime updatedAt) {
        return orderItemRepository.findByUpdatedAtAfter(updatedAt);
    }
    @GetMapping("/updated-before")
    public List<OrderItem> findByUpdatedBefore(@RequestParam LocalDateTime updatedAt) {
        return orderItemRepository.findByUpdatedAtBefore(updatedAt);
    }
    @GetMapping("/updated-between")
    public List<OrderItem> findByUpdatedBetween(@RequestParam LocalDateTime start,
                                            @RequestParam LocalDateTime end) {
        return orderItemRepository.findByUpdatedAtBetween(start, end);
    }
    @GetMapping("/order-id/{orderId}")
    public List<OrderItem> findByOrderId(@PathVariable Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
    @GetMapping("/listing-id/{listingId}")
    public List<OrderItem> findByListingId(@PathVariable Long listingId) {
        return orderItemRepository.findByListingId(listingId);
    }
    @GetMapping("/listing-id-order-id-filter")
    public List<OrderItem> findByOrderIdAndListingId(@RequestParam Long orderId,
                                                     @RequestParam Long listingId) {
        return orderItemRepository.findByOrderIdAndListingId(orderId, listingId);
    }


}
