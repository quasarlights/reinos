package utils;

import model.Envasado;
import model.Limpieza;
import model.Tienda;
import model.exception.HandlerException;

import java.util.Scanner;

public class LimpiezaFlow {
    HandlerException handlerException= new HandlerException();
    public void addLimpieza(Tienda tienda){
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
}
