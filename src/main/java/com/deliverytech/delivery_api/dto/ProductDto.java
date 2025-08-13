package com.deliverytech.delivery_api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private String description;
    private String disponibility;

    public ProductDto() {
        super();
    }

    public ProductDto(Long id, String name, BigDecimal price, String category, String description, String disponibility) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.disponibility = disponibility;
    }
}
