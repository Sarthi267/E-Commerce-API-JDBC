package com.example.ecommerceapi.Listing;

import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ListingRepository extends ListCrudRepository<Listing, Long> {
    List<Listing> findBySellerId(Long sellerId);
    List<Listing> findByProductId(Long productId);
    List<Listing> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
    List<Listing> findByCreatedAtAfter(LocalDateTime createdAt);
    List<Listing> findByCreatedAtBefore(LocalDateTime createdAt);
    List<Listing> findByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);
    List<Listing> findByUpdatedAtAfter(LocalDateTime updatedAt);
    List<Listing> findByUpdatedAtBefore(LocalDateTime updatedAt);
    List<Listing> findByStatus(String status);
    Optional<Listing> findBySku(String skuId);

}
