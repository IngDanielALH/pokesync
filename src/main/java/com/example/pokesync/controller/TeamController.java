package com.example.pokesync.controller;

import com.example.pokesync.dto.TeamPokemonDTO;
import com.example.pokesync.model.TeamMember;
import com.example.pokesync.service.TeamService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")

public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/add")
    public ResponseEntity<TeamMember> addToTeam(@RequestParam String name, HttpServletRequest request) {
        String email = request.getUserPrincipal().getName(); // JWT ya puso al user
        TeamMember added = teamService.addPokemonToTeam(name, email);
        return ResponseEntity.ok(added);
    }

    @GetMapping
    public ResponseEntity<List<TeamPokemonDTO>> getTeam(HttpServletRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(teamService.getUserTeam(email));
    }
}
