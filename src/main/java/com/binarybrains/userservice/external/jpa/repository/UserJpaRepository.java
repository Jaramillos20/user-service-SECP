package com.binarybrains.userservice.external.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarybrains.userservice.external.jpa.entity.UserJpa;

public interface  UserJpaRepository extends JpaRepository<UserJpa, Integer> {
    
}
