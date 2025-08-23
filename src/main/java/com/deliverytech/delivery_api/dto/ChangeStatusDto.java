package com.deliverytech.delivery_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChangeStatusDto {
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    private boolean newStatus;
}
