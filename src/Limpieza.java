public class Limpieza extends Producto{
    public enum TipoAplicacion {COCINA, PISOS, ROPA, MULTIUSO}
    private TipoAplicacion tipoAplicacion;

    public Limpieza() {
    }

    public Limpieza(String identificador, String descripcion, int stock, double precioVenta, double costo, boolean disponibleVenta, TipoAplicacion tipoAplicacion) {
        super(identificador, descripcion, stock, precioVenta, costo, disponibleVenta);
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
