package operation;

import service.Producto;

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
            System.out.println("Producto invalido o cantidad no valida.");
            return;
        }

        if (producto.getStock() < cantidad) {
            System.out.println("Hay productos con stock disponible menor al solicitado.");
            return;
        }

        if (producto.isDisponibleVenta()) {
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

