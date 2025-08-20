package com.deliverytech.delivery_api.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.entity.Client;

import jakarta.persistence.EntityManager;

@Repository
public class ClientRepositoryImpl implements IClientRepositoryCustom{

    private EntityManager entityManager;

    @Override
    public List<Client> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    
}
