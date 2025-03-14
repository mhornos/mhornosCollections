package model;

public class Electronica extends Producte{
    int diesGarantia;

    //constructor
    public Electronica(String nom, float preu, String codiDeBarres, int diesGarantia) {
        super(nom, preu, codiDeBarres);
        this.diesGarantia = diesGarantia;
    }

    //getters y setter
    public int getDiesGarantia() {
        return diesGarantia;
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    @Override
    public float calcularPreu() {
        return 0;
    }

    //toString
    @Override
    public String toString() {
        return "Electronica{" +
                "diesGarantia=" + diesGarantia +
                ", nom='" + nom + '\'' +
                ", preu=" + preu +
                ", codiDeBarres='" + codiDeBarres + '\'' +
                '}';
    }
}
