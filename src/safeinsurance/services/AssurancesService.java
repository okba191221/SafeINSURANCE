/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class AssurancesService {

    Connection cnx = MyConnection.getInstance().getCnx();

    public AssurancesService() {
    }

    public void ajouterassurance(Assurances A) {
        String sql = "insert into assurances( id_assurance,  immatricule_voiture,  type,  cin_client,  montant) values (?,?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, A.getId_assurance());
            ste.setString(2, A.getImmatricule_voiture());
            ste.setString(3, A.getType());
            ste.setInt(4, A.getCin_client());
            ste.setFloat(5, A.getMontant());

            ste.executeUpdate();
            System.out.println("OK!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("NO ");
        }

    }

    public List<Assurances> afficherassurance() {
        List<Assurances> assurances = new ArrayList<>();
        String sql = "select * from assurances";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                Assurances A = new Assurances();
                A.setId_assurance(rs.getString("id_assurance"));
                A.setCin_client(rs.getInt("cin_client"));
                A.setImmatricule_voiture(rs.getString("immatricule_voiture"));
                A.setType(rs.getString("type"));
                A.setMontant(rs.getFloat("montant"));

                assurances.add(A);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("emmmmm");
        }

        return assurances;
    }

    public void supprimervehicule(Assurances A) {
        String sql = "DELETE FROM assurances WHERE id_assurance  = ?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, A.getId_assurance());

            ste.executeUpdate();
            System.out.println("OK!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("NO ");
        }

    }
}
