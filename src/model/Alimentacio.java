package model;

import excepcions.ExcepcionsPersonalitzades;

import java.time.LocalDate;

public class Alimentacio extends Producte {
    LocalDate dataCaducitat;

    //constructor
    public Alimentacio(String nom, float preu, String codiDeBarres, LocalDate dataCaducitat) {
        super(nom, preu, codiDeBarres);
        this.dataCaducitat = dataCaducitat;
    }

    //getters y setters
    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(LocalDate dataCaducitat) throws ExcepcionsPersonalitzades.DataCaducitatException {
        if (dataCaducitat.isBefore(LocalDate.now())) {
            throw new ExcepcionsPersonalitzades.DataCaducitatException();
        }
        this.dataCaducitat = dataCaducitat;
    }

    //calcular preu del producte d'alimentacio
    @Override
    public float calcularPreu(){
        LocalDate dataActual = LocalDate.now();
        int diesFaltants = (int) (dataCaducitat.toEpochDay() - dataActual.toEpochDay());

        return (float) (preu - preu*(1/(diesFaltants+1)) + (preu * 0.1));
    }

    //toString
    @Override
    public String toString() {
        return "Alimentacio{" +
                "dataCaducitat=" + dataCaducitat +
                ", nom='" + nom + '\'' +
                ", preu=" + preu +
                ", codiDeBarres='" + codiDeBarres + '\'' +
                '}';
    }
}
