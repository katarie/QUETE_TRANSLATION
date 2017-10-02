package fr.wcs.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 9/13/17.
 */

public class TripResultModel {

    //Attributs
    private String prenom;
    private Date departDate;
    private int prix;

    //Constructeurs
    public TripResultModel(String prenom, Date departDate, int prix) {
        this.prenom = prenom;
        this.departDate = departDate;
        this.prix = prix;
    }

    //Getters
    public String getPrenom() {
        return prenom;
    }
    public Date getDepartDate() {
        return departDate;
    }
    public int getPrix() {
        return prix;
    }

    //Setters
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
}


