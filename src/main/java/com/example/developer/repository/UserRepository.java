package com.example.developer.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.developer.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
}
