package com.deliverytech.delivery_api.dto;

import lombok.Data;

@Data
public class RestaurantDto {
    private Long id;
    private String name;
    private String description;     

    @Override
    public String toString() {
        return "RestaurantDTO{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
               
}
