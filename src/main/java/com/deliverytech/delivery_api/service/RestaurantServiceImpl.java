package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.RestaurantDto;
import com.deliverytech.delivery_api.entity.Restaurant;
import com.deliverytech.delivery_api.repository.IRestaurantRepository;

@Service
public class RestaurantServiceImpl  implements RestaurantService {
    @Autowired
    private IRestaurantRepository repository;

    public RestaurantServiceImpl(IRestaurantRepository repository) {
        this.repository = repository;
    }

    public RestaurantServiceImpl() {
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

    @Override
    public RestaurantDto createProduct(RestaurantDto restaurantDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
    }

    @Override
    public RestaurantDto updateProduct(RestaurantDto restaurantDto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public void changeStatusProduct(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeStatusProduct'");
    }

    @Override
    public RestaurantDto findProductById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductById'");
    }

    @Override
    public RestaurantDto findProductByCategory(String category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductByCategory'");
    }

    @Override
    public List<RestaurantDto> findProductByRestaurant(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductByRestaurant'");
    } 
}
