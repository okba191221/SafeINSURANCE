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
import safeinsurance.entites.rapport;
import safeinsurance.tools.MyConnection;

/**
 *
 * @author Jhon
 */
public class RaportService {

    //appelle class connection 
    // Connection cnx = MyConnection.getInstance().getCnx();
    Connection cnx = MyConnection.getInstance().getCnx();

    public RaportService() {

    }

    public void ajouterraport(rapport r) {
        String sql = "insert into rapport(id_rapport,id_constat,mat_employee,id_assurance,pieces_jointes,date_rapport)values(?,?,?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);

            ste.setString(1, r.getId_rapport());
            ste.setString(2, r.getId_constat());
            ste.setString(3, r.getMat_employee());
            ste.setString(4, r.getId_assurance());
            ste.setString(5, r.getPieces_jointes());
            ste.setString(6,  r.getDate_rapport());

            ste.executeUpdate();
            System.out.println("OK!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("NO ");
        }

    }

    public List<rapport> afficherrapport() {
        List<rapport> rapport = new ArrayList<>();
        String sql = "select * from rapport";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                rapport r = new rapport();
                r.setId_rapport(rs.getString("id_rapport"));
                r.setId_constat(rs.getString("id_constat"));
                r.setMat_employee(rs.getString("mat_employee"));
                r.setId_assurance(rs.getString("id_assurance"));
                r.setPieces_jointes(rs.getString("pieces_jointes"));
                r.setDate_rapport( rs.getString("date_rapport"));

                rapport.add(r);
                
       
           
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("emmmmm");
        }

        return rapport;
    }

}
