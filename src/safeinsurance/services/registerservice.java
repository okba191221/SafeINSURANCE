/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import safeinsurance.entities.clients;
import safeinsurance.tools.MyConnection;

/**
 *
 * @author Servicenfo
 */
public class registerservice {
      Connection cnx=MyConnection.getInstance().getCnx();
       public registerservice(){
      cnx=MyConnection.getInstance().getCnx();
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
            ste.setString(6, c.getFonction());
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
}


