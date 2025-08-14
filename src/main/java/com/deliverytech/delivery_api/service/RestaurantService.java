package com.deliverytech.delivery_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.deliverytech.delivery_api.dto.RestaurantDto;

@Service
public interface RestaurantService {
    public RestaurantDto createProduct(RestaurantDto restaurantDto);

    public RestaurantDto updateProduct(RestaurantDto restaurantDto, Long id);

    public void changeStatusProduct(Long id);

    public RestaurantDto findProductById(Long id);

    public RestaurantDto findProductByCategory(String category);

    public List<RestaurantDto> findProductByRestaurant(String name);
}
