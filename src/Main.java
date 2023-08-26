import model.Tienda;
import operation.Venta;
import service.Producto;
import utils.Inventario;
import utils.UserFlow;
import utils.Utils;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Map<String, List<Producto>> productosIniciales = inventario.inicializarProductos();


        Tienda miTienda =  new Tienda("Los 3 Gatos",60, 100000, productosIniciales);

        boolean continueRunning = true;
            UserFlow userFlow=new UserFlow();
            Venta miVenta= new Venta();

            while (continueRunning) {

                int choice= userFlow.stageZero();
                switch (choice) {
                    case 1:
                        userFlow.stageAdd(miTienda);
                        break;
                    case 2:
                        userFlow.stageBuy(miTienda);
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