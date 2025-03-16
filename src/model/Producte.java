package model;

import excepcions.ExcepcionsPersonalitzades;

public abstract class Producte implements Comparable<Producte>{
    String nom;
    float preu;
    String codiDeBarres;

    //constructor
    public Producte(String nom, float preu, String codiDeBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiDeBarres = codiDeBarres;
    }

    //getters y setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ExcepcionsPersonalitzades.LimitCaracteresException {
        if (nom.length() > 20) {
            throw new ExcepcionsPersonalitzades.LimitCaracteresException();
        }
        this.nom = nom;
    }

    public float getPreu() {
        return preu;
    }

    //comproba que el preu no sigui negatiu
    public void setPreu(float preu) throws ExcepcionsPersonalitzades.NegatiuException {
        if (preu < 0){
            throw new ExcepcionsPersonalitzades.NegatiuException();
        }
        this.preu = preu;
    }

    public String getCodiDeBarres() {
        return codiDeBarres;
    }

    public void setCodiDeBarres(String codiDeBarres) {
        this.codiDeBarres = codiDeBarres;
    }

    //toString
    @Override
    public String toString() {
        return "Producte{" +
                "nom='" + nom + '\'' +
                ", preu=" + preu +
                ", codiDeBarres='" + codiDeBarres + '\'' +
                '}';
    }

    @Override
    //metode d'ordenacio
    public int compareTo(Producte altreProducte) {
        if (this.preu < altreProducte.preu) {
            return -1;
        } else if (this.preu > altreProducte.preu) {
            return 1;
        } else {
            return 0;
        }
    }
}