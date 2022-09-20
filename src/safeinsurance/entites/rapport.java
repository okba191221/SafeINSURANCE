/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.entites;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.crypto.Data;

/**
 *
 * @author Jhon
 */
public class rapport {

    private String id_rapport;
    private String id_constat;
    private String mat_employee;
    private String id_assurance;
    private String pieces_jointes;
    private String date_rapport;

    public rapport() {
    }

    public String getId_rapport() {
        return id_rapport;
    }

    public void setId_rapport(String id_rapport) {
        this.id_rapport = id_rapport;
    }

    public String getId_constat() {
        return id_constat;
    }

    public void setId_constat(String id_constat) {
        this.id_constat = id_constat;
    }

    public String getMat_employee() {
        return mat_employee;
    }

    public void setMat_employee(String mat_employee) {
        this.mat_employee = mat_employee;
    }

    public String getId_assurance() {
        return id_assurance;
    }

    public void setId_assurance(String id_assurance) {
        this.id_assurance = id_assurance;
    }

    public String getPieces_jointes() {
        return pieces_jointes;
    }

    public void setPieces_jointes(String pieces_jointes) {
        this.pieces_jointes = pieces_jointes;
    }

    public String getDate_rapport() {
        return date_rapport;
    }

    public void setDate_rapport(String date_rapport) {
        this.date_rapport = date_rapport;
    }

    public rapport(String id_rapport, String id_constat, String mat_employee, String id_assurance, String pieces_jointes, String date_rapport) {
        this.id_rapport = id_rapport;
        this.id_constat = id_constat;
        this.mat_employee = mat_employee;
        this.id_assurance = id_assurance;
        this.pieces_jointes = pieces_jointes;
        this.date_rapport = date_rapport;
    }

}

