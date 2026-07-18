/*
Ejercicio 1.1 — Conversor de temperatura
Escribe un programa que reciba una temperatura en Celsius (puedes usar un valor fijo por ahora)
y la convierta a Fahrenheit y Kelvin, mostrando los 3 valores.

Herramientas: variables, tipos (double), operadores aritméticos
Restricción: el resultado en Fahrenheit
debe mostrar exactamente 2 decimales — investiga cómo lograr eso sin usar Math.round().
*/

package ejercicios.practica.primera.nivel1;

import java.util.Scanner;

public class ConversorDeTemperatura {
    public static void main(String[] args) {
        final String celsius = "Celsius";
        final String fahrenheit = "Fahrenheit";
        final String kelvin = "Kelvin";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el temperatura en " + celsius + ": ");

        double temperatura = scanner.nextDouble();

        int temperaturaF = (int) ((temperatura * 9/5) + 32 + 0.5);

        System.out.println("Temperatura en " + celsius + ": " + temperatura);
        System.out.println("Temperatura en " + fahrenheit + ": " + temperaturaF);
        System.out.println("Temperatura en " + kelvin + ": " + (temperatura + 273.15) );

    }
}
