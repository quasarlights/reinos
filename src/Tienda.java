import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tienda {
    private String nombre;
    private int maxProductos;
    private double saldoCaja;
    private Map<String, List<Producto>> productosEnStock = new HashMap<>();

    public Tienda() {
    }
    public Tienda(String nombre, int maxProductos, double saldoCaja) {
        this.nombre = nombre;
        this.maxProductos = maxProductos;
        this.saldoCaja = saldoCaja;
        productosEnStock.put("Envasado", new ArrayList<>());
        productosEnStock.put("Bebida", new ArrayList<>());
        productosEnStock.put("Limpieza", new ArrayList<>());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxProductos() {
        return maxProductos;
    }

    public void setMaxProductos(int maxProductos) {
        this.maxProductos = maxProductos;
    }

    public double getSaldoCaja() {
        return saldoCaja;
    }

    public void setSaldoCaja(double saldoCaja) {
        this.saldoCaja = saldoCaja;
    }

    public Map<String, List<Producto>> getProductosEnStock() {
        return productosEnStock;
    }

    public void setProductosEnStock(Map<String, List<Producto>> productosEnStock) {
        this.productosEnStock = productosEnStock;
    }
}
