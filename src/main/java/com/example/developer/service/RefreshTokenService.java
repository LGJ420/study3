package com.example.developer.service;

import org.springframework.stereotype.Service;

import com.example.developer.domain.RefreshToken;
import com.example.developer.repository.RefreshTokenRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {

        return refreshTokenRepository.findByRefreshToken(refreshToken)
            .orElseThrow(()->new IllegalArgumentException("Unexpected token"));
    }
}
