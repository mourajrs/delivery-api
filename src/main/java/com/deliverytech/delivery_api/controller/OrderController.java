package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.OrderDto;
import com.deliverytech.delivery_api.service.OrderService;

@CrossOrigin(origins = "*")
 
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll")
    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.findAll();
    }
}
