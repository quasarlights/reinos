package model;

import service.Comestible;
import service.Producto;
import utils.TipoEnvase;

public class Envasado extends Producto implements Comestible {
    private static int contadorId = 0;
    private TipoEnvase tipoEnvase;
    private boolean esImportado;
    private String fechaVencimiento;
    private int calorias;
    private double porcentajeDescuento;

    private boolean esIdentificadorValido(String identificador) {
        return identificador.matches("^AB\\d{3}$");
    }


    public Envasado(String descripcion, int stock, double precioVenta, double costo, TipoEnvase tipoEnvase,
                    boolean esImportado, String fechaVencimiento, int calorias, double porcentajeDescuento) {
        super(descripcion, stock, precioVenta, costo);
        if (!esIdentificadorValido(identificador)) {
            throw new IllegalArgumentException("Identificador inválido para model.Envasado. Debe seguir el formato ABXXX.");
        }

        this.tipoEnvase = tipoEnvase;
        this.esImportado = esImportado;
        this.fechaVencimiento = fechaVencimiento;
        this.calorias = calorias;
        this.porcentajeDescuento= porcentajeDescuento;
    }

    @Override
    protected String generarIdentificador() {
        contadorId++;  // Incrementa el contador
        return "AB" + String.format("%03d", contadorId);
    }

    @Override
    public void setIdentificador(String identificador) {
        if (!esIdentificadorValido(identificador)) {
            throw new IllegalArgumentException("Identificador inválido para model.Envasado. Debe seguir el formato ABXXX.");
        }
        this.identificador = identificador;
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
        return (this.precioVenta * this.getPorcentajeDescuento())/100;
    }



    public TipoEnvase getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = TipoEnvase.valueOf(tipoEnvase);
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    @Override
    public void setFechaVencimiento(String fecha) {

    }

    @Override
    public String getFechaVencimiento() {
        return null;
    }

    @Override
    public void setCalorias(int calorias) {

    }

    @Override
    public int getCalorias() {
        return 0;
    }

    @Override
    public boolean esImportado() {
        return false;
    }

    @Override
    public String toString() {
        return "CODIGO: " +
                identificador +
                ", " + descripcion + '\'' +
                ", stock " + stock +
                ", DESCUENTO "+ porcentajeDescuento+"%"+
                ", tipoEnvase " + tipoEnvase +
                ", esImportado " + esImportado +
                ", fechaVencimiento '" + fechaVencimiento + '\'' +
                ", calorias " + calorias +
                ", precioVenta " + precioVenta;
    }
}
