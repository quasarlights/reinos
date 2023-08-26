package model;

import service.Producto;
import utils.TipoAplicacion;

public class Limpieza extends Producto {
    private static int contadorId = 0;
    private TipoAplicacion tipoAplicacion;
    private double porcentajeDescuento;

    public Limpieza() {
    }

    @Override
    protected String generarIdentificador() {
        contadorId++;
        return "AZ" + String.format("%03d", contadorId);
    }

    public Limpieza( String descripcion, int stock, double precioVenta, double costo,
                     TipoAplicacion tipoAplicacion, double porcentajeDescuento) {
        super( descripcion, stock, precioVenta, costo);
        this.tipoAplicacion = tipoAplicacion;
        this.porcentajeDescuento= porcentajeDescuento;
    }

    @Override
    public void setPorcentajeDescuento(double descuento) {

        this.porcentajeDescuento= descuento;
    }

    @Override
    public double getPorcentajeDescuento() {

        return this.porcentajeDescuento;
    }

    @Override
    public double precioConDescuento() {
        return (this.precioVenta * this.getPorcentajeDescuento()) /100;
    }

    public TipoAplicacion getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(TipoAplicacion tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }

    @Override
    public String toString() {
        return "CODIGO: " +
                identificador +
                ", " + descripcion + '\'' +
                ", stock " + stock +
                ", DESCUENTO "+ porcentajeDescuento+"%"+
                ", tipoAplicacion " + tipoAplicacion +
                ", precioVenta " + precioVenta;
    }
}
