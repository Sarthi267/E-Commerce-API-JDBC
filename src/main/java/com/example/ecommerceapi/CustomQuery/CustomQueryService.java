package com.example.ecommerceapi.CustomQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomQueryService {
    @Autowired
    private CustomQueryRepository customQueryRepository;

    public List<CustomJoinDTO> getOrderDetails(){
        return customQueryRepository.getOrderDetails();
    }
}
