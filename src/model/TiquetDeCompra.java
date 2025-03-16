package model;

import java.time.LocalDate;
import java.util.Map;

public class TiquetDeCompra {
    Map<String, Integer> productes;
    float total;
    LocalDate dataCompra;

    //constructor
    public TiquetDeCompra(Map<String, Integer> productes, float total) {
        this.productes = productes;
        this.total = total;
        this.dataCompra = LocalDate.now();
    }

    //getters y setters
    public Map<String, Integer> getProductes() {
        return productes;
    }

    public void setProductes(Map<String, Integer> productes) {
        this.productes = productes;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }
}
