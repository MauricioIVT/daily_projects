/*
Ejercicio 5.1 — Inventario con records
Crea un record Producto(String nombre, double precio, int cantidad). Con una List<Producto>,
calcula usando Streams: el producto más caro, el valor total del inventario, y una lista de nombres de productos
con menos de 5 unidades.

Herramientas: record, Streams (filter, map, max, reduce o sum)
Restricción: no puedes usar ningún for -> todo debe resolverse con métodos de Stream.
 */
package ejercicios.practica.primera.nivel5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecStrLam {
    public record Producto(String nombre, double precio, int cantidad) {}

    public static void main(String[] args) {
        Producto p1 = new Producto("p1", 100.0, 12);
        Producto p2 = new Producto("p2", 230.0, 90);
        Producto p3 = new Producto("p3", 900.0, 2);
        Producto p4 = new Producto("p4", 4090.0, 4);

        List<Producto> productos = new ArrayList<>();
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);

        productos.stream().max(Comparator.comparingDouble(Producto::precio))
                .ifPresent(producto -> System.out.println("el producto mas caro es " + producto.nombre() + " con un precio de " + producto.precio()));

       double total = productos.stream().mapToDouble(producto -> producto.cantidad() * producto.precio()).sum();
        System.out.println("El total de los productos es " + total);

        List<String> nombreProducto = productos.stream()
                .filter(producto -> producto.cantidad() < 5)
                .map(Producto::nombre).toList();

        System.out.println("Nombres de los productos es " + nombreProducto);
    }
}
