package com.deliverytech.delivery_api.dto;

import lombok.Data;

@Data
public class RestaurantDto {
    private Long id;
    private String name;
    private String description;   
    
    public RestaurantDto() {
        super();
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               '}';
    }

    public RestaurantDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;       
    }            
}
