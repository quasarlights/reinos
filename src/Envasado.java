public class Envasado extends Producto{
    private String tipoEnvase; // plástico, vidrio, lata
    private boolean esImportado;

    private boolean esIdentificadorValido(String identificador) {
        return identificador.matches("^AB\\d{3}$");
    }


    public Envasado(String identificador, String descripcion, int stock, double precioVenta, double costo, boolean disponibleVenta, String tipoEnvase, boolean esImportado) {
        super(identificador, descripcion, stock, precioVenta, costo, disponibleVenta);
        if (!esIdentificadorValido(identificador)) {
            throw new IllegalArgumentException("Identificador inválido para Envasado. Debe seguir el formato ABXXX.");
        }

        this.tipoEnvase = tipoEnvase;
        this.esImportado = esImportado;
    }

    @Override
    public void setIdentificador(String identificador) {
        if (!esIdentificadorValido(identificador)) {
            throw new IllegalArgumentException("Identificador inválido para Envasado. Debe seguir el formato ABXXX.");
        }
        this.identificador = identificador;
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
