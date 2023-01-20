package com.example.webservice.repository;

import com.example.webservice.model.Categorie;
import com.example.webservice.model.Liste_Enchere;
import com.example.webservice.model.Manao_enchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Liste_EnchereRepository extends JpaRepository<Liste_Enchere, Integer> {
}
