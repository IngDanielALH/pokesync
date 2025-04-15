package com.example.pokesync.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "team")
public class TeamMember {
    @Id
    private String id;

    private String userEmail;
    private int pokemonId;
    private String name;
    private List<String> types;
}
