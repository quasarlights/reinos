public class Envasado extends Producto{
    private String tipoEnvase; // plástico, vidrio, lata
    private boolean esImportado;

    public Envasado() {
    }

    public Envasado(String identificador, String descripcion, int stock, double precioVenta, double costo, boolean disponibleVenta, String tipoEnvase, boolean esImportado) {
        super(identificador, descripcion, stock, precioVenta, costo, disponibleVenta);
        this.tipoEnvase = tipoEnvase;
        this.esImportado = esImportado;
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



    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }
}
