package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.RestaurantDto;
import com.deliverytech.delivery_api.service.RestaurantService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
 
@RestController
@RequestMapping("/api/av1/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
        
    @PostMapping("/create")
    public ResponseEntity<Long> create(@Valid @RequestBody RestaurantDto dto) {
        Long id = restaurantService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }    

    @GetMapping("/findByRestaurant")
    public ResponseEntity<RestaurantDto> findByRestaurant(String restaurant) {
        RestaurantDto dto = restaurantService.findByRestaurant(restaurant);
        
        if(dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/findById")
    public ResponseEntity<RestaurantDto> findById(Long id) {
        RestaurantDto dto = restaurantService.findById(id);
        
        if(dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/findAll")
    public List<RestaurantDto> findAll() {
        return restaurantService.findAll();
    }
}
