package vista;

import model.CarroCompra;
import model.Producte;

import java.util.HashMap;
import java.util.Map;

public class CarroCompraVista {
    public static void mostrarCarro(CarroCompra carro) {
        System.out.println("Carro de la compra:");

        //mapa per comptar quantes unitats hi ha de cada producte
        Map<String, Integer> quantitats = new HashMap<>();
        Map<String, Producte> productes = carro.getProductes();

        //cmptar unitats de cada producte
        for (Producte producte : productes.values()) {
            String codi = producte.getCodiDeBarres();
            quantitats.put(codi, quantitats.getOrDefault(codi, 0) + 1);
        }

        //mostrar
        for (Map.Entry<String, Integer> entry : quantitats.entrySet()) {
            String codi = entry.getKey();
            int quantitat = entry.getValue();
            Producte producte = productes.get(codi);

            System.out.println(producte.getNom() + " -> " + quantitat);
        }
    }
}
