package model;

import excepcions.ExcepcionsPersonalitzades;

import java.time.LocalDate;

public class Alimentacio extends Producte {
    LocalDate dataCaducitat;

    //constructor
    public Alimentacio(String nom, float preu, String codiDeBarres, LocalDate dataCaducitat) throws ExcepcionsPersonalitzades.DataCaducitatException {
        super(nom, preu, codiDeBarres);
        setDataCaducitat(dataCaducitat);

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
