/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.entities;

import java.util.Objects;

/**
 *
 * @author Servicenfo
 */
public class Users {
    private String nom, prenom, matricule,function,role,login, mdp ;  
   private int cin, tel ;

    public Users() {
    }

    public Users(String nom, String prenom, String function, String role, String login, String mdp, int cin, int tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.function = function;
        this.role = role;
        this.login = login;
        this.mdp = mdp;
        this.cin = cin;
        this.tel = tel;
    }
   public Users(int cin,String nom, String prenom,int tel,String role, String function,String matricule , String login, String mdp){
 this.cin = cin;
  this.nom = nom;
   this.prenom = prenom;
   this.tel = tel;
    this.role = role;
   this.function = function;
   this.matricule = matricule;
       this.login = login;
        this.mdp = mdp;
}
    public Users(String role, String login, String mdp) {
        this.role = role;
        this.login = login;
        this.mdp = mdp;
    }

    public Users(String login, String mdp, int cin) {
        this.login = login;
        this.mdp = mdp;
        this.cin = cin;
    }

    public Users(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getFunction() {
        return function;
    }

    public String getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public int getCin() {
        return cin;
    }

    public int getTel() {
        return tel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Users{" + "nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule + ", function=" + function + ", role=" + role + ", login=" + login + ", mdp=" + mdp + ", cin=" + cin + ", tel=" + tel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.cin != other.cin) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        if (!Objects.equals(this.function, other.function)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        return true;
    }
   
}
