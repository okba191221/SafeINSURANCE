/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import safeinsurance.entites.Assurances;
import safeinsurance.tools.MyConnection;

/**
 *
 * @author Adminstrateur
 */
public class RechercheService {

    Connection cnx = MyConnection.getInstance().getCnx();

    public RechercheService() {
    }

    public List<Assurances> afficherassurancee() {
        List<Assurances> recherche = new ArrayList<>();
        String sql = "select id_assurance,cin_client,immatricule_voiture,type from assurances WHERE assurances.cin_client = clients.cin andassurances.immatricule_voiture  véhicules.immatricule";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                Assurances A = new Assurances();
                A.setId_assurance(rs.getString("id_assurance"));
                A.setCin_client(rs.getInt("cin_client"));
                A.setImmatricule_voiture(rs.getString("immatricule_voiture"));
                A.setType(rs.getString("type"));
               
                recherche.add(A);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreur");
        }

        return recherche;
    }


 
}
