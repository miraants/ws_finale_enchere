package com.example.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Produit {
    private int id_produit;
    private String nom_produit;
    private int id_categorie;
    private Double prix_min;

}
