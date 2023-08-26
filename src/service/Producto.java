package service;

import service.Descuento;

abstract public class Producto implements Descuento  {
    protected String identificador;
    protected String descripcion;
    protected int stock;
    protected double precioVenta;
    protected double costo;
    protected boolean disponibleVenta=true;


    public Producto() {
    }


    public Producto(String descripcion, int stock, double precioVenta, double costo) {
        this.identificador = generarIdentificador();
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.costo = costo;
        this.disponibleVenta = disponibleVenta;

    }
    protected abstract String generarIdentificador();

    public double getUtilidad(){
        double utilidad = this.getPrecioVenta() - this.getCosto();
        return (utilidad / this.getPrecioVenta()) * 100;
    }
    public void reducirStock(int cantidad){
        this.stock -= cantidad;
    }

    public void  aumentarStock(int cantidad){
        this.stock += cantidad;
    }
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isDisponibleVenta() {
        return disponibleVenta;
    }

    public void setDisponibleVenta(boolean disponibleVenta) {
        this.disponibleVenta = disponibleVenta;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "identificador='" + identificador + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", precioVenta=" + precioVenta +
                ", costo=" + costo +
                ", disponibleVenta=" + disponibleVenta +
                '}';
    }
}
