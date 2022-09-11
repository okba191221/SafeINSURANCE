/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.services;

import java.util.List;
import safeinsurance.entities.Employés2;

/**
 *
 * @author okba
 */
public interface Iemp {
   public void ajouterEmployés2(Employés2 E);
   public List<Employés2> afficherEmployé(); 
}
