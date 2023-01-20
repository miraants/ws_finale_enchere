package com.example.webservice.controller;

import com.example.webservice.TpWsApplication;
import com.example.webservice.connection.ConnectDB;
import com.example.webservice.exception.CategorieNotFoundException;
import com.example.webservice.model.Participant_enchere;
import com.example.webservice.model.Rechargement;
import com.example.webservice.model.Utilisateur;
import com.example.webservice.repository.RechargementRepository;
import com.example.webservice.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/rechargement")
public class RechargementController {
    @Autowired
    private RechargementRepository rechargementRepository;

    @Autowired
    private UtilisateurRepository user;

    @PostMapping("/insert")
    public Rechargement createRechargement(@RequestBody Rechargement rechargement){
        return rechargementRepository.save(rechargement);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Rechargement>> getAllRechargement() {
        List<Rechargement> cat= rechargementRepository.findAll();
        return ResponseEntity.ok(cat);
    }

    @GetMapping("/list/{id}")
    public String updateRechargement(@PathVariable("id") int id_utilisateur){
        Rechargement r=rechargementRepository.findTopById_utilisateurOrderById_rechargementDesc(id_utilisateur);
        Utilisateur u=user.findById(id_utilisateur).orElseThrow(() -> new CategorieNotFoundException(("Categorie not exist with id :" + id_utilisateur)));
        u.setValeur(u.getValeur()+r.getValeur());
        user.save(u);
        r.setStatut(1);
        rechargementRepository.save(r);
        String text="updateeed";
        return text;

    }


/*
    @GetMapping
    public List<Rechargement> getAllRechargement(){
        return rechargementRepository.findAll();
    }

    @PostMapping("/insert")
    public Rechargement createRechargement(@RequestBody Rechargement rechargement){
        return rechargementRepository.save(rechargement);
    }

    @GetMapping("/list")
    public ArrayList<Rechargement> getRechargement() throws SQLException {
        ArrayList<Rechargement> rechargement = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from rechargement";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                Rechargement rec = new Rechargement(resultSet.getInt(1), resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4));
                rechargement.add(rec);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return rechargement;
    }

    @GetMapping("/insert/{valeur}/{id_utilisateur}")
    public Object insertRechargement(@PathVariable int valeur,@PathVariable int id_utilisateur) throws SQLException {
        String sql = "insert into rechargement (valeur,id_utilisateur,statut) values ("+valeur+","+id_utilisateur+",0)";
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

    @GetMapping("/update/{id_utilisateur}/{somme}")
    public Object updateRechargement(@PathVariable int id_utilisateur,@PathVariable int somme) throws SQLException {
        String sql = "update rechargement set statut=1 where id_utilisateur="+id_utilisateur;
        String sql2="update utilisateur set valeur=(valeur+"+somme+") where id_utilisateur="+id_utilisateur;
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;

        Statement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
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
*/

}
