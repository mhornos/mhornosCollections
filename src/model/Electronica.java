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

    //calcular preu en funcio dels dies que te de garantia
    @Override
    public float calcularPreu() {
        float preu = this.getPreu();
        preu += (float) (preu * (diesGarantia / 365) * 0.1);
        return preu;
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
