package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.OrderItemDto;
import com.deliverytech.delivery_api.repository.IOrderItemRepository;

@Service
public class OrderItemService {
    @Autowired
    private IOrderItemRepository repository;

    public OrderItemService(IOrderItemRepository repository) {
        this.repository = repository;
    }

    public OrderItemService() {
        super();
    }

    public List<OrderItemDto> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDto).collect(Collectors.toList());
    }

    public OrderItemDto ConvertEntityToDto(com.deliverytech.delivery_api.entity.OrderItem entity) {
        OrderItemDto dto = new OrderItemDto();
        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setSubtotal(entity.getSubtotal());
        return dto;
    }
}
