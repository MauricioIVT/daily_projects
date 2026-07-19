package ejercicios.practica.primera.nivel4;
/*
Ejercicio 4.1 — Paso por valor vs referencia
Escribe dos métodos: uno que intente "duplicar" un int pasado como parámetro,
y otro que reciba una List<Integer> y duplique cada valor dentro de ella.

Herramientas: métodos, parámetros, paso por valor
Restricción: antes de correr el código, escribe en un comentario qué esperas que imprima cada caso.
 Luego corre y compara contra tu predicción — si te equivocaste, anota por qué.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValorVSReferencia {
    public int duplicar(int num){
        num = num + 1;
        return num;
    }

    public List<Integer> duplicarList(List<Integer> list){
        return list.stream().collect(Collectors.toList());
        //también puede utilizar return new ArrayList<>(list)
    }

    public static void main(String[] args) {
        ValorVSReferencia valor = new ValorVSReferencia();
        int num = 5;

        System.out.println(num);
        System.out.println(valor.duplicar(num));

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        List<Integer> resultado = valor.duplicarList(list);
        resultado.remove(1);
        System.out.println(list);
        System.out.println(resultado);


    }

}
