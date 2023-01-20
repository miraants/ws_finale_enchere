package com.example.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Manao_enchere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_manao_enchere;
    private int id_utilisateur;
    private int id_produit;
    private int statut;
    private Date daty;
    private int duree;
    private Double commission;



}
