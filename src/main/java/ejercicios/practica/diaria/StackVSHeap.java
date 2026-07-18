package ejercicios.practica.diaria;

public class StackVSHeap {
    public static void main(String[] args) {
        String a = "gol";
        String b = a;
        b = "hola";
        if(a == b) {
            System.out.println("El valor es el mismo de a y b es lo mismo");
        }else{
            System.out.println("El valor no es el mismo porque a '" + a + "' y b es '" + b + "'");
            System.out.println("Lo que hace es que son referencias de memoria diferente");

        }

        System.out.println("Sin embargo....");

        int[] arrayA = {1, 2, 3};
        int[] arrayB = arrayA; //Aqui hace referencia a la direccion de arrayA
        arrayB[0] = 20;
        if(arrayA == arrayB) {
            System.out.println("El valor es el mismo de a y b es lo mismo");
            System.out.println("el valor del array a es " + arrayA[0] + " valor array b " + arrayB[0]);
            System.out.println("esto sucede porque es solo una referencia por eso cambia en las dos");
        }


    }
}
