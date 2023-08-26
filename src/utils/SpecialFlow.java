package utils;

import model.Tienda;
import model.exception.HandlerException;
import service.Comestible;
import service.Descuento;
import service.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpecialFlow {
    HandlerException handlerException= new HandlerException();
    Consola consola= new Consola();
    public void specialOne(Tienda tienda){
        //consola.getScanner().nextLine();
        System.out.println("Vamos a calcular los productos NO importados con porcentaje de descuento menor a" +
                "lo que usted fije a continuacion:");
        double maxDescuento = handlerException.readDouble("Ingrese porcentaje:");
        filtrarComestiblesPorDescuento(tienda, maxDescuento);

    }

    public  void specialTwo(Tienda tienda){
        System.out.println("Vamos a ver los productos y sus cantidades, los cuales esten generando menor porcentaje" +
                "de ganancia a lo que usted fije a continuacion:");
        double porcentajeGanancia = handlerException.readDouble("Ingrese porcentaje:");
        listarProductosConUtilidadesInferiores(tienda,porcentajeGanancia);
    }

    public void filtrarComestiblesPorDescuento(Tienda tienda, double maxDescuento) {
        List<Producto> bebidas = tienda.getProductosEnStock().get("model.Bebida");
        List<Producto> envasados = tienda.getProductosEnStock().get("model.Envasado");

        List<Producto> comestibles = new ArrayList<>();
        comestibles.addAll(bebidas);
        comestibles.addAll(envasados);

        List<Producto> productosFiltrados = comestibles.stream()
                .filter(p -> !((Comestible) p).esImportado())
                .filter(p -> ((Descuento) p).getPorcentajeDescuento() < maxDescuento)
                .collect(Collectors.toList());

        System.out.println("Productos filtrados:");
        for (Producto producto : productosFiltrados) {
            System.out.println(producto);
        }
    }

    public void listarProductosConUtilidadesInferiores(Tienda tienda, double porcentaje_utilidad) {
        // Combina todos los productos en una lista
        List<Producto> todosProductos = new ArrayList<>();
        tienda.getProductosEnStock().values().forEach(todosProductos::addAll);

        // Filtrar productos con utilidad menor al porcentaje dado
        List<Producto> productosFiltrados = todosProductos.stream()
                .filter(p -> p.getUtilidad() < (p.getPrecioVenta() * porcentaje_utilidad / 100))
                .collect(Collectors.toList());

        // Imprimir productos filtrados
        System.out.println("Productos con utilidades inferiores al " + porcentaje_utilidad + "%:");
        productosFiltrados.forEach(p -> System.out.println("COD: " + p.getIdentificador() +
                ", " + p.getDescripcion() +
                ", Stock " + p.getStock()));
    }


}
