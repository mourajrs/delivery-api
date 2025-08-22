package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryCustom {

    
}
