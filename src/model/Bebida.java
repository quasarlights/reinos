package model;

import service.Comestible;
import service.Producto;

public class Bebida extends Producto implements Comestible {
    private static int contadorId = 0;
    private boolean esAlcoholica;
    private double graduacionAlcoholica;
    private boolean esImportado;
    private String fechaVencimiento;
    private int calorias;

    

    public Bebida(String descripcion, int stock, double precioVenta, double costo, boolean esAlcoholica, double graduacionAlcoholica, boolean esImportado, String fechaVencimiento, int calorias) {
        super(descripcion, stock, precioVenta, costo);
        this.esAlcoholica = esAlcoholica;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.esImportado = esImportado;
        this.fechaVencimiento = fechaVencimiento;
        this.calorias = calorias;
    }



    @Override
    public void setFechaVencimiento(String fecha) {

    }

    @Override
    public String getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    @Override
    public void setCalorias(int calorias) {
        this.setCalorias(calorias);
    }

    @Override
    public int getCalorias() {
        return this.getCalorias();
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
        return (this.precioVenta * this.getPorcentajeDescuento())/100;
    }

    public boolean isEsAlcoholica() {
        return esAlcoholica;
    }

    public void setEsAlcoholica(boolean esAlcoholica) {
        this.esAlcoholica = esAlcoholica;
    }

    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "esAlcoholica=" + esAlcoholica +
                ", graduacionAlcoholica=" + graduacionAlcoholica +
                ", esImportado=" + esImportado +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", calorias=" + calorias +
                ", identificador='" + identificador + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", precioVenta=" + precioVenta +
                ", costo=" + costo +
                ", disponibleVenta=" + disponibleVenta +
                '}';
    }

    @Override
    protected String generarIdentificador() {
        contadorId++;
        return "AC" + String.format("%03d", contadorId);
    }
}
