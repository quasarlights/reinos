package model;

import service.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tienda {
    private String nombre;
    private int maxProductos;
    private int totalProductos = 0;
    private double saldoCaja;
    private Map<String, List<Producto>> productosEnStock = new HashMap<>();


    public Tienda(String nombre, int maxProductos, double saldoCaja) {
        this.nombre = nombre;
        this.maxProductos = maxProductos;
        this.saldoCaja = saldoCaja;
        productosEnStock.put("model.Envasado", new ArrayList<>());
        productosEnStock.put("model.Bebida", new ArrayList<>());
        productosEnStock.put("model.Limpieza", new ArrayList<>());
    }
    public Tienda(String nombre, int maxProductos, double saldoCaja, Map<String, List<Producto>> inventarioInicial) {
        this.nombre = nombre;
        this.maxProductos = maxProductos;
        this.saldoCaja = saldoCaja;
        this.productosEnStock = inventarioInicial;
    }


    //CALCULA LA CANTIDAD TOTAL DE STOCK DE TODOS LOS PRODUCTOS
    public int calcularTotalProductos() {
        int total = 0;
        for (List<Producto> listaProductos : productosEnStock.values()) {
            for (Producto producto : listaProductos) {
                System.out.println("Producto: " + producto + " Stock: " + producto.getStock());
                total += producto.getStock();
            }
        }

        return total;
    }

    //ME INDICA SI NO SE LLEGO AL MAX DE PRODUTOS
    public boolean puedeAgregarProducto(Producto producto) {
        if (this.calcularTotalProductos() + producto.getStock() > maxProductos) {
            return false;
        }
        return true;
    }

    public String cupoParaAgregarProductos(){
        return "Espacio disponible: " + (maxProductos - calcularTotalProductos());
    }


    public boolean agregarProductoAsuLista(String tipo, Producto producto) {
        double costoTotal = producto.getCosto() * producto.getStock();

        // Verificar si hay suficiente saldo en la caja para cubrir el costo total
        if(saldoCaja - costoTotal < 0) {
            System.out.println("No se puede agregar el producto. Saldo insuficiente en la caja.");
            return false;
        }
        if (!puedeAgregarProducto(producto)) {
            System.out.println("No se puede agregar el producto. Stock maximo alcanzado.");
            System.out.println("Espacio disponible: " + (maxProductos - calcularTotalProductos()));
            return false;
        }
        productosEnStock.get(tipo).add(producto);
        saldoCaja -= costoTotal;
        return true;
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

    public int getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(int totalProductos) {
        this.totalProductos = totalProductos;
    }
}
