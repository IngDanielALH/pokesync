package com.example.pokesync.service;

import com.example.pokesync.dto.AuthRequest;
import com.example.pokesync.dto.AuthResponse;
import com.example.pokesync.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}
