/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Servicenfo
 */
public class clients {
      private String nom, prenom, immatricule,role ;  
   private int cin, tel ,num_Permis;
   private String email, mdp;
   private Date Délivré_le;

    public clients() {
    }


    public clients(int Cin, String nom, String prenom, int tel, String mdp,String role, String email, String immatricule, int num_Permis, Date Délivré_le) {
this.cin = Cin ;
       this.nom = nom;
        this.prenom = prenom;
         this.tel =tel;
          this.mdp = mdp;
           this.role= role;
            this.email = email;
               this.immatricule = immatricule;
              this.num_Permis = num_Permis;
               this.Délivré_le  = Délivré_le ;  
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

    public String getImmatricule() {
        return immatricule;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getNum_Permis() {
        return num_Permis;
    }

    public void setNum_Permis(int num_Permis) {
        this.num_Permis = num_Permis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDélivré_le() {
        return Délivré_le;
    }

    public void setDélivré_le(Date Délivré_le) {
        this.Délivré_le = Délivré_le;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + Objects.hashCode(this.prenom);
        hash = 29 * hash + Objects.hashCode(this.immatricule);
        hash = 29 * hash + Objects.hashCode(this.role);
        hash = 29 * hash + this.cin;
        hash = 29 * hash + this.tel;
        hash = 29 * hash + this.num_Permis;
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.mdp);
        hash = 29 * hash + Objects.hashCode(this.Délivré_le);
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
        final clients other = (clients) obj;
        if (this.cin != other.cin) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (this.num_Permis != other.num_Permis) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.immatricule, other.immatricule)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        if (!Objects.equals(this.Délivré_le, other.Délivré_le)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clients{" + "nom=" + nom + ", prenom=" + prenom + ", immatricule=" + immatricule + ", role=" + role + ", cin=" + cin + ", tel=" + tel + ", num_Permis=" + num_Permis + ", email=" + email + ", mdp=" + mdp + ", D\u00e9livr\u00e9_le=" + Délivré_le + '}';
    }

}