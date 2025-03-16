package controlador;

import excepcions.ExcepcionsPersonalitzades.LimitProductesException;
import model.CarroCompra;
import model.Producte;
import vista.CarroCompraVista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarroCompraControlador {
    private CarroCompra carro;
    private static final Scanner scan = new Scanner(System.in);

    //constructor
    public CarroCompraControlador() {
        this.carro = new CarroCompra();
    }

    //afegir un producte al carro amb control d'errors
    public void afegirProducte(Producte producte) {
        try {
            carro.afegirProducte(producte);
            System.out.println("Producte afegit correctament");
        } catch (LimitProductesException e) {
            System.out.println("Error! " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error! Assegura't d'introduir el format correcte");
            scan.next();
        }
    }

    //mmostra el carro de la compra
    public void mostrarCarro() {
        CarroCompraVista.mostrarCarro(carro);
    }

    //buida el carro
    public void buidarCarro() {
        carro = new CarroCompra();
        System.out.println("Carro de la compra buidat");
    }
}
