package com.example.pokesync.service;

import com.example.pokesync.dto.PokemonDTO;
import com.example.pokesync.dto.TeamPokemonDTO;
import com.example.pokesync.model.TeamMember;
import com.example.pokesync.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final PokemonService pokemonService;

    @Autowired
    public TeamService(TeamRepository teamRepository, PokemonService pokemonService) {
        this.teamRepository = teamRepository;
        this.pokemonService = pokemonService;
    }

    public TeamMember addPokemonToTeam(String pokemonName, String userEmail) {
        PokemonDTO pokemon = pokemonService.getPokemonByName(pokemonName);

        TeamMember member = TeamMember.builder()
                .userEmail(userEmail)
                .pokemonId(pokemon.getId())
                .name(pokemon.getName())
                .types(pokemon.getTypes())
                .build();

        return teamRepository.save(member);
    }

    public List<TeamPokemonDTO> getUserTeam(String email) {
        return teamRepository.findByUserEmail(email)
                .stream()
                .map(member -> {
                    TeamPokemonDTO dto = new TeamPokemonDTO();
                    dto.setPokemonId(member.getPokemonId());
                    dto.setName(member.getName());
                    dto.setTypes(member.getTypes());
                    return dto;
                })
                .toList();
    }
}
