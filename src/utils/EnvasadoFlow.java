package utils;

import model.Bebida;
import model.Envasado;
import model.Tienda;
import model.exception.HandlerException;

import java.util.Scanner;

public class EnvasadoFlow {

    HandlerException handlerException= new HandlerException();
    public void addEnvasado(Tienda tienda){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Introduce la descripcion:");
            String descripcion = scanner.nextLine();
            int stock = handlerException.readInt("Introduce el stock:");
            //CHECA SI HAY CUPO PARA EL STOCK QUE SE QUIERE INGRESAR
            if (tienda.calcularTotalProductos() + stock > tienda.getMaxProductos()) {
                System.out.println("Stock maximo alcanzado. No puedes agregar tantos productos.");
                System.out.println(tienda.cupoParaAgregarProductos());
                return;
            }
            double precioVenta = handlerException.readDouble("Introduce el precio de venta:");
            double costo = handlerException.readDouble("Introduce el costo:");
            //scanner.nextLine();
            TipoEnvase tipoEnvase = handlerException.handleTipoEnvase();
            System.out.println("el envasado es importada? Introduce si/no:");
            String respuestaImportado = scanner.nextLine();
            boolean esImportado = false;
            if ("si".equalsIgnoreCase(respuestaImportado)) {
                esImportado = true;
            } else if ("no".equalsIgnoreCase(respuestaImportado)) {
                esImportado = false;
            } else {
                System.out.println("Respuesta no valida. Se asumira que la envasado no es importada.");
                esImportado = false;
            }
            System.out.println("Introduce fecha de Vencimiento:");
            String fechaVencimiento = scanner.nextLine();
            int calorias = handlerException.readInt("Introduce calorias:");
            double porcentajeDescuento = handlerException.readDouble("Introduce porcentaje de Descuento:");

            Envasado nuevoEnvasado= new Envasado(descripcion, stock, precioVenta,costo, tipoEnvase, esImportado,
                    fechaVencimiento,calorias, porcentajeDescuento);

            tienda.getProductosEnStock().get("model.Envasado").add(nuevoEnvasado);

            System.out.println("Envase agregado exitosamente al inventario!");
            System.out.println("Deseas agregar otro Envase? (si/no)");
            scanner.nextLine();

            String respuesta = scanner.nextLine().toLowerCase();
            scanner.nextLine();

            if (!respuesta.equals("si")) {
                break;
            }else {
                return;
            }
        } while (true);
    }
}
