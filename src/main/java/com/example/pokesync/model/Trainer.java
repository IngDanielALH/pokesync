package com.example.pokesync.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "trainers")
public class Trainer {
    @Id
    private String id;
    private String email;
    private String password;
    private List<Pokemon> team;
}
