/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.entities;

/**
 *
 * @author okba
 */
public class Employés {
   private String nom, prenom, fonction, matricule ;  
   private int cin, tel ;
   private String login, mdp;

    public Employés() {
    }

    
    public Employés(String nom, String prenom, String fonction, String matricule, int cin, int tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.matricule = matricule;
        this.cin = cin;
        this.tel = tel;
    }

    public Employés(String nom, String prenom, String fonction, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.matricule = matricule;
    }

    public Employés(String nom, String prenom, String fonction, String matricule, int cin, int tel, String login, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.matricule = matricule;
        this.cin = cin;
        this.tel = tel;
        this.login = login;
        this.mdp = mdp;
    }

    public Employés(String nom, String prenom, String fonction, String matricule, String cin, String tel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Employ\u00e9s{" + "nom=" + nom + ", prenom=" + prenom + ", fonction=" + fonction + ", matricule=" + matricule + ", cin=" + cin + ", tel=" + tel + '}';
    }



      
   

   
   
}
