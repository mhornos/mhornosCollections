package model;

import excepcions.LimitProductes;
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
    public void afegirProducte (Producte producte) throws LimitProductes {
        if (productes.size() >= LIMIT_PRODUCTES) {
            throw new LimitProductes("No es pot afegir mes de " + LIMIT_PRODUCTES + " productes al carro");
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


}
