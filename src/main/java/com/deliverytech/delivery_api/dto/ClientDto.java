package com.deliverytech.delivery_api.dto;

import lombok.Data;

@Data
public class ClientDto {
    private Long id;
    private String name;
    private String email;
    private String fone;
    private String address;
    private boolean active;    
}
