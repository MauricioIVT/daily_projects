    /*
    Ejercicio 4.2 — Recursión: suma de dígitos
    Escribe un metodo recursivo que sume los dígitos de un número (ej. 1234 → 1+2+3+4 = 10).

    Herramientas: recursión, operador módulo, división entera
    Restricción: identifica tú mismo cuál es el caso base — no te lo voy a decir.
    Si tu programa se cuelga o da StackOverflowError, ese es tu indicio de que el caso base está mal.
     */
    package ejercicios.practica.primera.nivel4;

public class SumaDigita {
    public int recursivo(int numero) {
        if (numero % 10 == numero) {
            return numero;
        }

        int numeroFinal = Math.abs(numero % 10) ;
        int numeroRecortado = Math.abs(numero / 10) ;

        return numeroFinal + recursivo(numeroRecortado);
    }

    public static void main(String[] args) {
        SumaDigita obj = new SumaDigita();
        System.out.println(obj.recursivo(-123));
    }
}
