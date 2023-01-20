package com.example.webservice.repository;

import com.example.webservice.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
