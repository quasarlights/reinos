public class Bebida extends Producto implements Comestible{
    private boolean esAlcoholica;
    private double graduacionAlcoholica;
    private boolean esImportado;
    private String fechaVencimiento;
    private int calorias;

    public Bebida() {
    }

    public Bebida(String identificador, String descripcion, int stock, double precioVenta, double costo, boolean disponibleVenta, boolean esAlcoholica, double graduacionAlcoholica, boolean esImportado, String fechaVencimiento, int calorias) {
        super(identificador, descripcion, stock, precioVenta, costo, disponibleVenta);
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
}
