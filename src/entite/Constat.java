/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Adminstrateur
 */
public class Constat {
    
    private int id;
    private String id_assurance,date,lieu,piece_jointe;

    public Constat(int id, String id_assurance, String date, String lieu, String piece_jointe) {
        this.id = id;
        this.id_assurance = id_assurance;
        this.date = date;
        this.lieu = lieu;
        this.piece_jointe = piece_jointe;
    }

    public Constat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_assurance() {
        return id_assurance;
    }

    public void setId_assurance(String id_assurance) {
        this.id_assurance = id_assurance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPiece_jointe() {
        return piece_jointe;
    }

    public void setPiece_jointe(String piece_jointe) {
        this.piece_jointe = piece_jointe;
    }
    
    
    
}
