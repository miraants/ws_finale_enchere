package com.example.webservice.controller;

import com.example.webservice.TpWsApplication;
import com.example.webservice.connection.ConnectDB;
import com.example.webservice.exception.CategorieNotFoundException;
import com.example.webservice.model.Categorie;
import com.example.webservice.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/categorie")
public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;

   /* @GetMapping("/list")
    public ArrayList<Categorie> getCategorie() throws SQLException {
        ArrayList<Categorie> categorie = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from categorie";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                Categorie cat = new Categorie(resultSet.getInt(1), resultSet.getString(2));
                categorie.add(cat);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return categorie;
    }

    @GetMapping("/insert/{nom}")
    public Object insertCategorie(@PathVariable String nom) throws SQLException {
        String sql = "insert into categorie  values (default,'"+nom+"')";
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;

        Statement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate("commit");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return null;
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

    @GetMapping("/list/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id){
        Categorie r=categorieRepository.findById(id).orElseThrow(() -> new CategorieNotFoundException(("Categorie not exist with id :" + id)));
        return ResponseEntity.ok(r);
    }
    @GetMapping("/list")
    public ResponseEntity <List<Categorie>> getAllCategorie() {
        List<Categorie> cat= categorieRepository.findAll();
        return ResponseEntity.ok(cat);
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Categorie c){
        categorieRepository.save(c);
        return ResponseEntity.ok("success");
    }

}
