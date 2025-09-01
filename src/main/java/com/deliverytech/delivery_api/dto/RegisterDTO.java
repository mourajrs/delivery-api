package com.deliverytech.delivery_api.dto;

import com.deliverytech.delivery_api.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
