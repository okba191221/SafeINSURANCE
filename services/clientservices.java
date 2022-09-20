/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.services;

import safeinsurance.entities.clients ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import safeinsurance.tools.MyConnection;

/**
 *
 * @author Win11
 */
public class clientservices {
      Connection cnx=MyConnection.getInstance().getCnx() ;
    
public clientservices(){
    
}   
      
       
         public void ajouterclient(clients c){
        String sql="insert into clients(cin,nom,prenom,tel,mdp,role,email,immatricule,num_Permis,Délivré_le) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, c.getCin());
            ste.setString(2, c.getNom());
            ste.setString(3, c.getPrenom());
            ste.setInt(4, c.getTel());
            ste.setString(5, c.getMdp());
            ste.setString(6, c.getRole());
            ste.setString(7, c.getEmail());
            ste.setString(8, c.getImmatricule());
            ste.setInt(9, c.getNum_Permis());
            ste.setDate(10, c.getDélivré_le ());
            ste.executeUpdate();
            System.out.println("tzed !!!");
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
            System.out.println("ma tzedech ");
        }
        
    }
         public List<clients> afficherclient(){
        List<clients> client = new ArrayList<>();
        String sql ="select * from clients";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                clients c = new clients();
                 c.setCin(rs.getInt("cin"));
                c.setImmatricule(rs.getString("immatricule"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setTel(rs.getInt("tel"));
                c.setDélivré_le(rs.getDate("Délivré_le"));
                c.setMdp(rs.getString("mdp"));
                c.setRole(rs.getString("role"));
                c.setEmail(rs.getString("email"));
                c.setNum_Permis(rs.getInt("Num_Permis"));
                client.add(c);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
            System.out.println("manwarich");
        }
        
        return client;
    }

         
}
