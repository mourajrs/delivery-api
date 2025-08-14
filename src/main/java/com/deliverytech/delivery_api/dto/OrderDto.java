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
}
