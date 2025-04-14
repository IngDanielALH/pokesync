package com.example.pokesync.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RegisterRequest {
    private String email;
    private String password;
}

