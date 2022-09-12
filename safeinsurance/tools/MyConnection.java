/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.tools;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
/**
 *
 * @author okba
 */
public class MyConnection {
    public final String url ="jdbc:mysql://localhost:3306/testi";
    public final String user = "root";
    public final String password ="";
    private Connection cnx;
    private static MyConnection ct;
    
    
    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("connexion etablie !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static MyConnection getInstance(){
        if(ct==null)
            ct = new MyConnection();
        return ct;
        
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    
}
