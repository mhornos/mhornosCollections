import controlador.CarroCompraControlador;
import excepcions.ExcepcionsPersonalitzades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner(System.in);
    static final CarroCompraControlador controlador = new CarroCompraControlador();

    public static void main(String[] args) throws ExcepcionsPersonalitzades.DataCaducitatException, ExcepcionsPersonalitzades.NegatiuException {
        int opcio = 99;

        System.out.println("\nBENVINGUT AL SAPAMERCAT");
        do {
            System.out.println("\n--------------");
            System.out.println("--- INICI ----");
            System.out.println("--------------");
            System.out.println("1) Introduir producte");
            System.out.println("2) Passar per caixa");
            System.out.println("3) Mostrar carret de compra");
            System.out.println("4) Cercar producte per codi de barres");
            System.out.println("0) Acabar ");
            System.out.print("Escull una opció: ");

            try {
                opcio = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.next();
            }

            switch (opcio) {
                case 1:
                    controlador.afegirProducte();
                    break;
                case 2:
                    controlador.passarPerCaixa();
                    break;
                case 3:
                    controlador.mostrarCarro();
                    break;
                case 4:
                    controlador.mostrarNomProducte();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Error! Aquesta opció no existeix");
            }
        } while (opcio != 0);
    }
}