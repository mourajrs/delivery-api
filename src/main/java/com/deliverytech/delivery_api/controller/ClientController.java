package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deliverytech.delivery_api.dto.ClientDto;
import com.deliverytech.delivery_api.service.ClientService;

// import io.swagger.v3.oas.annotations.responses.ApiResponse;
// import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/findAll")
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @PostMapping("/create")
    // @ApiResponses(value = {
    //         @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
    //         @ApiResponse(responseCode = "400", description = "Dados inválidos"),
    //         @ApiResponse(responseCode = "409", description = "Cliente já existe")
    // })
    public ResponseEntity<Long> createClient(@Valid @RequestBody ClientDto dto) {
        Long id = clientService.createClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
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
}
