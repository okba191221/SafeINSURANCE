/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.test;

import safeinsurance.services.VehiculeService;
import safeinsurance.entites.Vehicule;
import safeinsurance.test.NewFXMain;
import safeinsurance.tools.MyConnection;


/**
 *
 * @author okba
 */
public class main {

    public static void main(String[] args) {
        MyConnection c = MyConnection.getInstance();
        System.out.println(c);
        MyConnection c1 = MyConnection.getInstance();
        System.out.println(c1);
    }

}
