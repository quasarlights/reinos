package utils;

import model.Envasado;
import model.Limpieza;
import model.Tienda;
import model.exception.HandlerException;
import operation.Venta;
import service.Producto;

import java.util.List;
import java.util.Scanner;

public class LimpiezaFlow {
    HandlerException handlerException= new HandlerException();
    Scanner scanner = new Scanner(System.in);
    public void addLimpieza(Tienda tienda){

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
            TipoAplicacion tipoAplicacion = handlerException.handleTipoAplicacion();
            double porcentajeDescuento = handlerException.readDouble("Introduce porcentaje de Descuento:");


            Limpieza nuevoLimpieza= new Limpieza(descripcion,stock,precioVenta,costo,
                    tipoAplicacion, porcentajeDescuento);

            tienda.getProductosEnStock().get("model.Limpieza").add(nuevoLimpieza);

            System.out.println("Producto de Limpieza agregado exitosamente al inventario!");
            System.out.println("Deseas agregar otro Producto de Limpieza? (si/no)");
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

    public void buyLimpieza(Tienda tienda, Venta miVenta){

        do {
            System.out.println("******************************************");
            System.out.println("Aprieta Enter para ver la lista de Envasados");
            System.out.println("******************************************");
            scanner.nextLine();

            List<Producto> limpiezas = tienda.getProductosEnStock().get("model.Limpieza");
            for (Producto limpieza : limpiezas) {
                System.out.println(limpieza.getIdentificador() + " - " + limpieza.getDescripcion() + " - Precio: " + limpieza.getPrecioVenta() + " - Stock: " + limpieza.getStock());
            }

            System.out.println("Introduce el identificador del producto que quieres comprar o 'salir' para terminar:");
            String idProducto = scanner.nextLine();

            if ("salir".equalsIgnoreCase(idProducto)) {
                break;
            }

            Producto productoSeleccionado = limpiezas.stream()
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
            System.out.println("Producto agregado a la venta. Deseas agregar otro producto de Limpieza? (si/no)");
            String respuesta = scanner.nextLine().toLowerCase();

            if (!respuesta.equals("si")) {
                break;
            }
        } while (true);

        //venta.imprimirDetalle();
    }
}
