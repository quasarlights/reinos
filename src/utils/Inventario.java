package utils;

import model.Bebida;
import model.Envasado;
import model.Limpieza;
import service.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {
    public Map<String, List<Producto>> inicializarProductos() {
        Map<String, List<Producto>> productosIniciales = new HashMap<>();

        // Crear listas para cada tipo de producto
        List<Producto> bebidas = new ArrayList<>();
        List<Producto> envasados = new ArrayList<>();
        List<Producto> limpiezas = new ArrayList<>();

        /////////BEBIDAS
        bebidas.add(new Bebida("Coca Cola",2, 33,22, false, 0,
                false, "01/01/2024", 250, 0));
        bebidas.add(new Bebida("Pepsi",3, 30,20, false, 0,
                false, "01/03/2024", 250, 5));
        bebidas.add(new Bebida("Manaos",5, 25,15, false, 0,
                false, "01/01/2024", 250, 3));
        bebidas.add(new Bebida("Fanta",2, 35,25, false, 0,
                false, "01/11/2023", 250, 10));
        bebidas.add(new Bebida("Sprite",1, 40,25, false, 0,
                false, "01/01/2024", 250, 8));

        /////////ENVASADOS
        envasados.add(new Envasado("Arvejas Arcor", 6, 10, 7, TipoEnvase.LATA, false,
                "01/01/2028", 100, 20));
        envasados.add(new Envasado("Tomate Molto", 3, 12, 7, TipoEnvase.LATA, false,
                "01/01/2029", 100, 5));
        envasados.add(new Envasado("Choclo Arcor", 4, 10, 7, TipoEnvase.LATA, false,
                "01/01/2028", 100, 10));
        envasados.add(new Envasado("Oreo", 10, 15, 12, TipoEnvase.PLASTICO, false,
                "01/01/2024", 500, 0));
        envasados.add(new Envasado("Alfajor Havanna", 2, 20, 13, TipoEnvase.PLASTICO, false,
                "01/01/2025", 100, 20));

        ////////LIMPIEZA
        limpiezas.add(new Limpieza("Detergente Cif", 6, 20, 18, TipoAplicacion.COCINA, 0));
        limpiezas.add(new Limpieza("Cera Suiza", 2, 40, 28, TipoAplicacion.PISOS, 10));
        limpiezas.add(new Limpieza("Cif Crema", 3, 25, 18, TipoAplicacion.MULTIUSO, 30));
        limpiezas.add(new Limpieza("Ayudin Lavandina", 5, 13, 17, TipoAplicacion.MULTIUSO, 20));
        limpiezas.add(new Limpieza("Detergente Ala", 3, 19, 18, TipoAplicacion.COCINA, 30));

        productosIniciales.put("model.Bebida", bebidas);
        productosIniciales.put("model.Envasado", envasados);
        productosIniciales.put("model.Limpieza", limpiezas);

        return productosIniciales;
    }
}
