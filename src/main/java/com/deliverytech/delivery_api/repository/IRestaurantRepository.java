package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.entity.Restaurant;

public interface IRestaurantRespository extends JpaRepository<Restaurant, Long> {

}
