package com.example.pokesync.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AuthRequest {
    private String email;
    private String password;
}

