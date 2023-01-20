package com.example.webservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "v_liste_enchere")
@Immutable

public class Liste_Enchere {
@Id
    private String nom_user;
    private String nom_produit;
    private Double prix_min;
    private String nom_categorie;
    private Date daty;
    private int duree;
    private Double commission;
}
