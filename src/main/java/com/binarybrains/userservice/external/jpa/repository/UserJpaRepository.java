package com.binarybrains.userservice.external.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binarybrains.userservice.external.jpa.entity.UserJpa;

@Repository
public interface  UserJpaRepository extends JpaRepository<UserJpa, Integer> {
    
}
