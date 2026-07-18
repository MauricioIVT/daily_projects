/*
Ejercicio 3.1 — Números primos
Escribe un metodo que reciba un número y determine si es primo.

Herramientas: for, operador módulo %, condicionales
Restricción: tu solución debe detenerse tan pronto sepa la respuesta
(no debe seguir iterando innecesariamente después de encontrar un divisor) — piensa en break o en un return temprano.
*/
package ejercicios.practica.primera.nivel3;

public class NumerosPrimos {
    public String primo(int numero) {
        int contador = 0;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return "numero no par";
            }
        }
        return "numero primo";
    }

    public static void main(String[] args) {
        NumerosPrimos np = new NumerosPrimos();
        System.out.println(np.primo(97));
    }
}

