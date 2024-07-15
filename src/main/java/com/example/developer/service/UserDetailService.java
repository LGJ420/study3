package com.example.developer.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.developer.domain.User;
import com.example.developer.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService{
    
    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email){

        return userRepository.findByEmail(email).orElseThrow(()->new IllegalArgumentException(email));
    }

}
