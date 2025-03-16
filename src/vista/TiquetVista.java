package vista;

import model.TiquetDeCompra;
import model.Producte;
import java.util.Map;

public class TiquetVista {
    public static void mostrarTiquet(TiquetDeCompra tiquet, Map<String, Producte> productesDetalls) {
        float totalCompra = 0;

        System.out.println("---------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("---------------------");
        System.out.println("Data: " + tiquet.getDataCompra());
        System.out.println("---------------------");

        for (Map.Entry<String, Integer> entry: tiquet.getProductes().entrySet()){
            String codi = entry.getKey();
            int quantitat = entry.getValue();
            Producte producte = productesDetalls.get(codi);
            float preuUnitari = producte.getPreu();
            float preuTotal = quantitat * preuUnitari;
            totalCompra += preuTotal;

            System.out.println(producte.getNom() + " · qt: " + quantitat + " · " + preuUnitari + "€ · " + preuTotal + "€" );
            System.out.println("---------------------");
        }

        System.out.println("Total: " + totalCompra + "€");
    }
}

