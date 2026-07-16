package com.example.ecommerceapi.Listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {
   @Autowired
   private ListingRepository listingRepository;

   @PostMapping
   public Listing addListing(@RequestBody Listing listing) {
   return listingRepository.save(listing);
   }
   @GetMapping
    public List<Listing> getAllListings() {
       return listingRepository.findAll();
   }
   @PutMapping("/{id}")
    public Listing updateListing(@PathVariable Long id, @RequestBody Listing listing) {
       listing.setId(id);
       return listingRepository.save(listing);
   }
   @DeleteMapping("/{id}")
    public void deleteListing(@PathVariable Long id) {
       listingRepository.deleteById(id);
   }
   @GetMapping("/{id}")
    public Listing findListingById(@PathVariable Long id) {
       return listingRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Listing not found at ID " + id));
   }
   @GetMapping("/seller/{sellerId}")
    public List<Listing> findBySellerId(@PathVariable Long sellerId) {
       return listingRepository.findBySellerId(sellerId);

   }
    @GetMapping("/product/{productId}")
    public List<Listing> findByProductId(@PathVariable Long productId) {
       return listingRepository.findByProductId(productId);
    }
    @GetMapping("/created-after")
    public List<Listing> findByCreatedAfter(@RequestParam LocalDateTime createdAt) {
       return listingRepository.findByCreatedAtAfter(createdAt);
    }
    @GetMapping("/created-between")
    public List<Listing> findByCreatedAtBetween(@RequestParam LocalDateTime start,
                                                @RequestParam LocalDateTime end) {
       return  listingRepository.findByCreatedAtBetween(start, end);
    }
    @GetMapping("/created-before")
    public List<Listing> findByCreatedBefore(@RequestParam LocalDateTime createdAt) {
       return  listingRepository.findByCreatedAtBefore(createdAt);
    }
    @GetMapping("/updated-after")
    public List<Listing> findByUpdatedAfter(@RequestParam LocalDateTime updatedAt) {
       return listingRepository.findByUpdatedAtAfter(updatedAt);
    }
    @GetMapping("/updated-before")
    public List<Listing> findByUpdatedBefore(@RequestParam LocalDateTime updatedAt) {
       return  listingRepository.findByUpdatedAtBefore(updatedAt);
    }
    @GetMapping("/updated-between")
    public List<Listing> findByUpdatedBetween(@RequestParam LocalDateTime start,
                                              @RequestParam LocalDateTime end) {
       return  listingRepository.findByUpdatedAtBetween(start, end);
    }
    @GetMapping("/sku/{sku}")
    public Listing findBySku(@PathVariable String sku) {
       return listingRepository.findBySku(sku)
               .orElseThrow(()-> new RuntimeException("Listing with SKU: " + sku + " not found"));
    }
    @GetMapping("/status/{status}")
    public List<Listing> findByStatus(@PathVariable String status) {
       return listingRepository.findByStatus(status);
    }
}

