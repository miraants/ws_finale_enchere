package com.example.webservice.controller;

import com.example.webservice.TpWsApplication;
import com.example.webservice.connection.ConnectDB;
import com.example.webservice.exception.CategorieNotFoundException;
import com.example.webservice.model.Manao_enchere;
import com.example.webservice.model.Participant_enchere;
import com.example.webservice.repository.Manao_enchereRepository;
import com.example.webservice.repository.ParticipantEnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/participant_enchere")

public class ParticipantEnchereController {
    @Autowired
    private ParticipantEnchereRepository pe;

   /* @GetMapping("/list")
    public ArrayList<Participant_enchere> getParticipantEnchere() throws SQLException {
        ArrayList<Participant_enchere> pe = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        conn = postgreSQL.getConnection();
        String sql = "select * from participant_enchere";
        stmt = conn.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        while(resultSet.next()) {
            Participant_enchere cat = new Participant_enchere(resultSet.getInt(1), resultSet.getInt(2),resultSet.getDouble(3),resultSet.getDate(4));
            pe.add(cat);
        }
        return pe;
    }

    @GetMapping("/insert/{id_utilisateur}/{id_manao_enchere}/{prix}/{daty}")
    public void insertParticipant(@PathVariable Integer id_utilisateur, @PathVariable Integer id_manao_enchere, @PathVariable Double prix, @PathVariable Date daty) throws SQLException {
        String sql = "insert into participant_enchere  values (default,'"+id_utilisateur+"','"+id_manao_enchere+"','"+prix+"','"+daty+"')";
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
    }*/

    @GetMapping("/list/{id}")
    public ResponseEntity<Participant_enchere> getParticipant(@PathVariable Integer id){
        Participant_enchere r=pe.findById(id).orElseThrow(() -> new CategorieNotFoundException(("Categorie not exist with id :" + id)));
        return ResponseEntity.ok(r);
    }
    @GetMapping("/list")
    public ResponseEntity <List<Participant_enchere>> getAllParticipant() {
        List<Participant_enchere> cat= pe.findAll();
        return ResponseEntity.ok(cat);
    }

}
