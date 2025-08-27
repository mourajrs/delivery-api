package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.RestaurantDto;
import com.deliverytech.delivery_api.entity.Restaurant;
import com.deliverytech.delivery_api.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl  implements RestaurantService {
    @Autowired
    private RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    public RestaurantServiceImpl() {
        super();
    }

    @Override
    public Long create(RestaurantDto restaurantDto) {
        ModelMapper modelMapper = new ModelMapper();
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
        return repository.save(restaurant).getId();        
    }    

    @Override
    public RestaurantDto findByRestaurant(String restaurant) {
        ModelMapper modelMapper = new ModelMapper();      
        return repository.findByName(restaurant).map(restaurant1 -> modelMapper.map(restaurant1, RestaurantDto.class)).orElse(null);
    } 
    
    @Override
    public List<RestaurantDto> findByRated(String rated) {        
        return null;
    }

    @Override
    public RestaurantDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        return repository.findById(id).map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class)).orElse(null);     
    }

    @Override
    public List<RestaurantDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return repository.findAll().stream().map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class)).collect(Collectors.toList());
    }

}
