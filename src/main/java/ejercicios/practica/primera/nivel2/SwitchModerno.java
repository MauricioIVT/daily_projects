/*
Ejercicio 2.2 — Switch moderno
Crea un metodo que reciba un mes (1-12)
 y devuelva la cantidad de días de ese mes (ignora años bisiestos por ahora).

Herramientas: switch con flechas (->), agrupación de casos
Restricción: debe usar la sintaxis moderna de switch (no el clásico con break).
*/
package ejercicios.practica.primera.nivel2;

import java.util.Scanner;

public class SwitchModerno {
    public String getMes(int mes) {
        return switch (mes) {
            case  1,3,5,7,8,10,12-> "el mes cuenta con 31 días";
            case 4,6,9,11 -> "el mes cuenta con 30 días";
            case  2 -> "cuenta con 28 días";
            default -> "No entra entre los 12 meses principales!";
        };
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SwitchModerno s = new SwitchModerno();
        System.out.println("Días por el mes seleccionado");
        boolean isValid = true;
        while (isValid) {
            System.out.println("Ingrese el valor del mes (1-12): ");
            if (sc.hasNextInt()) {
                int mes = sc.nextInt();
                if (mes >= 1 && mes <= 12) {
                    isValid = false;
                    System.out.println(s.getMes(mes));
                }else{
                    System.out.println("Solo es posible ingresar un valor del 1 al 12");
                }
            }else{
                sc.nextLine();
                System.out.println("Ingresa un numero valido!");
            }
        }
    }
}
