package com.example.webservice.controller;

import com.example.webservice.exception.ResourceNotFoundException;
import com.example.webservice.repository.AdminRepository;
import com.example.webservice.repository.RechargementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.webservice.model.Admin;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private RechargementRepository rechargementRepository;
    private AdminRepository admin;
    public ResponseEntity find(int idadmin)
    {
        Admin a= admin.findById(idadmin).orElseThrow(() -> new ResourceNotFoundException("Rechargement not exist with id: " + idadmin));
        return ResponseEntity.ok(a);
    }

    /*@PutMapping("{id}")
    public ResponseEntity<Rechargement> updateRecharge(@PathVariable Integer id){
        Rechargement updateRechargement= rechargementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rechargement not exist with id: " + id));

        updateRechargement.setStatut(1);

        rechargementRepository.save(updateRechargement);
        return ResponseEntity.ok(updateRechargement);

    }
    @PutMapping("{id}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable long id,int a){
        Utilisateur updateUtilisateur= utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rechargement not exist with id: " + id));
        Rechargement updateRechargement= rechargementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rechargement not exist with id: " + id));

        updateUtilisateur.setValeur(updateUtilisateur.getValeur()+updateRechargement.getValeur());

        utilisateurRepository.save(updateUtilisateur);
        return ResponseEntity.ok(updateUtilisateur);
    }*/


}
