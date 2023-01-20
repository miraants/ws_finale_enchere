package com.example.webservice.controller;

import com.example.webservice.TpWsApplication;
import com.example.webservice.connection.ConnectDB;
import com.example.webservice.model.Historique;
import com.example.webservice.model.Liste_Enchere;

import com.example.webservice.model.Manao_enchere;
import com.example.webservice.repository.HistoriqueRepository;
import com.example.webservice.repository.Liste_EnchereRepository;
import com.example.webservice.repository.Manao_enchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/liste_enchere")
public class ListeEnchereController {

    @Autowired
    private Liste_EnchereRepository listeEnchere;

   /*  @GetMapping
   public ArrayList<Liste_Enchere> getManao_enchere() throws SQLException {
        ArrayList<Liste_Enchere> liste_enchere = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from v_liste_enchere";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                Liste_Enchere rec = new Liste_Enchere(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4), resultSet.getDate(5),resultSet.getInt(6),resultSet.getDouble(7));
                liste_enchere.add(rec);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return liste_enchere;
    }*/

    @GetMapping("/list")
    public ResponseEntity<List<Liste_Enchere>> getAllManaoEnchere() {
        List<Liste_Enchere> cat= listeEnchere.findAll();
        return ResponseEntity.ok(cat);
    }




}
