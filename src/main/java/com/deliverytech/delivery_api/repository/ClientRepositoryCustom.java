package com.deliverytech.delivery_api.repository;

import java.util.Optional;

import com.deliverytech.delivery_api.entity.Client;

public interface ClientRepositoryCustom {
    Optional<Client> findByEmail(String email);       
    Boolean changeStatus(String email, boolean newStatus);
    Boolean existsByEmail(String name);
}
