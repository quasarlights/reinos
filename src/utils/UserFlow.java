package utils;

import model.Bebida;
import model.Envasado;
import model.Tienda;

import java.util.Scanner;
import java.util.concurrent.Flow;

public class UserFlow {
    private Scanner scanner = new Scanner(System.in);
    public int stageZero() {
        Utils utils = new Utils();

        System.out.println(utils.getBienvenida());
        System.out.println("Por favor ingresa el nro. de la opcion deseada");
        System.out.println("===================MENU=======================");
        System.out.println("1. Ingreso de Mercaderia");
        System.out.println("2. Compra de Productos");
        System.out.println("3. Operaciones Especiales");
        System.out.println("0. Salir");
        System.out.print("Introduce tu eleccion: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingresa un número válido.");
            return -1;  // O maneja el error como lo veas conveniente
        }

        return choice;

    }
///////////////////////////////////////////////ADD/////////////////////////////////////////////////////////////////////
    public void stageAdd(Tienda tienda) {
        Utils utils = new Utils();
        clear();
        System.out.println(utils.getGatos());
        System.out.println("Por favor ingresa el nro. de la opcion deseada");
        System.out.println("=================AGREGAR======================");
        System.out.println("1. Ingreso de Bebidas");
        System.out.println("2. Ingreso de Productos Envasados");
        System.out.println("3. Ingreso de Productos de Limpieza");
        System.out.println("0. Volver al menu anterior");
        System.out.println("9. Salir");
        System.out.print("Introduce tu eleccion: ");

        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número válido.");
            stageAdd(tienda);
            return;
        }

        clear();

        switch (choice) {
            case 1:
                stageAddBebidas(tienda);
                break;
            case 2:
                stageAddEnvasados(tienda);
                break;
            case 3:
                stageAddLimpieza(tienda);
                break;
            case 0:
                return;
            case 9:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("_________________!!!!!!!!!!!!!_________________\n" +
                        "Opcion no reconocida. Por favor, elige de nuevo.");
                stageAdd(tienda);
        }

    }

    public void stageAddBebidas(Tienda tienda) {
        Utils utils = new Utils();
        BebidaFlow bebidaFlow= new BebidaFlow();
        clear();
        System.out.println(utils.getGatos());
        System.out.println("Por favor ingresa el nro. de la opcion deseada");
        System.out.println("=================AGREGAR======================");
        System.out.println("Agrega Bebida");
        bebidaFlow.addBebida(tienda);
        stageAdd(tienda);
        int choice = scanner.nextInt();
        scanner.nextLine();

    }


    public void stageAddEnvasados(Tienda tienda) {
        Utils utils = new Utils();
        EnvasadoFlow envasadoFlow= new EnvasadoFlow();
        clear();
        System.out.println(utils.getGatos());
        System.out.println("Por favor ingresa el nro. de la opcion deseada");
        System.out.println("=================AGREGAR======================");
        System.out.println("Agrega Envasado");
        envasadoFlow.addEnvasado(tienda);
        stageAdd(tienda);
        int choice = scanner.nextInt();
        scanner.nextLine();
    }

    public void stageAddLimpieza(Tienda tienda) {
        Utils utils = new Utils();
        LimpiezaFlow limpiezaFlow= new LimpiezaFlow();
        clear();
        System.out.println(utils.getGatos());
        System.out.println("Por favor ingresa el nro. de la opcion deseada");
        System.out.println("=================AGREGAR======================");
        System.out.println("Agrega Producto de Limpieza");
        limpiezaFlow.addLimpieza(tienda);
        stageAdd(tienda);
        int choice = scanner.nextInt();
        scanner.nextLine();
    }
/////////////////////////////////////////////////////BUY////////////////////////////////////////////////////////////////
    public void stageBuy(Tienda tienda) {
        Utils utils = new Utils();
        clear();
        System.out.println(utils.getGatos());
        System.out.println("Por favor ingresa el nro. de la opcion deseada");
        System.out.println("=================COMPRAR======================");
        System.out.println("1. Compra de Bebidas");
        System.out.println("2. Compra de Productos Envasados");
        System.out.println("3. Compra de Productos de Limpieza");
        System.out.println("0. Volver al menu anterior");
        System.out.println("9. Salir");
        System.out.print("Introduce tu eleccion: ");

        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número válido.");
            stageBuy(tienda);
            return;
        }

        clear();

        switch (choice) {
            case 1:
                stageBuyBebidas(tienda);
                break;
            case 2:
                stageAddEnvasados(tienda);
                break;
            case 3:
                stageAddLimpieza(tienda);
                break;
            case 0:
                return;
            case 9:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("_________________!!!!!!!!!!!!!_________________\n" +
                        "Opcion no reconocida. Por favor, elige de nuevo.");
                stageAdd(tienda);
        }

    }

    public void stageBuyBebidas(Tienda tienda) {
        Utils utils = new Utils();
        BebidaFlow bebidaFlow= new BebidaFlow();
        clear();
        System.out.println(utils.getGatos());
        System.out.println("Por favor ingresa el nro. de la opcion deseada");
        System.out.println("=================COMPRAR======================");
        System.out.println("Comprar Bebida");
        bebidaFlow.buyBebida(tienda);
        stageBuy(tienda);
        int choice = scanner.nextInt();
        scanner.nextLine();
    }

    public void stageBuyEnvasados() {

    }

    public void stageBuyLimpieza() {

    }

    public void stageSpecial(Tienda tienda) {
        Utils utils = new Utils();
        clear();
        System.out.println(utils.getGatos());
        System.out.println("Por favor ingresa el nro. de la opcion deseada");
        System.out.println("==============OP.ESPECIALES===================");
        System.out.println("1. Calcular comestibles NO importados,\n" +
                "   cuyo descuento sea menor al que usted determine");
        System.out.println("2. Listar Productos con ganancias\b" +
                "   inferiores al al porcentaje que usted determine");
        System.out.println("3. Listar Cantidad Total de Productos");
        System.out.println("0. Volver al menu anterior");
        System.out.println("9. Salir");
        System.out.print("Introduce tu eleccion: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        clear();

        switch (choice) {
            case 1:
                System.out.println("In construction");
                break;
            case 2:
                System.out.println("In construction");
                break;
            case 3:
                System.out.println("Total: "+tienda.calcularTotalProductos());
                break;
            case 0:
                stageZero();
                break;
            case 9:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("_________________!!!!!!!!!!!!!_________________\n" +
                        "Opcion no reconocida. Por favor, elige de nuevo.");
                stageSpecial(tienda);
        }
    }

    public void clear() {
        for (int i = 0; i < 10; i++) {
            System.out.println("*");
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}