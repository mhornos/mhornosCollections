package controlador;

import excepcions.ExcepcionsPersonalitzades;
import excepcions.ExcepcionsPersonalitzades.LimitProductesException;
import model.*;
import vista.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CarroCompraControlador {
    private CarroCompra carro;
    private static final Scanner scan = new Scanner(System.in);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // constructor
    public CarroCompraControlador() {
        this.carro = new CarroCompra();
    }

    // afegir un producte al carro
    public void afegirProducte() throws ExcepcionsPersonalitzades.DataCaducitatException, ExcepcionsPersonalitzades.NegatiuException {
        int tipus;
        do {
            System.out.println("\n--------------");
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

    private void demanarDadesProducte(int tipus) throws ExcepcionsPersonalitzades.DataCaducitatException, ExcepcionsPersonalitzades.NegatiuException {
        System.out.print("Nom producte: ");
        String nom = scan.nextLine();

        float preu = demanarPreu();
        if (preu < 0) return;

        scan.nextLine();
        System.out.print("Codi de barres: ");
        String codiBarres = scan.nextLine();

        Producte nouProducte = null;

        switch (tipus) {
            //alimentacio
            case 1:
                LocalDate dataCaducitat = demanarDataCaducitat();
                if (dataCaducitat == null) return;
                nouProducte = new Alimentacio(nom, preu, codiBarres, dataCaducitat);
                break;
            //textil
            case 2:
                System.out.print("Composició: ");
                String composicio = scan.nextLine();
                nouProducte = new Textil(nom, preu, codiBarres, composicio);
                break;
            //electronica
            case 3:
                System.out.print("Garantia (dies): ");
                int diesGarantia = scan.nextInt();
                scan.nextLine();
                nouProducte = new Electronica(nom, preu, codiBarres, diesGarantia);
                break;
        }

        if (nouProducte != null) {
            try {
                carro.afegirProducte(nouProducte);
                System.out.println("Producte afegit correctament");
            } catch (LimitProductesException e) {
                System.out.println("Error! " + e.getMessage());
            }
        }
    }

    private float demanarPreu() {
        float preu;
        while (true) {
            System.out.print("Preu: ");
            try {
                preu = scan.nextFloat();
                if (preu < 0) {
                    throw new ExcepcionsPersonalitzades.NegatiuException();
                }
                return preu;
            } catch (InputMismatchException e) {
                scan.next();
                System.out.println("Error! Preu incorrecte");
            } catch (ExcepcionsPersonalitzades.NegatiuException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private LocalDate demanarDataCaducitat() {
        System.out.print("Data de caducitat (dd/mm/aaaa): ");
        try {
            LocalDate dataCaducitat = LocalDate.parse(scan.nextLine(), dateFormatter);

            if (dataCaducitat.isBefore(LocalDate.now())) {
                throw new ExcepcionsPersonalitzades.DataCaducitatException();
            }

            return dataCaducitat;
        } catch (DateTimeParseException e) {
            System.out.println("Error! Format de data incorrecte.");
            return null;
        } catch (ExcepcionsPersonalitzades.DataCaducitatException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //mostrar el carro de la compra
    public void mostrarCarro() {
        CarroCompraVista.mostrarCarro(carro);
    }

    //passar per caixa (mostrar factura i buidar-lo després)
    public void passarPerCaixa() {
        if (carro.getProductes().isEmpty()) {
            System.out.println("El carro està buit. No es pot generar una factura.");
            return;
        }

        TiquetDeCompra tiquet = new TiquetDeCompra(carro.getProductesQuantitats(), calcularTotal());
        TiquetVista.mostrarTiquet(tiquet, carro.getProductes());
        buidarCarro();
    }

    private float calcularTotal() {
        float total = 0;
        for (Map.Entry<String, Integer> entry : carro.getProductesQuantitats().entrySet()) {
            Producte producte = carro.getProductes().get(entry.getKey());
            if (producte != null) {
                total += producte.getPreu() * entry.getValue();
            }
        }
        return total;
    }

    public void buidarCarro() {
        carro = new CarroCompra();
    }

    //filtrar producte per codi de barres
    public void mostrarNomProducte() {
        System.out.print("Introdueix el codi de barres del producte: ");
        String codi = scan.nextLine();
        String nomProducte = carro.buscarNomProducte(codi);
        System.out.println("Resultat: " + nomProducte);
    }
}
