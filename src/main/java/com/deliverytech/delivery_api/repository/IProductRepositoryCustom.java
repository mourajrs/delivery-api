package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;

import com.deliverytech.delivery_api.entity.Product;

public interface IProductRepositoryCustom {
    
    List<Product> findByRestaurantId(Long restauranteId);

    List<Product> findByDisponibilityIsTrue();

    List<Product> findByCategory(String category);

    List<Product> findByPriceLessThanEqual(BigDecimal price);
}
