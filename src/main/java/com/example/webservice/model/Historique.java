package com.example.webservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="v_historique_enchere")
@Immutable
public class Historique {

    @Id
    private int id_utilisateur;
    private String nom;
    private String day;
    private String prix;
}
