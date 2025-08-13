package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.entity.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

}
