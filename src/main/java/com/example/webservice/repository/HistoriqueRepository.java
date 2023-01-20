package com.example.webservice.repository;

import com.example.webservice.model.Categorie;
import com.example.webservice.model.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Integer> {
}
