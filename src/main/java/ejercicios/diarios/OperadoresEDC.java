/*
 * EJERCICIO:
 * DIFICULTAD EXTRA (opcional):
 * Crea un programa que imprima por consola todos los números comprendidos
 * entre 10 y 55 (incluidos), pares, y que no son ni el 16 ni múltiplos de 3.
 *
 * Seguro que al revisar detenidamente las posibilidades has descubierto algo nuevo.
 */

package ejercicios.diarios;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OperadoresEDC {
    public static void main(String[] args) {

        for(int a=10; a <= 55; a++){

            if(a % 2 == 0 && a != 16 && a % 3 != 0){
                System.out.println(a);
            }

        }
    }
}


