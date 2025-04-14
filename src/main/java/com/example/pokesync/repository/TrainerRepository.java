package com.example.pokesync.repository;

import com.example.pokesync.model.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainerRepository extends MongoRepository<Trainer, String> {
    boolean existsByEmail(String email);
    Trainer findByEmail(String email);
}
