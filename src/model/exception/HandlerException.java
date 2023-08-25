package model.exception;

import utils.Consola;
import utils.TipoEnvase;

import java.util.InputMismatchException;

public class HandlerException {
    Consola consola=new Consola();
    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return consola.getScanner().nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un numero entero valido.");
                consola.getScanner().next();
            }
        }
    }


    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                double value = consola.getScanner().nextDouble();
                consola.getScanner().nextLine(); // Consume the newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un numero decimal valido.");
                consola.getScanner().next();
            }
        }
    }


    public TipoEnvase handleTipoEnvase() {
        while (true) {
            try {
                System.out.println("Ingrese el tipo de envase (PLASTICO, VIDRIO, LATA): ");
                return TipoEnvase.valueOf(consola.getScanner().nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de envase invalido. Por favor ingrese nuevamente.");
            }
        }
    }

}
