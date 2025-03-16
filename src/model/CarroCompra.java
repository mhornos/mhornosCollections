package model;

import java.util.HashMap;
import java.util.Map;

public class CarroCompra{
    Map<String, Producte> productes;

    //constructor
    public CarroCompra() {
        this.productes = new HashMap<>();
    }

    //afegir un producte al carro
    public void afegirProducte (Producte producte){
        if (productes.containsKey(producte.getCodiDeBarres())){
            System.out.println("El producte ja existeix al carro!");
        } else {
            productes.put(producte.getCodiDeBarres(), producte);
        }
    }

    //mostrar carro de la compra
    public void mostrarCarro() {
        System.out.println("Carro de la compra:");

        //crear un mapa per guardar quantes unitats hi ha de cada producte
        Map<String, Integer> quantitats = new HashMap<>();

        //recorrer tots els productes i comptar quantes vegades apareix cada codi de barres
        for (Producte producte : productes.values()) {
            String codi = producte.getCodiDeBarres();

            //si ja existeix el codi augmentem la quantitat. si no el creem
            if (quantitats.containsKey(codi)) {
                quantitats.put(codi, quantitats.get(codi) + 1);
            } else {
                quantitats.put(codi, 1);
            }
        }

        //mostrar els productes amb el seu nom, codi i quantitat
        for (Map.Entry<String, Integer> entry : quantitats.entrySet()) {
            String codi = entry.getKey();
            int quantitat = entry.getValue();
            Producte producte = productes.get(codi);

            System.out.println(producte.getNom() + " -> " + quantitat);
        }
    }
}
