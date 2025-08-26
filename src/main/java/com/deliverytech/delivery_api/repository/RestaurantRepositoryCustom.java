package com.deliverytech.delivery_api.repository;

import java.util.List;

import com.deliverytech.delivery_api.entity.Restaurant;

public interface RestaurantRepositoryCustom {
    List<Restaurant> findByRated(String rated);    
}
