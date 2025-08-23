package com.deliverytech.delivery_api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderDto {
    @NotNull(message = "Produto ID é obrigatório")
    @Positive(message = "Produto ID deve ser positivo")
    private Long id;
    
    private String deliveryAddress;
    private BigDecimal subtotal;
    private BigDecimal deliveryFee;    
    private BigDecimal totalAmount;

    @NotNull(message = "Quantidade é obrigatória")
    @Min(value = 1, message = "Quantidade deve ser pelo menos 1")    
    private int quantity;

    @Size(max = 200, message = "Observações não podem exceder 200 caracteres")
    private String observation;
}
