import model.Tienda;
import utils.UserFlow;
import utils.Utils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Tienda miTienda =  new Tienda("Los 3 Gatos", 3, 00);

        boolean continueRunning = true;
            UserFlow userFlow=new UserFlow();

            while (continueRunning) {

                int choice= userFlow.stageZero();
                switch (choice) {
                    case 1:
                        userFlow.stageAdd(miTienda);
                        break;
                    case 2:
                        userFlow.stageBuy();
                        break;
                    case 3:
                        userFlow.stageSpecial(miTienda);
                        break;
                    case 9:
                        continueRunning = false;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("_________________!!!!!!!!!!!!!_________________\n"+
                                "Opcion no reconocida. Por favor, elige de nuevo.");
                        userFlow.stageZero();

                }
            }
        }
/*
        public static void handleOption1() {
            System.out.println("Elegiste la opción 1");
            // Aquí va tu código para manejar esta opción
        }

        public static void handleOption2() {
            System.out.println("Elegiste la opción 2");
            // Aquí va tu código para manejar esta opción
        }
*/
}