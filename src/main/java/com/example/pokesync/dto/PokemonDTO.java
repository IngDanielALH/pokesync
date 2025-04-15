package com.example.pokesync.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PokemonDTO {
    private Integer id;
    private String name;
    private List<String> types;
    private Float height;
    private Float weight;
}
