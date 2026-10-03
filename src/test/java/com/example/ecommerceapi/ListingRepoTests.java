package com.example.ecommerceapi;

import com.example.ecommerceapi.Listing.ListingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;

@DataJdbcTest
@ActiveProfiles("test")
public class ListingRepoTests {
    @Autowired
    private ListingRepository listingRepository;



}
