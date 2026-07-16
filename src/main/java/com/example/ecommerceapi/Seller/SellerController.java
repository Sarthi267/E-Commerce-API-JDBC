package com.example.ecommerceapi.Seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    @PostMapping
    public Seller save(@RequestBody Seller seller) {
        return sellerRepository.save(seller);
    }
    @GetMapping
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sellerRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Seller update(@PathVariable Long id, @RequestBody Seller seller) {
        seller.setId(id);
        return sellerRepository.save(seller);
    }
    @GetMapping("/{id}")
    public Seller findById(@PathVariable Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller with id " + id + " not found"));
    }

}