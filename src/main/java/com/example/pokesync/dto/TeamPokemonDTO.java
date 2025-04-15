package com.example.pokesync.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TeamPokemonDTO {
    private int pokemonId;
    private String name;
    private List<String> types;
}
