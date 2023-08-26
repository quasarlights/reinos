package utils;

import model.Bebida;
import model.Tienda;
import model.exception.HandlerException;
import operation.Venta;
import service.Producto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BebidaFlow {
    HandlerException handlerException= new HandlerException();
    Scanner scanner = new Scanner(System.in);
    public void addBebida(Tienda tienda){

        do {
            System.out.println("Introduce la descripcion:");
            String descripcion = scanner.nextLine();
            int stock = handlerException.readInt("Introduce el stock:");
            //CHECA SI HAY CUPO PARA EL STOCK QUE SE QUIERE INGRESAR
            if (tienda.calcularTotalProductos() + stock > tienda.getMaxProductos()) {
                System.out.println("Stock máximo alcanzado. No puedes agregar tantos productos.");
                System.out.println(tienda.cupoParaAgregarProductos());
                return;
            }
            double precioVenta = handlerException.readDouble("Introduce el precio de venta:");
            double costo = handlerException.readDouble("Introduce el costo:");
            //scanner.nextLine();
            System.out.println("Es la bebida alcoholica? (si/no):");
            String respuestaAlc = scanner.nextLine();
            boolean esAlcoholica;
            double graduacionAlcoholica = 0.0;

            if (respuestaAlc.equalsIgnoreCase("si")) {
                esAlcoholica = true;
                graduacionAlcoholica = handlerException.readDouble("Ingrese la graduacion alcoholica:");

            } else if (respuestaAlc.equalsIgnoreCase("no")) {
                esAlcoholica = false;

            } else {
                System.out.println("Respuesta no reconocida. Asumiendo que la bebida no es alcoholica.");
                esAlcoholica = false;
            }
            //scanner.nextLine();
            System.out.println("La bebida es importada? Introduce si/no:");
            String respuestaImportado = scanner.nextLine();
            boolean esImportado = false;
            if ("si".equalsIgnoreCase(respuestaImportado)) {
                esImportado = true;
            } else if ("no".equalsIgnoreCase(respuestaImportado)) {
                esImportado = false;
            } else {
                System.out.println("Respuesta no valida. Se asumira que la bebida no es importada.");
                esImportado = false;
            }
            System.out.println("Introduce fecha de Vencimiento:");
            String fechaVencimiento = scanner.nextLine();
            int calorias = handlerException.readInt("Introduce calorias:");
            double porcentajeDescuento = handlerException.readDouble("Introduce porcentaje de Descuento:");

            Bebida nuevaBebida = new Bebida(descripcion, stock, precioVenta, costo,
                    esAlcoholica, graduacionAlcoholica, esImportado, fechaVencimiento, calorias, porcentajeDescuento);

            tienda.getProductosEnStock().get("model.Bebida").add(nuevaBebida);

            System.out.println("Bebida agregada exitosamente al inventario!");
            System.out.println("Deseas agregar otra bebida? (si/no)");
            scanner.nextLine();  // consume the newline
            String respuesta = scanner.nextLine().toLowerCase();

            if (!respuesta.equals("si")) {
                break;
            }
        } while (true);
    }

    public void buyBebida(Tienda tienda){
        do {
            System.out.println("******************************************");
            System.out.println("Aprieta Enter para ver la lista de Bebidas");
            System.out.println("******************************************");
            scanner.nextLine();
            List<Producto> bebidas = tienda.getProductosEnStock().get("model.Bebida");
            for (Producto bebida : bebidas) {
                System.out.println(bebida);
            }

        } while (true);

    }
}
