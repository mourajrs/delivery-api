package com.deliverytech.delivery_api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.entity.Restaurant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Restaurant> findByRated(String rated) {
        String formattedString = String.format("select * from Restaurant where rated = '%param'", rated);
        TypedQuery<Restaurant> query = entityManager.createQuery(formattedString, Restaurant.class);
        return query.getResultList();
    }           
}
