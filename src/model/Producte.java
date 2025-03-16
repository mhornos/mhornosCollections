package model;

import excepcions.Negatiu;

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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) throws Negatiu{
        if (preu < 0){
            throw new Negatiu("El preu no pot ser negatiu");
        }
        this.preu = preu;
    }

    public String getCodiDeBarres() {
        return codiDeBarres;
    }

    public void setCodiDeBarres(String codiDeBarres) {
        this.codiDeBarres = codiDeBarres;
    }

    //calcular preu del producte d'alimentacio
    public abstract float calcularPreu();

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
    public int compareTo(Producte altreProducte) {
        // Aquí se puede definir cómo comparar productos, por ejemplo, por precio
        if (this.preu < altreProducte.preu) {
            return -1; // Si el precio del producto actual es menor
        } else if (this.preu > altreProducte.preu) {
            return 1; // Si el precio del producto actual es mayor
        } else {
            return 0; // Si los precios son iguales
        }
    }
}