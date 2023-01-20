package com.example.webservice.controller;

import com.example.webservice.TpWsApplication;
import com.example.webservice.connection.ConnectDB;
import com.example.webservice.exception.ResourceNotFoundException;
import com.example.webservice.model.Admin;
import com.example.webservice.model.Rechargement;
import com.example.webservice.model.Utilisateur;
import com.example.webservice.repository.AdminRepository;
import com.example.webservice.repository.RechargementRepository;
import com.example.webservice.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository use;


   /* @GetMapping("/login/{email}/{mdp}")
    public Utilisateur checkCandidat(@PathVariable String email,@PathVariable String mdp) throws SQLException {
        Utilisateur utilisateur =null;

        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from utilisateur where email='"+email+"' and mdp='"+mdp+"'";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                utilisateur= new Utilisateur(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5));

            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return utilisateur;
    }
    @GetMapping("/list")
    public ArrayList<Utilisateur> getUser() throws SQLException {
        ArrayList<Utilisateur> utilisateur = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from utilisateur";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                Utilisateur rec = new Utilisateur(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5));
                utilisateur.add(rec);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return utilisateur;
    }*/
   @PostMapping("/login")
    public ResponseEntity<Utilisateur> find(@RequestBody Utilisateur u)
    {

        Utilisateur a= use.findUtilisateurByEmailAndMdp(u.getEmail(),u.getMdp());
        return ResponseEntity.ok(a);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Utilisateur>> getAllUser() {
        List<Utilisateur> cat= use.findAll();
        return ResponseEntity.ok(cat);
    }

}
