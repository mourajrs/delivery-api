package com.deliverytech.delivery_api.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    UserDetails findByLogin(String login);
}
