/*
Ejercicio 5.2 — Comparador personalizado con lambda
Ordena la lista de productos del ejercicio anterior por precio ascendente, y luego por cantidad descendente.

Herramientas: lambdas, Comparator, sort o sorted
Restricción: usa Comparator.comparing() encadenado con,
thenComparing() en vez de escribir la lógica de comparación a mano dentro del lambda.
 */
package ejercicios.practica.primera.nivel5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ComparadorPersonalizado {
    public static void main(String[] args) {
        RecStrLam.Producto p1 = new RecStrLam.Producto("p1", 100.0, 12);
        RecStrLam.Producto p2 = new RecStrLam.Producto("p2", 230.0, 90);
        RecStrLam.Producto p3 = new RecStrLam.Producto("p3", 900.0, 2);
        RecStrLam.Producto p4 = new RecStrLam.Producto("p4", 4090.0, 4);

        List<RecStrLam.Producto> productos = new ArrayList<>();
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);

        productos.sort(
                Comparator.comparing(RecStrLam.Producto::precio)
                .thenComparing(Comparator.comparing(RecStrLam.Producto::cantidad).reversed()));

        productos.forEach(System.out::println);

    }
}
