/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import safeinsurance.entities.Users;
import safeinsurance.entities.clients;
import safeinsurance.tools.MyConnection;

/**
 *
 * @author Servicenfo
 */
public class loginservice {
    Connection cnx=MyConnection.getInstance().getCnx();

    public loginservice() {
    }
    public void auth(Users u){
        String query ="insert into users(cin,nom,prenom,tel,role,function,matricule,login,mdp) values('"+u.getCin()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getTel()+"','"+u.getRole()+"','"+u.getFunction()+"','"+u.getMatricule() +"','"+u.getLogin()+"','"+u.getMdp()+"')";
        
            Statement ste;
        try {
            ste = cnx.createStatement();
             ste.executeUpdate(query);
            System.out.println("Employée Ajouté");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
        
    }
       
       
      
      public void auth2(Users u){
      
        String sql="insert into users(cin,nom,prenom,tel,role,function,matricule,login,mdp) values (?,?,?,?,?,?,?,?,?)";
       try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            
            ste.setInt(1, u.getCin());
            ste.setString(2, u.getNom());
            ste.setString(3, u.getPrenom());
            ste.setInt(4, u.getTel());
            ste.setString(5, u.getRole());
            ste.setString(6, u.getFunction());
            ste.setString(7, u.getMatricule());
            ste.setString(8, u.getLogin());
            ste.setString(9, u.getMdp());
            ste.executeUpdate();
            System.out.println("employée Ajouté !!!");
        } catch (SQLException ex) {
            System.out.println("echec!!!");
        }
        }
      
    
    
    
}
