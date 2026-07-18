/*
Ejercicio 2.1 — Clasificador de triángulos
Dado el largo de 3 lados (como double),
determina si forman un triángulo válido, y si sí, si es equilátero, isósceles o escaleno.

Herramientas: if/else, operadores relacionales y lógicos
Restricción: no puedes usar más de un if anidado
dentro de otro if — tienes que resolverlo con condiciones combinadas (&&, ||) o
revisando el orden correcto de evaluación.

*/

package ejercicios.practica.primera.nivel2;

public class ClasificadorDeTriangulos {
    public static String triangulo(double a, double b, double c) {
        if ((a + b > c) && (a + c > b) && (b + c > a)){
            if (a == b && a == c && b == c) {
                return "Triangulo equilatero";
            }else if (a != b && b != c && c != a) {
                return "Triangulo escaleno";

            }else{
                return "Triangulo isosceles";
            }
        }else{
            return "No es valido las medias de tu triangulo!.";
        }

    }

    public static void main(String[] args) {
        System.out.println(ClasificadorDeTriangulos.triangulo(12,20,15));
    }
}
