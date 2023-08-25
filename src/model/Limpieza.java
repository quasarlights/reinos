package model;

import service.Producto;

public class Limpieza extends Producto {
    private static int contadorId = 0;
    public enum TipoAplicacion {COCINA, PISOS, ROPA, MULTIUSO}
    private TipoAplicacion tipoAplicacion;

    public Limpieza() {
    }

    @Override
    protected String generarIdentificador() {
        contadorId++;
        return "AZ" + String.format("%03d", contadorId);
    }

    public Limpieza( String descripcion, int stock, double precioVenta, double costo, boolean disponibleVenta, TipoAplicacion tipoAplicacion) {
        super( descripcion, stock, precioVenta, costo);
        this.tipoAplicacion = tipoAplicacion;
    }

    @Override
    public void setPorcentajeDescuento(double descuento) {
        this.setPorcentajeDescuento(descuento);
    }

    @Override
    public double getPorcentajeDescuento() {
        return this.getPorcentajeDescuento();
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
}
