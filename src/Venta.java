import java.util.HashMap;
import java.util.Map;

public class Venta {
    private Map<Producto, Integer> productosVendidos;
    private double total;

    public Venta() {
        productosVendidos = new HashMap<>();
        total = 0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) {
            System.out.println("Producto inválido o cantidad no válida.");
            return;
        }

        if (producto.getStock() < cantidad) {
            System.out.println("Hay productos con stock disponible menor al solicitado.");
            cantidad = producto.getStock();
        }

        if (producto.isDisponible()) {
            productosVendidos.put(producto, cantidad);
            total += producto.getPrecioVenta() * cantidad;
            producto.reducirStock(cantidad);
        } else {
            System.out.println("El producto " + producto.getIdentificador() + " " + producto.getDescripcion() + " no se encuentra disponible.");
        }
    }

    public void imprimirDetalle() {
        for (Map.Entry<Producto, Integer> entry : productosVendidos.entrySet()) {
            Producto producto = entry.getKey();
            Integer cantidad = entry.getValue();
            System.out.println(producto.getIdentificador() + " " + producto.getDescripcion() + " " + cantidad + " x " + producto.getPrecioVenta());
        }
        System.out.println("TOTAL VENTA: " + total);
    }

    public double getTotal() {
        return total;
    }
}

// Nota: La clase Producto necesita tener los siguientes métodos:
// - getStock(): devuelve la cantidad de stock del producto.
// - isDisponible(): indica si el producto está disponible para la venta.
// - getPrecioVenta(): devuelve el precio de venta del producto.
// - reducirStock(int cantidad): reduce el stock del producto por la cantidad dada.
// - getIdentificador(): devuelve el identificador del producto.
// - getDescripcion(): devuelve la descripción del producto.
