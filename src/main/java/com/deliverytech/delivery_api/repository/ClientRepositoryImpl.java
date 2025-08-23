package com.deliverytech.delivery_api.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.entity.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ClientRepositoryImpl implements ClientRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<Client> findByEmail(String email) {
        String sql = "select c from Client c where c.email = :email";
        TypedQuery<Client> query = entityManager.createQuery(sql, Client.class);
        query.setParameter("email", email);

        return query.getResultStream().findFirst();
    }

    @Override
    public Boolean existsByEmail(String email) {
        String sql = "select count(c) from Client c where c.email = :email";
        TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
        query.setParameter("email", email);
        return query.getSingleResult() > 0;
    }

    @Override
    @Transactional
    public Boolean changeStatus(String email, boolean newStatus) {
        String jpql = "UPDATE Client c SET c.active = :active WHERE c.email = :email";

        int rowsAffected = entityManager.createQuery(jpql)
                .setParameter("active", newStatus)
                .setParameter("email", email)
                .executeUpdate();

        return rowsAffected > 0;
    }

}
