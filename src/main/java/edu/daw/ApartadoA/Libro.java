package edu.daw.ApartadoA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int numCopias;
    private int numCopiasDisponibles;
    private static int contadorLibros = 0;
    private ArrayList <Libro> listaLibros = new ArrayList <>();

    //    Constructor vacio
    public Libro() {
    }

    //    Constructor con parametros
    public Libro(String ISBN, String titulo, String autor, String editorial, int numCopias, int numCopiasDispobibles) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.numCopias = numCopias;
        this.numCopiasDisponibles = numCopiasDispobibles;
    }

    //   Constructor copia (inicializa los atributos del nuevo objeto Libro)
    public Libro(Libro libro) {
        this.ISBN = libro.ISBN;
        this.titulo = libro.titulo;
        this.autor = libro.autor;
        this.editorial = libro.editorial;
        this.numCopias = libro.numCopias;
        this.numCopiasDisponibles = libro.numCopiasDisponibles;
        contadorLibros++;
    }


    //   getters y setters
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        if (numCopias > 1) {
            this.numCopias = numCopias;
        } else {
            System.out.println("El numero de copias debe ser mayor que 1");
        }
    }

    public int getNumCopiasDispobibles() {
        return numCopiasDisponibles;
    }

    public void setNumCopiasDispobibles(int numCopiasDispobibles) {
        if (numCopiasDispobibles > this.numCopias) {
            System.out.println("Error. El numero de copias disponibles es mayor que el numero de copias");
        } else {
            this.numCopiasDisponibles = numCopiasDispobibles;
        }
    }

    public static int getContadorLibros() {
        return contadorLibros;
    }

//    toString

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", numCopias=" + numCopias +
                ", numCopiasDispobibles=" + numCopiasDisponibles +
                '}';
    }

    //    Metodo control de copias con contado
    public static void controlCopias(ArrayList <Libro> listaLibros) {
        Map<String, Integer> copiasPorTitulo = new HashMap <>();
            for (Libro libro : listaLibros) {
                copiasPorTitulo.put(libro.getTitulo(), copiasPorTitulo.getOrDefault(libro.getTitulo(), 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : copiasPorTitulo.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println("El libro " + entry.getKey() + " tiene " + entry.getValue() + " copias");
                }
            }
        }

//    agregar libro. Solicitará los datos para crear un libro y añadirá dicho
//      libro a una lista de libros que recibirá como parámetro el método.

    public static void agregarLibro(ArrayList <Libro> listaLibros) {
        System.out.println("------AGREGAR LIBRO-------");

        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca el ISBN del libro: ");
        String ISBN = input.nextLine();
        System.out.println("Introduzca el titulo del libro: ");
        String titulo = input.nextLine();
        System.out.println("Introduzca el autor del libro: ");
        String autor = input.nextLine();
        System.out.println("Introduzca la editorial del libro: ");
        String editorial = input.nextLine();
        System.out.println("Introduzca el numero de copias del libro: ");
        int numCopias = input.nextInt();
        System.out.println("Introduzca el numero de copias disponibles del libro: ");
        int numCopiasDisponibles = numCopias + 1;
        while (numCopiasDisponibles > numCopias) {
            numCopiasDisponibles = input.nextInt();
            if (numCopiasDisponibles > numCopias) {
                System.out.println("Error. El numero de copias disponibles es mayor que el numero de copias");
            }
        }
        Libro libro = new Libro(ISBN, titulo, autor, editorial, numCopias, numCopiasDisponibles);
        listaLibros.add(libro);
        controlCopias(listaLibros);
    }

    public static void eliminarLibro(ArrayList<Libro> listaLibros) {
        System.out.println("------ELIMINAR LIBRO-------");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca el ISBN del libro que desea eliminar: ");
        String ISBN = input.nextLine();
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getISBN().equals(ISBN)) {
                listaLibros.remove(i);
            }
        }
    }

    public static void buscarLibroISBN(ArrayList<Libro> listaLibros) {
        System.out.println("------BUSCAR LIBRO POR ISBN-------");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca el ISBN del libro que desea buscar: ");
        String ISBN = input.nextLine();
        for (Libro listaLibro : listaLibros) {
            if (listaLibro.getISBN().equals(ISBN)) {
                System.out.println(listaLibro);
            }
        }
    }
    public static void buscarLibroTitulo(ArrayList<Libro> listaLibros) {
        System.out.println("------BUSCAR LIBRO POR TITULO-------");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca el titulo del libro que desea buscar: ");
        String titulo = input.nextLine();
        for (Libro listaLibro : listaLibros) {
            if (listaLibro.getTitulo().equals(titulo)) {
                System.out.println(listaLibro);
            }
        }
    }

    public static void verLibros(ArrayList<Libro> listaLibros) {
        System.out.println("------VER LIBROS-------");
        for (Libro listaLibro : listaLibros) {
            System.out.println(listaLibro);
        }
    }
}