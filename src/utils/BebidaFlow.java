package utils;

import model.Bebida;
import model.Tienda;
import model.exception.HandlerException;
import operation.Venta;
import service.Producto;

import java.util.List;
import java.util.Scanner;

public class BebidaFlow {
    HandlerException handlerException= new HandlerException();
    Scanner scanner = new Scanner(System.in);
    public void addBebida(Tienda tienda) {

        do {
            System.out.println("Introduce la descripcion:");
            String descripcion = scanner.nextLine();
            int stock = handlerException.readInt("Introduce el stock:");
            //CHECA SI HAY CUPO PARA EL STOCK QUE SE QUIERE INGRESAR
            if (tienda.calcularTotalProductos() + stock > tienda.getMaxProductos()) {
                System.out.println("Stock máximo alcanzado. No puedes agregar tantos productos.");
                System.out.println(tienda.cupoParaAgregarProductos());
                return;}
                scanner.nextLine();
                double precioVenta = handlerException.readDouble("Precio Venta");
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

    //Venta venta = new Venta();

    public void buyBebida(Tienda tienda, Venta miVenta){

        do {
            System.out.println("******************************************");
            System.out.println("Aprieta Enter para ver la lista de Bebidas");
            System.out.println("******************************************");
            scanner.nextLine();

            List<Producto> bebidas = tienda.getProductosEnStock().get("model.Bebida");
            for (Producto bebida : bebidas) {
                System.out.println(bebida.getIdentificador() + " - " + bebida.getDescripcion() + " - Precio: " + bebida.getPrecioVenta() + " - Stock: " + bebida.getStock());
            }

            System.out.println("Introduce el identificador del producto que quieres comprar o 'salir' para terminar:");
            String idProducto = scanner.nextLine();

            if ("salir".equalsIgnoreCase(idProducto)) {
                break;
            }

            Producto productoSeleccionado = bebidas.stream()
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
            System.out.println("Producto agregado a la venta. Deseas agregar otra Bebida? (si/no)");
            String respuesta = scanner.nextLine().toLowerCase();

            if (!respuesta.equals("si")) {
                break;
            }
        } while (true);

        //venta.imprimirDetalle();
    }
    }

