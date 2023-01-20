package com.example.webservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor

public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id_categorie;

   private String nom_categorie;
}
