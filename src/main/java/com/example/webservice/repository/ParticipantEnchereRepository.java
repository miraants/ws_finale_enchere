package com.example.webservice.repository;

import com.example.webservice.model.Participant_enchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantEnchereRepository extends JpaRepository<Participant_enchere, Integer> {
}
