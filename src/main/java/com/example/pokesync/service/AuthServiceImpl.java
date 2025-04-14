package com.example.pokesync.service;

import com.example.pokesync.dto.AuthRequest;
import com.example.pokesync.dto.AuthResponse;
import com.example.pokesync.dto.RegisterRequest;
import com.example.pokesync.model.Trainer;
import com.example.pokesync.repository.TrainerRepository;
import com.example.pokesync.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private TrainerRepository trainerRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (trainerRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        Trainer trainer = Trainer.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .team(Collections.emptyList())
                .build();

        trainerRepository.save(trainer);

        String token = jwtService.generateToken(trainer);
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(AuthRequest request){
        Trainer trainer = trainerRepository.findByEmail(request.getEmail());
        if (trainer == null || !passwordEncoder.matches(request.getPassword(), trainer.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(trainer);
        return new AuthResponse(token);
    }
}
