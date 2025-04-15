package com.example.pokesync.repository;

import com.example.pokesync.model.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TeamRepository extends MongoRepository<TeamMember, String> {
    List<TeamMember> findByUserEmail(String userEmail);
}
