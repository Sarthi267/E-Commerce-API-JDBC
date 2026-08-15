package com.example.ecommerceapi.CustomQuery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomQueryService {
    private final CustomQueryRepository customQueryRepository;

    public CustomQueryService(CustomQueryRepository customQueryRepository) {
        this.customQueryRepository = customQueryRepository;
    }

    public List<CustomJoinDTO> getOrderDetails(){
        return customQueryRepository.getOrderDetails();
    }
}
