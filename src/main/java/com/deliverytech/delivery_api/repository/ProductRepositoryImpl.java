package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ProductRepositoryImpl implements IProductRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findByRestaurantId(Long restauranteId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findByRestaurantId'");
        return null;
    }

    @Override
    public List<Product> findByDisponibilityIsTrue() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findByAvailableIsTrue'");
        return null;
    }

    @Override
    public List<Product> findByCategory(String category) {        
        String formattedString = String.format("select * from Product where category = '%param'", category);
        TypedQuery<Product> query = entityManager.createQuery(formattedString, Product.class);
        return query.getResultList();
    }

    @Override    
    public List<Product> findByPriceLessThanEqual(BigDecimal price) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findByPriceLessThanEqual'");
        return null;
    }   

}
