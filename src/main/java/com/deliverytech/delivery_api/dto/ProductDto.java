package com.deliverytech.delivery_api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {    
    private String name;
    private BigDecimal price;
    private String category;
    private String description;
    private String disponibility;    
}
