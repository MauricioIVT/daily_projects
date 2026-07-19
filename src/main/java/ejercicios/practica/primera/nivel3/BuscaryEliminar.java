/*
Ejercicio 3.2 — Buscar y eliminar con seguridad
Ten una List<String> con nombres repetidos. Elimina todas las apariciones de un nombre específico.

Herramientas: bucles, List
Restricción: debes resolverlo de 2 formas distintas (por ejemplo, Iterator y removeIf),
 y en un comentario explicar por qué un for-each normal no funcionaría aquí.
*/
package ejercicios.practica.primera.nivel3;

import java.util.ArrayList;
import java.util.List;

public class BuscaryEliminar {
    public static void main(String[] args) {
        List <String> lista = new ArrayList();
        lista.add("juan");
        lista.add("juan");
        lista.add("juan");
        lista.add("trejo");
        lista.add("luis");
        lista.add("mauricio");

        List <String> listaActualizada = lista.stream().filter(s -> !s.equals("juan")).toList();

        listaActualizada.forEach(System.out::println);
        lista.removeIf(s -> s.equals("juan"));

    }
}

/*
La razón por que no se puede eliminar con for.each es simplemente porque el for está en vivo
o sea en tiempo real vas pasando por la lista y esta misma no puedes añadir o eliminar,
ya que eso afectaría directamente a la lectura del for.each por ende tendria un error:
ConcurrentModificationException
*/