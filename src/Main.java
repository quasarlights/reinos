import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String bienvenida= "   ^    ^    ^\n" +
                "  ^^^  ^^^  ^^^\n" +
                " ^^^^^^^^^^^^^^^\n" +
                " ^^^^^^^^^^^^^^^\n" +
                "    ||  ||  ||\n" +
                "    ||  ||  ||\n" +
                "==================\n"+
                "   BIENVENIDO A \n"+
                "TIENDA LOS 3 PINOS\n"+
                "==================";
        String bienvenida1 = " /\\_/\\     /\\_/\\     /\\_/\\  \n" +
                "( o.o )   ( o.o )   ( o.o ) \n" +
                " > ^ <     > ^ <     > ^ <  \n"+
                "BIENVENIDO A TIENDA LOS 3 GATOS\n"+
                "===============================";

            Scanner scanner = new Scanner(System.in);
            boolean continueRunning = true;

            while (continueRunning) {
                System.out.println(bienvenida1);
                System.out.println("1. Ingreso de Mercaderia 1");
                System.out.println("2. Venta de Productos 2");
                System.out.println("3. Salir");
                System.out.print("Introduce tu elección: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // consume newline

                switch (choice) {
                    case 1:
                        handleOption1();
                        break;
                    case 2:
                        handleOption2();
                        break;
                    case 3:
                        continueRunning = false;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no reconocida. Por favor, elige de nuevo.");
                }
            }
        }

        public static void handleOption1() {
            System.out.println("Elegiste la opción 1");
            // Aquí va tu código para manejar esta opción
        }

        public static void handleOption2() {
            System.out.println("Elegiste la opción 2");
            // Aquí va tu código para manejar esta opción
        }

}