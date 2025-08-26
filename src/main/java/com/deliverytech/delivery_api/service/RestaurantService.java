package com.deliverytech.delivery_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.deliverytech.delivery_api.dto.RestaurantDto;

@Service
public interface RestaurantService {
    public Long create(RestaurantDto restaurantDto);       

    public List<RestaurantDto> findByRated(String rated);

    public RestaurantDto findByRestaurant(String restaurant);
}
