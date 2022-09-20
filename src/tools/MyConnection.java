/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Win11
 */
public class MyConnection {

    public final String url = "jdbc:mysql://localhost:3306/safeinsurance";
    public final String user = "root";
    public final String pwd = "";
    private Connection cnx;
    public static MyConnection ct;

    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, user, pwd);
            System.out.println("connexion etablie !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static MyConnection getInstance() {
        if (ct == null) {
            ct = new MyConnection();
        }
        return ct;

    }

    public Connection getCnx() {
        return cnx;
    }

}
