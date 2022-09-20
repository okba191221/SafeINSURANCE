/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.Data;
import safeinsurance.entites.Vehicule;
import safeinsurance.tools.MyConnection;

/**
 *
 * @author Adminstrateur
 */
public class VehiculeService {

    //appelle class connection 
    // Connection cnx = MyConnection.getInstance().getCnx();
    Connection cnx = MyConnection.getInstance().getCnx();

    public VehiculeService() {

    }

    public void ajoutervehicule(Vehicule v) {
        String sql = "insert into véhicules(immatricule, type, marque, type_carburant,nb_chevaux_fiscaux, date_circulation,age,estimation_rapprochée, classe) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, v.getImmatricule());
            ste.setString(2, v.getType());
            ste.setString(3, v.getMarque());
            ste.setString(4, v.getType_carburant());
            ste.setInt(5, v.getNb_chevaux_fiscaux());
            ste.setString(6, v.getDate_circulation());
            ste.setInt(7, v.getAge());
            ste.setInt(8, v.getEstimation_rapprochée());
            ste.setString(9, v.getClasse());

            ste.executeUpdate();
            System.out.println("OK!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("NO ");
        }

    }

    public List<Vehicule> affichervehicule() {
        List<Vehicule> vehicule = new ArrayList<>();
        String sql = "select * from véhicules";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                Vehicule v = new Vehicule();
                v.setImmatricule(rs.getString("immatricule"));
                v.setType(rs.getString("type"));
                v.setMarque(rs.getString("marque"));
                v.setType_carburant(rs.getString("type_carburant"));
                v.setNb_chevaux_fiscaux(rs.getInt("nb_chevaux_fiscaux"));
                v.setDate_circulation(rs.getString("date_circulation"));
                v.setAge(rs.getInt("age"));
                v.setEstimation_rapprochée(rs.getInt("estimation_rapprochée"));
                v.setClasse(rs.getString("classe"));
                vehicule.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("emmmmm");
        }

        return vehicule;
    }

    public void supprimervehicule(Vehicule v) {
        String sql = "DELETE FROM véhicules WHERE immatricule  = ?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, v.getImmatricule());

            ste.executeUpdate();
            System.out.println("OK!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("NO ");
        }

    }

}
