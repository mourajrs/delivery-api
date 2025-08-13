package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {

}
