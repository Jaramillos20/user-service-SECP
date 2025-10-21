package com.binarybrains.userservice.external.jpa.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.binarybrains.userservice.core.buisness.output.UserRepository;
import com.binarybrains.userservice.core.entity.User;
import com.binarybrains.userservice.external.jpa.entity.UserJpa;
import com.binarybrains.userservice.external.jpa.repository.UserJpaRepository;

@Repository
public class UserDao implements UserRepository{

    private final UserJpaRepository userJpaRepository;
    public UserDao(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userJpaRepository.findById(id).map(UserJpa::toEntity);
    }   
}