package com.deliverytech.delivery_api.repository;

import java.util.List;

import com.deliverytech.delivery_api.entity.Client;

public interface IClientRepositoryCustom {

    List<Client> findByName(String name);   

}
