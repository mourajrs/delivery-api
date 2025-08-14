package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.ClientDto;
import com.deliverytech.delivery_api.service.ClientService;

@CrossOrigin(origins = "*")
 
@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping("/findAll")
    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.findAll();
    }    
}
