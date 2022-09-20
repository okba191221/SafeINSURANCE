/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Constat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tools.MyConnection;

/**
 *
 * @author Adminstrateur
 */
public class ConstatService {

    Connection cnx = MyConnection.getInstance().getCnx();

    public ConstatService() {
    }

    public List<Constat> afficherconstat() {
        List<Constat> constat = new ArrayList<>();
        String sql = "select * from constat";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                Constat C = new Constat();
                C.setId(rs.getInt("id"));
                C.setId_assurance(rs.getString("id_assurance"));
                C.setDate(rs.getString("date"));
                C.setLieu(rs.getString("lieu"));
                C.setPiece_jointe(rs.getString("piece_jointe"));

                constat.add(C);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }

        return constat;
    }

    public void ajoutervehicule(Constat C) {
        String sql = "insert into constat(id,id_assurance , date, lieu,piece_jointe) values (?,?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, C.getId());
            ste.setString(2, C.getId_assurance());
            ste.setString(3, C.getDate());
            ste.setString(4, C.getLieu());
            ste.setString(5, C.getPiece_jointe());
            ste.executeUpdate();
            System.out.println("OK!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("NO ");
        }

    }

}
