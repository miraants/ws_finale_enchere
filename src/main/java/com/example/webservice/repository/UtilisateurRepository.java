package com.example.webservice.repository;

import com.example.webservice.model.Admin;
import com.example.webservice.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Integer> {
    public Utilisateur findUtilisateurByEmailAndMdp(String email,String mdp);
}
