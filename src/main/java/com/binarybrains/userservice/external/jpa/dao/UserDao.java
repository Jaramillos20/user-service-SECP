package com.binarybrains.userservice.external.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.binarybrains.userservice.core.buisness.output.UserRepository;
import com.binarybrains.userservice.core.entity.User;
import com.binarybrains.userservice.external.jpa.entity.UserJpa;
import com.binarybrains.userservice.external.jpa.repository.UserJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class UserDao implements UserRepository{

    private final UserJpaRepository userJpaRepository;
    private final EntityManager entityManagerReading;
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM ec01_users WHERE tx_email =:email";
    public UserDao(UserJpaRepository userJpaRepository, EntityManager entityManagerReading) {
        this.userJpaRepository = userJpaRepository;
        this.entityManagerReading = entityManagerReading;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userJpaRepository.findById(id).map(UserJpa::toEntity);
    }

    @Override
    public Optional<User> save(User user) {
       return Optional.of(userJpaRepository.save(UserJpa.fromEntity(user)).toEntity());
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackOn = Exception.class)
    public Optional<List<User>> findByEmail(String email) {
        return Optional.of((List<User>) entityManagerReading.createNativeQuery(GET_USER_BY_EMAIL, UserJpa.class)
            .setParameter("email", email)
            .getResultList()
            .stream()
            .map(object -> ((UserJpa) object).toEntity()).toList());
    }   
}

