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

    public ClientDto() {
        super();
    }

    public ClientDto(Long id, String name, String email, String fone, String address, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.fone = fone;
        this.address = address;
        this.active = active;
    }
}
