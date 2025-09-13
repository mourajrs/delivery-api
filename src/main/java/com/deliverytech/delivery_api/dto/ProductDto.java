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

    public ProductDto() {
        super();
    }

    // Overload
    public ProductDto( String name, BigDecimal price, String category, String description, String disponibility) {        
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.disponibility = disponibility;        
    }
}
