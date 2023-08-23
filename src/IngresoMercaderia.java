public class IngresoMercaderia {
    private Tienda tienda;

    public IngresoMercaderia(Tienda tienda) {
        this.tienda = tienda;
    }

    public boolean agregarProducto(Producto producto, int cantidad) {
        double costoTotal = producto.getCosto() * cantidad;

        // Verificar si hay suficiente saldo en la caja
        if (tienda.getSaldoCaja() < costoTotal) {
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja.");
            return false;
        }

        // Verificar si no se ha alcanzado el máximo de stock
        if ((tienda.getTotalUnidadesStock() + cantidad) > tienda.getMaxStock()) {
            System.out.println("El producto no podrá ser agregado ya que se supera el máximo de stock permitido.");
            return false;
        }

        // Si todas las condiciones se cumplen, se agrega el producto al stock y se descuenta el costo de la caja
        tienda.agregarProductoStock(producto, cantidad);
        tienda.descontarSaldoCaja(costoTotal);

        return true;
    }
}

// Nota: La clase Tienda necesita tener los siguientes métodos:
// - getSaldoCaja(): devuelve el saldo actual en la caja de la tienda.
// - getTotalUnidadesStock(): devuelve la cantidad total de unidades en stock.
// - getMaxStock(): devuelve el máximo de unidades que puede tener en stock.
// - agregarProductoStock(Producto producto, int cantidad): añade un producto y su cantidad al stock.
// - descontarSaldoCaja(double monto): descuenta el monto del saldo de la caja.

