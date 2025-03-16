import controlador.CarroCompraControlador;
import model.Alimentacio;
import model.Electronica;
import model.Producte;
import model.Textil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner(System.in);
    static final CarroCompraControlador controlador = new CarroCompraControlador();

    public static void main(String[] args) {
        int opcio = 99;
        do {
            System.out.println("\nBENVINGUT AL SAPAMERCAT");
            System.out.println("1) Introduir producte");
            System.out.println("2) Passar per caixa");
            System.out.println("3) Mostrar carret de compra");
            System.out.println("0) Acabar ");
            System.out.print("Escull una opció: ");

            try {
                opcio = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.next();
                System.out.println("Error! Introdueix un numero");
            }
            System.out.println();
            scan.nextLine();

            switch (opcio) {
                case 1:
                    afegirProducte();
                    break;
                case 2:
                    //passar per caixa
                    break;
                case 3:
                    controlador.mostrarCarro();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Error! Aquesta opció no existeix");
            }
        } while (opcio != 0);
    }

    private static void afegirProducte() {
        int tipus;
        do {
            System.out.println("--------------");
            System.out.println("-- PRODUCTE --");
            System.out.println("--------------");
            System.out.println("1) Alimentació");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electrònica");
            System.out.println("0) Tornar");
            System.out.print("Escull una opció: ");

            try {
                tipus = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                scan.next();
                System.out.println("Error! Introdueix un número vàlid");
                tipus = -1;
            }

            if (tipus >= 1 && tipus <= 3) {
                demanarDadesProducte(tipus);
            }

        } while (tipus != 0);
    }

    private static void demanarDadesProducte(int tipus) {
        System.out.print("Nom producte: ");
        String nom = scan.nextLine();

        float preu = demanarPreu();
        if (preu < 0) return;

        System.out.print("Codi de barres: ");
        String codiBarres = scan.nextLine();

        Producte nouProducte = null;

        switch (tipus) {
            // alimentacio
            case 1:
                System.out.print("Data de caducitat (dd/mm/aaaa): ");
                LocalDate dataCaducitat = LocalDate.parse(scan.nextLine());
                nouProducte = new Alimentacio(nom, preu, codiBarres, dataCaducitat);
                break;
            // textil
            case 2:
                System.out.print("Composició tèxtil: ");
                String composicio = scan.nextLine();
                nouProducte = new Textil(nom, preu, codiBarres, composicio);
                break;
            // electronica
            case 3:
                System.out.print("Dies de garantia: ");
                int diesGarantia = scan.nextInt();
                scan.nextLine();
                nouProducte = new Electronica(nom, preu, codiBarres, diesGarantia);
                break;
        }

        if (nouProducte != null) {
            controlador.afegirProducte(nouProducte);
        }
    }

    private static float demanarPreu() {
        System.out.print("Preu: ");
        try {
            return scan.nextFloat();
        } catch (InputMismatchException e) {
            scan.next();
            System.out.println("Error! Introudeix un preu correctament");
            return -1;
        }
    }

    private static LocalDate demanarDataCaducitat() {
        System.out.print("Introdueix la data de caducitat (dd/mm/aaaa): ");
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(scan.nextLine(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Error! Format de data incorrecte");
            return null;
        }
    }
}
