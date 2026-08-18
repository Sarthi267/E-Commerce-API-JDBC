package com.example.ecommerceapi.Order;

import com.example.ecommerceapi.StockUpdateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final StockUpdateService stockUpdateService;

    public OrderController(OrderService orderService, StockUpdateService stockUpdateService) {
        this.orderService = orderService;
        this.stockUpdateService = stockUpdateService;
    }

    @PostMapping
    public Order addOrder(@RequestBody PlaceOrderDTO request) {
        return orderService.placeOrder(request.order(), request.items());
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderService.updateOrder(id,order);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.findById(id);
    }
    @GetMapping("/users/{userId}")
    public List<Order> findByUserId(@PathVariable Long userId) {
        return orderService.findByUserId(userId);
    }
    @GetMapping("/status/{status}")
    public List<Order> findByStatus(@PathVariable String status) {
        return orderService.findByStatus(status);
    }
    @GetMapping("/user-id-status-filter")
    public List<Order> findByUserIdAndStatus(@RequestParam Long userId,
                                             @RequestParam String status) {
        return orderService.findByUserIdAndStatus(userId, status);
    }
    @GetMapping("/payment-status/{paymentStatus}")
    public List<Order> findByPaymentStatus(@PathVariable String paymentStatus) {
        return orderService.findByPaymentStatus(paymentStatus);
    }
    @GetMapping("/created-after")
    public List<Order> findByCreatedAfter(@RequestParam LocalDateTime createdAt) {
        return orderService.findByCreatedAtAfter(createdAt);
    }
    @GetMapping("/created-between")
    public List<Order> findByCreatedBetween(@RequestParam LocalDateTime start,
                                            @RequestParam LocalDateTime end) {
        return orderService.findByCreatedAtBetween(start, end);
    }
    @GetMapping("/created-before")
    public List<Order> findByCreatedBefore(@RequestParam LocalDateTime createdAt) {
        return orderService.findByCreatedAtBefore(createdAt);
    }
    @GetMapping("/updated-after")
    public List<Order> findByUpdatedAfter(@RequestParam LocalDateTime updatedAt) {
        return orderService.findByUpdatedAtAfter(updatedAt);
    }
    @GetMapping("/updated-before")
    public List<Order> findByUpdatedBefore(@RequestParam LocalDateTime updatedAt) {
        return orderService.findByUpdatedAtBefore(updatedAt);
    }
    @GetMapping("/updated-between")
    public List<Order> findByUpdatedBetween(@RequestParam LocalDateTime start,
                                            @RequestParam LocalDateTime end) {
        return orderService.findByUpdatedAtBetween(start, end);
    }
    @GetMapping("/user-id-payment-status-filter")
    public List<Order> findByUserIdAndPaymentStatus(@RequestParam Long userId,
                                                    @RequestParam String paymentStatus) {
        return orderService.findByUserIdAndPaymentStatus(userId, paymentStatus);
    }
    @GetMapping(value = "/stock-updates", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter stockUpdates(@RequestParam Long listingId) {
      return stockUpdateService.createEmitter(listingId);
    }

}
