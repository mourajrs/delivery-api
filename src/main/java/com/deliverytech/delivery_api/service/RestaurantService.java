package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.RestaurantDto;
import com.deliverytech.delivery_api.entity.Restaurant;
import com.deliverytech.delivery_api.repository.IRestaurantRespository;

@Service
public class RestaurantService {
    @Autowired
    private IRestaurantRespository repository;

    public RestaurantService(IRestaurantRespository repository) {
        this.repository = repository;
    }

    public RestaurantService() {
        super();
    }
    
    public List<RestaurantDto> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDto).collect(Collectors.toList());
    }
    
    private RestaurantDto ConvertEntityToDto(Restaurant entity) {
        RestaurantDto dto = new RestaurantDto();
        dto.setName(entity.getName());
        dto.setDescription((entity.getDescription()));
        return dto;
    } 
}
