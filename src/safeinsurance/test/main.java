/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import safeinsurance.entities.Employés2;
import safeinsurance.services.EmployésService;
import safeinsurance.tools.MyConnection ;

/**
 *
 * @author okba
 */
public class main {
  
    
    public static void main(String[] args) {
        
//        MyConnection c = MyConnection.getInstance();
//        System.out.println(c);                    
//        MyConnection c1= MyConnection.getInstance();
//        System.out.println(c1);
//               
//        Employés2 E = new Employés2 ("Adem", "Seddik", "Agent back office", "ABO00002", 100120034, 97442100,"Adem_Elif%2002","%Elife_PI_SimuLaTeur_2022");
//        EmployésService es = new EmployésService();
//        es.ajouterEmployés(E);
//      es.ajouterEmployés2(E);
Statement st;
        ResultSet rst;
        ResultSet rstt;
  
        try {
            Connection cnx=MyConnection.getInstance().getCnx();
             st = cnx.createStatement();
             rst=st.executeQuery("SELECT cin FROM clients");
//             rstt=st.executeQuery("SELECT cin FROM employees");


             
             while(rst.next()){
                 int ciiin = rst.getInt("cin");
//                 String loginn = rstt.getString("login");
                 System.out.println(ciiin);

//                 System.out.println(rst.getInt("cin"));
//                 System.out.println(rst.getInt("immatricule"));
//                 System.out.println(rst.getString("type carburant"));
//                 System.out.println(rst.getString("nb chevaux fiscaux"));
    

             }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
//        System.out.println(mdp); 
        

    }
    
}
