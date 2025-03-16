package model;

import excepcions.ExcepcionsPersonalitzades;

import java.util.HashMap;
import java.util.Map;

public class CarroCompra{
    Map<String, Producte> productes;
    static final int LIMIT_PRODUCTES = 100;

    //constructor
    public CarroCompra() {
        this.productes = new HashMap<>();
    }

    //afegir un producte al carro
    public void afegirProducte (Producte producte) throws ExcepcionsPersonalitzades.LimitProductesException {
        if (productes.size() >= LIMIT_PRODUCTES) {
            throw new ExcepcionsPersonalitzades.LimitProductesException();
        }
        if (productes.containsKey(producte.getCodiDeBarres())){
            System.out.println("El producte ja existeix al carro!");
        } else {
            productes.put(producte.getCodiDeBarres(), producte);
        }
    }

    //getter
    public Map<String, Producte> getProductes() {
        return productes;
    }

    public Map<String, Integer> getProductesQuantitats() {
        Map<String, Integer> productesQuantitats = new HashMap<>();
        for (Producte producte : productes.values()) {
            String codi = producte.getCodiDeBarres();
            productesQuantitats.put(codi, productesQuantitats.getOrDefault(codi, 0) + 1);
        }
        return productesQuantitats;
    }
}
