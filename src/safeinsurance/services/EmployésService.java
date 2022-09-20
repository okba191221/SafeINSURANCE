/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.services;

import safeinsurance.entities.Employés2;
import safeinsurance.tools.MyConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author okba
 */
public class EmployésService implements Iemp {
    Connection cnx;
    
public EmployésService(){
    cnx=MyConnection.getInstance().getCnx();
}      

    public void ajouterEmployés(Employés2 E){
        String query ="insert into employees(nom,prenom,fonction,matricule,cin,tel) values('"+E.getNom()+"','"+E.getPrenom()+"','"+E.getFonction()+"','"+E.getMatricule()+"','"+E.getCin()+"','"+E.getTel() +"')";
        
            Statement ste;
        try {
            ste = cnx.createStatement();
             ste.executeUpdate(query);
            System.out.println("Employé Ajouté");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
        
    }
    
        public void ajouterEmployés2(Employés2 E){
        String sql="insert into employees(nom,prenom,fonction, matricule,cin, tel, login, mdp) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, E.getNom());
            ste.setString(2, E.getPrenom());
            ste.setString(3, E.getFonction());
            ste.setString(4, E.getMatricule());
            ste.setInt(5, E.getCin());
            ste.setInt(6, E.getTel());
            ste.setString(7, E.getLogin());
            ste.setString(8, E.getMdp());
            ste.executeUpdate();
            System.out.println("Employé Ajouté !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public void ajouterEmployés3(Employés2 E){
        String sql="insert into employees(nom,prenom,fonction, matricule) values (?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, E.getNom());
            ste.setString(2, E.getPrenom());
            ste.setString(3, E.getFonction());
            ste.setString(4, E.getMatricule());
            ste.executeUpdate();
            System.out.println("Employé Ajouté !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
     public List<Employés2> afficherEmployé(){
        List<Employés2> Employés = new ArrayList<>();
        String sql ="select * from employees";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Employés2 E = new Employés2();
                E.setNom(rs.getString("nom"));
                E.setPrenom(rs.getString("prenom"));
                E.setFonction(rs.getString("fonction"));
                E.setMatricule(rs.getString("matricule"));
                E.setCin(rs.getInt("cin"));
                E.setTel(rs.getInt("tel"));
                E.setLogin(rs.getString("login"));
                E.setMdp(rs.getString("mdp"));
                Employés.add(E);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Employés;
    }
}
