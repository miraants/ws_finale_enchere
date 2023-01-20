package com.example.webservice.repository;

import com.example.webservice.model.Rechargement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository  extends JpaRepository<Rechargement, Integer> {
}
