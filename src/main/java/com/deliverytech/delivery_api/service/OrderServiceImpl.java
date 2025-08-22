package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.OrderDto;
import com.deliverytech.delivery_api.entity.Order;
import com.deliverytech.delivery_api.repository.IOrderRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private IOrderRepository repository;

    public OrderServiceImpl(IOrderRepository repository) {
        this.repository = repository;
    }

    public OrderServiceImpl() {
        super();
    }

    public Order create(OrderDto dto) {
        return null;
    }

    
}
