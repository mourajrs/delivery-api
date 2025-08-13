package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.OrderDto;
import com.deliverytech.delivery_api.entity.Order;
import com.deliverytech.delivery_api.repository.IOrderRepository;

@Service
public class OrderService {
    @Autowired
    private IOrderRepository repository;

    public OrderService(IOrderRepository repository) {
        this.repository = repository;
    }

    public OrderService() {
        super();
    }

    public List<OrderDto> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDto).collect(Collectors.toList());
    }

    private OrderDto ConvertEntityToDto(Order entity) {
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        dto.setDeliveryAddress(entity.getDeliveryAddress());
        dto.setSubtotal(entity.getSubtotal());
        dto.setDeliveryFee(entity.getDeliveryFee());
        dto.setTotalAmount(entity.getTotalAmount());
        return dto;
    }
}
