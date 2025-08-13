package com.deliverytech.delivery_api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long id;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    public OrderItemDto() {
        super();
    }

    public OrderItemDto(Long id, int quantity, BigDecimal unitPrice, BigDecimal subtotal) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }    
}
