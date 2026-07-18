/*
Ejercicio 1.2 — Detector de bug de tipos
Escribe un metodo que reciba 3 enteros y calcule su promedio como double. Primero escríbelo "mal"
(a propósito) para que dé un resultado truncado, luego corrígelo.

Herramientas: casting, división entera vs decimal
Restricción: debes explicar en un comentario por qué
el resultado estaba mal antes de corregirlo — no basta con que funcione, tienes que poder explicar la causa raíz.
*/
package ejercicios.practica.primera.nivel1;

public class DetectorDeBugDeTipos {
    public double promedioMal(int a, int b, int c) {
        return  (a + b + c) / 3;
    }

    public double promedioBien(int a, int b, int c) {
        return  (a + b + c) / 3.0;
    }
    public static void main(String[] args) {
        DetectorDeBugDeTipos detector = new DetectorDeBugDeTipos();
        System.out.println(detector.promedioMal(1, 24, 31));
        System.out.println(detector.promedioBien(1, 24, 31));
    }
}

/*
Lo que pasa es que cuando pasa a esta linea return (a + b + c) / 3; pasa lo siguiente
como son puros numeros enteros saca primero a 18.666... pero inmediatamente como este esta en int
lo convierte en 18.0 para que salga bien como double hay dos formas en que pase correctamente el numero
con (double) o ponerle un 3.0 asi forzas al codigo a convertir el int a double para que no pierda
sus decimales.
 */