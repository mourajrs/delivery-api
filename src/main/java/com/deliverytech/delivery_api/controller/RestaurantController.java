package com.deliverytech.delivery_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.service.RestaurantService;
import com.deliverytech.delivery_api.dto.RestaurantDto;


@RestController
@RequestMapping("/api/av1/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.findAll();
    }   
}
