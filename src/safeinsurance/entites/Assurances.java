/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.entites;

/**
 *
 * @author Adminstrateur
 */
public class Assurances {
    
   
    private String id_assurance,immatricule_voiture,type;
    private int cin_client;
    private Float montant;

    public Assurances() {
    }

    public Assurances(String id_assurance, String immatricule_voiture, String type, int cin_client, Float montant) {
        this.id_assurance = id_assurance;
        this.immatricule_voiture = immatricule_voiture;
        this.type = type;
        this.cin_client = cin_client;
        this.montant = montant;
    }

    public String getId_assurance() {
        return id_assurance;
    }

    public void setId_assurance(String id_assurance) {
        this.id_assurance = id_assurance;
    }

    public String getImmatricule_voiture() {
        return immatricule_voiture;
    }

    public void setImmatricule_voiture(String immatricule_voiture) {
        this.immatricule_voiture = immatricule_voiture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCin_client() {
        return cin_client;
    }

    public void setCin_client(int cin_client) {
        this.cin_client = cin_client;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }
    
    
    
}
