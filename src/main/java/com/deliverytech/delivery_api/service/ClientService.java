package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ClientDto;
import com.deliverytech.delivery_api.entity.Client;
import com.deliverytech.delivery_api.repository.IClientRepository;

@Service
public class ClientService {
    @Autowired
    private IClientRepository repository;

    public ClientService(IClientRepository repository) {
        this.repository = repository;
    }

    public ClientService() {
        super();
    }

    public List<ClientDto> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDto).collect(Collectors.toList());
    }

    private ClientDto ConvertEntityToDto(Client entity) {
        ClientDto dto = new ClientDto();
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setFone(entity.getFone());
        dto.setAddress(entity.getAddress());
        dto.setActive(entity.isActive());
        return dto;
    }
}
