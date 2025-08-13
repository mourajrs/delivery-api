package com.deliverytech.delivery_api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private String deliveryAddress;
    private BigDecimal subtotal;
    private BigDecimal deliveryFee;
    private BigDecimal totalAmount;

    public OrderDto() {
        super();
    }

    public OrderDto(Long id, String deliveryAddress, BigDecimal subtotal, BigDecimal deliveryFee, BigDecimal totalAmount) {
        this.id = id;
        this.deliveryAddress = deliveryAddress;
        this.subtotal = subtotal;
        this.deliveryFee = deliveryFee;
        this.totalAmount = totalAmount;
    }
}
