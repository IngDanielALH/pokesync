package com.example.pokesync.service;

import com.example.pokesync.dto.PokemonDTO;
import com.example.pokesync.util.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    private final RestTemplate restTemplate = new RestTemplate();

    public PokemonDTO getPokemonByName(String name) {
        URI uri = URI.create(Constants.POKEAPI_URL + name.toLowerCase());

        try {
            String response = restTemplate.getForObject(uri, String.class);

            JSONObject json = new JSONObject(response);

            PokemonDTO dto = new PokemonDTO();
            dto.setName(json.getString("name"));
            dto.setId(json.getInt("id"));
            dto.setHeight(json.getInt("height"));
            dto.setWeight(json.getInt("weight"));


            List<String> types = new ArrayList<>();
            json.getJSONArray("types").forEach(item -> {
                JSONObject typeObj = (JSONObject) ((JSONObject) item).get("type");
                types.add(typeObj.getString("name"));
            });
            dto.setTypes(types);

            return dto;

        } catch (Exception e) {
            throw new RuntimeException("No se encontró el pokémon: " + name, e);
        }
    }
}
