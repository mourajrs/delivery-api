package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    UserDetails findByLogin(String login);
}
