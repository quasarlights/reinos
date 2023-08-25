package service;

public interface Comestible {
    String fechaVencimiento = null;
    int calorias = 0;
    void setFechaVencimiento(String fecha);
    String getFechaVencimiento();
    void setCalorias(int calorias);
    int getCalorias();
}
