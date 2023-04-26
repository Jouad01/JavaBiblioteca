package edu.daw.ApartadoA;


import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Persona> listaBibliotecarios;


//    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

//    Constructor vacio
    public Biblioteca() {
    }

//    Constructor con parametros
    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Persona> listaBibliotecarios) {
        this.nombre = nombre;
        this.listaLibros = listaLibros;
        this.listaBibliotecarios = listaBibliotecarios;
    }

//    Constructor copia
    public Biblioteca(Biblioteca biblioteca) {
        this.nombre = biblioteca.nombre;
        this.listaLibros = biblioteca.listaLibros;
        this.listaBibliotecarios = biblioteca.listaBibliotecarios;
    }

//    getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public ArrayList<Persona> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

//    setters

//    metodo que comprueba que el nombre no sea nulo y que comience en mayuscula
    public void setNombre(String nombre) {
        if (!nombre.matches("^[A-Z].*")) {
            throw new IllegalArgumentException("El nombre debe comenzar por mayúscula");
        }
        this.nombre = nombre;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void setListaBibliotecarios(ArrayList<Persona> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

//    toString
    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", listaLibros=" + listaLibros +
                ", listaBibliotecarios=" + listaBibliotecarios +
                '}';
    }

    //    mostrarLibros (metodo instanciado)
    public void mostrarLibros() {
        System.out.println("Libros de la biblioteca: ");
        for (Libro libro : listaLibros) {
            System.out.println(libro);
        }
    }

//    mostrarLibros disponibles
    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles de la biblioteca: ");
        for (Libro libro : listaLibros) {
            if (libro.getNumCopiasDispobibles() > 0) {
                System.out.println(libro);
            }
        }
    }

}
