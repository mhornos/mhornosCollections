package model;

public class Textil extends Producte{
    String composicioTextil;

    //constructor
    public Textil(String nom, float preu, String codiDeBarres, String composicioTextil) {
        super(nom, preu, codiDeBarres);
        this.composicioTextil = composicioTextil;
    }

    //getters y setters
    public String getComposicioTextil() {
        return composicioTextil;
    }

    public void setComposicioTextil(String composicioTextil) {
        this.composicioTextil = composicioTextil;
    }

    @Override
    public float calcularPreu() {
        return preu;
    }

    //compara entre productes textils per la composició
    public int compareTo(Producte altreProducte) {
        if (altreProducte instanceof Textil) {
            Textil altreTextil = (Textil) altreProducte;
            return this.composicioTextil.compareTo(altreTextil.composicioTextil);
        } else return super.compareTo(altreProducte);
    }

    //toString
    @Override
    public String toString() {
        return "Textil{" +
                "composicioTextil='" + composicioTextil + '\'' +
                ", nom='" + nom + '\'' +
                ", preu=" + preu +
                ", codiDeBarres='" + codiDeBarres + '\'' +
                '}';
    }
}
