package utils;

import model.Bebida;
import model.Envasado;
import model.Tienda;
import model.exception.HandlerException;
import operation.Venta;
import service.Producto;

import java.util.List;
import java.util.Scanner;

public class EnvasadoFlow {

    HandlerException handlerException= new HandlerException();
    Scanner scanner = new Scanner(System.in);
    public void addEnvasado(Tienda tienda){

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

    public void buyEnvasado(Tienda tienda, Venta miVenta){

        do {
            System.out.println("******************************************");
            System.out.println("Aprieta Enter para ver la lista de Envasados");
            System.out.println("******************************************");
            scanner.nextLine();

            List<Producto> envasados = tienda.getProductosEnStock().get("model.Envasado");
            for (Producto envasado : envasados) {
                System.out.println(envasado.getIdentificador() + " - " + envasado.getDescripcion() + " - Precio: " + envasado.getPrecioVenta() + " - Stock: " + envasado.getStock());
            }

            System.out.println("Introduce el identificador del producto que quieres comprar o 'salir' para terminar:");
            String idProducto = scanner.nextLine();

            if ("salir".equalsIgnoreCase(idProducto)) {
                break;
            }

            Producto productoSeleccionado = envasados.stream()
                    .filter(p -> p.getIdentificador().equals(idProducto))
                    .findFirst()
                    .orElse(null);

            if (productoSeleccionado == null) {
                System.out.println("Identificador no válido. Por favor, selecciona un producto válido.");
                continue;
            }

            System.out.println("Introduce la cantidad que quieres comprar:");
            int cantidad = scanner.nextInt();
            scanner.nextLine();  // Limpia el buffer

            miVenta.agregarProducto(productoSeleccionado, cantidad);
            System.out.println("Producto agregado a la venta. Deseas agregar otro producto Envasado? (si/no)");
            String respuesta = scanner.nextLine().toLowerCase();

            if (!respuesta.equals("si")) {
                break;
            }
        } while (true);

        //venta.imprimirDetalle();
    }
}
