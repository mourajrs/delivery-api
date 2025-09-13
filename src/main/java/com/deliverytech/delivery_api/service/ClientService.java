package com.deliverytech.delivery_api.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ChangeStatusDto;
import com.deliverytech.delivery_api.dto.ClientDto;

@Service
public interface ClientService {
    public ClientDto createClient(ClientDto clientDto);

    public ClientDto updateClient(ClientDto clientDto, Long id);

    public ClientDto findClientById(Long id);

    public List<ClientDto> findAll();

    public ClientDto findByEmail(String email);

    public void changeStatus(ChangeStatusDto dto);
}
