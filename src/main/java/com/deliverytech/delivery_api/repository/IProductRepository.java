package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {    

}
