/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.entites;


import javax.xml.crypto.Data;

/**
 *
 * @author Adminstrateur
 */
public class Vehicule {

    private String immatricule, type, marque, type_carburant, classe,date_circulation;
    private int nb_chevaux_fiscaux, age, estimation_rapprochée;
    

    public Vehicule() {
    }

    public Vehicule(String immatricule, String type, String marque, String type_carburant,int nb_chevaux_fiscaux,String date_circulation,
             int age, int estimation_rapprochée,String classe ) {
        this.immatricule = immatricule;
        this.type = type;
        this.marque = marque;
        this.type_carburant = type_carburant;
        this.nb_chevaux_fiscaux = nb_chevaux_fiscaux;
        this.date_circulation = date_circulation;
        this.age = age;
        this.estimation_rapprochée = estimation_rapprochée;
        this.classe = classe;

    } 
    

 
    public String getImmatricule() {
        return immatricule;
    }

    public String getType() {
        return type;
    }

    public String getMarque() {
        return marque;
    }

    public String getType_carburant() {
        return type_carburant;
    }

    public int getEstimation_rapprochée() {
        return estimation_rapprochée;
    }

    public String getClasse() {
        return classe;
    }

    public int getNb_chevaux_fiscaux() {
        return nb_chevaux_fiscaux;
    }

    public int getAge() {
        return age;
    }

    public String getDate_circulation() {
        return date_circulation;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setType_carburant(String type_carburant) {
        this.type_carburant = type_carburant;
    }

    public void setEstimation_rapprochée(int estimation_rapprochée) {
        this.estimation_rapprochée = estimation_rapprochée;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setNb_chevaux_fiscaux(int nb_chevaux_fiscaux) {
        this.nb_chevaux_fiscaux = nb_chevaux_fiscaux;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate_circulation(String date_circulation) {
        this.date_circulation = date_circulation;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "immatricule=" + immatricule
                + ", type=" + type + ", marque=" + marque
                + ",type_carburant = " + type_carburant
                + ", estimation_rapprochée = " + estimation_rapprochée
                + ", classe  = " + classe + '}';
    }

}
