package com.deliverytech.delivery_api.controller;

import java.security.Security;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.ChangeStatusDto;
import com.deliverytech.delivery_api.dto.ClientDto;
import com.deliverytech.delivery_api.infra.security.SecurityConfigurations;
import com.deliverytech.delivery_api.service.ClientService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/api/v1/client")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
@Tag(name = "Área do Cliente - Protegida")
public class ClientController {  
    @Autowired
    private ClientService clientService;

    @GetMapping("/findAll")
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @PostMapping("/create")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "409", description = "Cliente já existe")
    })
    public ResponseEntity <ClientDto> createClient(@Valid @RequestBody ClientDto dto) {
        ClientDto clientDto = clientService.createClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDto);
    }

    @PatchMapping("/{id}/client")
    public ResponseEntity<ClientDto> updateClient(Long id, @RequestBody ClientDto dto) {
        ClientDto clientDto = clientService.updateClient(dto, id);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<ClientDto> findByEmail(String email) {
        ClientDto clientDto = clientService.findByEmail(email);
        return ResponseEntity.ok(clientDto);
    }


    @PatchMapping("/changeStatus")
    public ResponseEntity<String> changeStatus(@Valid @RequestBody ChangeStatusDto dto) {
        clientService.changeStatus(dto);
        return ResponseEntity.ok("Status alterado com sucesso");
    }
}
