package ejercicios.practica.primera.proyecto;

import java.util.*;
import java.util.stream.Collectors;

public class Libreria {
    List<Libro> biblioteca = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public record Libro(String title, String autor, int year, boolean availability) {}

    public void setBiblioteca(Libro libro) {
        this.biblioteca.add(libro);
    }

    public void listaLibros() {
        biblioteca.forEach(libro -> System.out.println(this.infoLibro(libro)));
    }

    public String infoLibro(Libro libro) {
        return "---------  Libro  ----------- " +
                "\nTitulo: " + libro.title() +
                "\nAutor: " + libro.autor() +
                "\nYear: " + libro.year() +
                "\nDisponible: " + (libro.availability() ? "Si" : "No") +
                "\n-----------------------------\n";
    }

    public void buscarPorAutor(){
        boolean salir = true;
        while (salir) {
            listaDeAutores();
            System.out.println("Introduce el Autor: ");
            String autor = sc.nextLine().toLowerCase();
            if (autor.isEmpty() || biblioteca.stream()
                    .noneMatch(libro -> libro.autor().toLowerCase(Locale.ROOT).equals(autor))){
                System.out.println("El Autor --- " + autor + " --- no existe");
            }else{
                biblioteca.stream()
                        .filter(libro -> libro.autor().toLowerCase(Locale.ROOT).equals(autor))
                        .forEach(libro -> System.out.println(this.infoLibro(libro)));
                salir = false;
            }
        }
    }

    public void listaDeAutores(){
        List<String> autores= biblioteca.stream().map(Libro::autor).distinct().toList();

        autores.forEach(autor -> System.out.println("Autor: " + autor));
    }


    public void devPresLibros(){
        System.out.println(""" 
                \n ¿Desea tener algun prestamo del libro o devolución del mismo? 
                p - prestamo 
                d - devolución \n
                """);
        String respuesta = sc.nextLine();
        if (respuesta.toLowerCase(Locale.ROOT).equals("p")){
            System.out.println("¿Libro a prestar?");
            listaLibros();
            String prestamo = sc.nextLine().toLowerCase();
            libroPrestado(prestamo);

        } else if (respuesta.toLowerCase(Locale.ROOT).equals("d")) {
            System.out.println("¿Libro a devolver?");
            listaLibros();
            String prestamo = sc.nextLine().toLowerCase();
            libroDevuelto(prestamo);
        }else {
            System.out.println("La respuesta no fue adecuado solo existe p y d");
        }
    }

    public void libroDevuelto(String title){
        if(biblioteca.stream().noneMatch(libro -> libro.title().toLowerCase(Locale.ROOT).equals(title))){
            System.out.println("El libro " + title + " no existe en la biblioteca. no se puede devolver algo que no existe");
        } else if(biblioteca.stream().anyMatch(libro -> libro.title().toLowerCase(Locale.ROOT).equals(title) && libro.availability())) {
            System.out.println("El libro " + title + " ya esta en la biblioteca. no se puede devolver algo que ya esta en la biblioteca");
        }else{
            System.out.println("El libro " + title + " ya lo puedes devolver");
            System.out.println("El libro ya se encuentra en la biblioteca, gracias.");
            biblioteca.stream().filter(libro -> libro.title().toLowerCase(Locale.ROOT).equals(title))
                    .findFirst()
                    .ifPresent(libro -> biblioteca.add(new Libro(libro.title(), libro.autor(), libro.year(), true)));
            biblioteca.removeIf(libro -> libro.title().equals(title) && !libro.availability());
        }
    }

    public void libroPrestado(String title){
        if(biblioteca.stream().noneMatch(libro -> libro.title().toLowerCase(Locale.ROOT).equals(title))){
            System.out.println("El libro " + title + " no existe en la biblioteca.");
        } else if(biblioteca.stream().anyMatch(libro -> libro.title().toLowerCase(Locale.ROOT).equals(title) && !libro.availability())) {
            System.out.println("El libro " + title + " esta prestado, vuelve mas tarde.");
        }else{
            System.out.println("El libro " + title + " se encuentra en la biblioteca.");
            System.out.println("El libro ya se encuentra en tus manos, gracias por preferirnos!");
            biblioteca.stream().filter(libro -> libro.title().toLowerCase(Locale.ROOT).equals(title))
                    .findFirst()
                    .ifPresent(libro -> biblioteca.add(new Libro(libro.title(), libro.autor(), libro.year(), false)));
            biblioteca.removeIf(libro -> libro.title().toLowerCase(Locale.ROOT).equals(title) && libro.availability());
        }
    }

    public void mostrarEstadisticas(){
        List<Integer> totalEstadisticas = Arrays.asList(0,0);
        List<Boolean> listaLibros = biblioteca.stream().map(Libro::availability).collect(Collectors.toList());
        totalEstadisticas = estadisticasRecursividad(totalEstadisticas, listaLibros);

        System.out.println("Estadisticas: \n" +
                "Total de libros prestados: " + totalEstadisticas.getFirst() + " \n " +
                "Total de libros disponibles: " + totalEstadisticas.getLast() + "\n");
    }

    public List<Integer> estadisticasRecursividad(List<Integer> listaEstadisticas, List<Boolean> listaLibros){
        if(listaLibros.isEmpty()){
            return listaEstadisticas;
        }

        if(listaLibros.getFirst()) {
            listaEstadisticas.set(0, listaEstadisticas.getFirst() + 1);
        }else{
            listaEstadisticas.set(1, listaEstadisticas.getLast() + 1);
        }

        return estadisticasRecursividad(listaEstadisticas, listaLibros.subList(1, listaLibros.size()));
    }

    public void menu(){
        boolean menu = true;
        while(menu) {
            System.out.println("""
                Hola bienveido a la libreria.!
                ------------------------------
                a - Listar libros
                b - Buscar por Autor
                c - Prestar o devolución de Libro
                d - Mostrar estadisticas
                e - Salir
                """);

            String respuesta = sc.nextLine();
            switch (respuesta.toLowerCase()) {
                case "a" -> this.listaLibros();
                case "b" -> this.buscarPorAutor();
                case "c" -> this.devPresLibros();
                case "d" -> this.mostrarEstadisticas();
                case "e" -> {
                    System.out.println("Vuelva pronto.!");
                    menu = false;
                }
                default ->
                        System.out.println("Error al buscar tu selección solo es de a - d y tu elegiste " + respuesta);
            }
        }
    }

    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Libro libro = new Libro("Clean code", "Robert Cecil Martin", 2008, true);
        Libro libro2 = new Libro("El psicoanalista", "John Katzenbach", 2002, true);
        Libro libro3 = new Libro("La historia del loco", "John Katzenbach", 2004, false);
        Libro libro4 = new Libro("Inteligencia emocional", "Daniel Goleman", 1995, true);
        Libro libro5 = new Libro("Overlord", "Kugane Maruyama", 2012, true);

        libreria.setBiblioteca(libro);
        libreria.setBiblioteca(libro2);
        libreria.setBiblioteca(libro3);
        libreria.setBiblioteca(libro4);
        libreria.setBiblioteca(libro5);

        libreria.menu();
    }
}