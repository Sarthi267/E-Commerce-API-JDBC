package com.example.ecommerceapi.CustomQuery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class CustomQueryController {
    private final CustomQueryService customQueryService;

    public CustomQueryController(CustomQueryService customQueryService) {
        this.customQueryService = customQueryService;
    }

    @GetMapping
    public List<CustomJoinDTO> getOrderDetails() {
        return customQueryService.getOrderDetails();
    }
}
