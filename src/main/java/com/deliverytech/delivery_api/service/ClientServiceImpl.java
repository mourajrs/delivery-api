package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ChangeStatusDto;
import com.deliverytech.delivery_api.dto.ClientDto;
import com.deliverytech.delivery_api.entity.Client;
import com.deliverytech.delivery_api.exceptions.ConflictException;
import com.deliverytech.delivery_api.repository.ClientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientServiceImpl() {
        super();
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {

        boolean emailExists = repository.existsByEmail(clientDto.getEmail());

        if (emailExists) {
            throw new ConflictException(
                    "Já existe um cliente com este email",
                    "email",
                    clientDto.getEmail());
        }

        try {
            ModelMapper modelMapper = new ModelMapper();
            Client client = modelMapper.map(clientDto, Client.class);            
            return modelMapper.map(repository.save(client), ClientDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto, Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client não encontrado com ID: " + id));
        client.setId(id);
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setFone(clientDto.getFone());
        client.setAddress(clientDto.getAddress());
        client.setActive(clientDto.isActive());
        repository.save(client);
        return clientDto;
    }

    @Override
    public ClientDto findClientById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(client, ClientDto.class);
    }

    @Override
    public List<ClientDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return repository.findAll().stream().map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findByEmail(String email) {
        Client client = repository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com email: " + email));
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(client, ClientDto.class);
    }

    @Override
    @Transactional
    public void changeStatus(ChangeStatusDto dto) {
        boolean updated = repository.changeStatus(dto.getEmail(), dto.isNewStatus());

        if (!updated) {
            throw new EntityNotFoundException("Cliente nao encontrado com email: " + dto.getEmail());
        }
    }

}
