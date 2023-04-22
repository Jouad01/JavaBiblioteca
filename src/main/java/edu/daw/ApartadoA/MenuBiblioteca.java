package edu.daw;

import java.util.Scanner;

public class MenuBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n*** MENÚ PRINCIPAL ***\n");
            System.out.println("1. Añadir libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Buscar libro por título");
            System.out.println("5. Mostrar libros");
            System.out.println("6. Mostrar libros disponibles");
            System.out.println("0. Salir");

            System.out.print("\nElija una opción: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n*** AÑADIR LIBRO ***\n");
                    Libro.añadirLibro(biblioteca.getListaLibros());
                    break;
                case 2:
                    System.out.println("\n*** ELIMINAR LIBRO ***\n");
                    Libro.eliminarLibro(biblioteca.getListaLibros());
                    break;
                case 3:
                    System.out.println("\n*** BUSCAR LIBRO POR ISBN ***\n");
                    Libro.buscarLibroISBN(biblioteca.getListaLibros());
                    break;
                case 4:
                    System.out.println("\n*** BUSCAR LIBRO POR TÍTULO ***\n");
                    Libro.buscarLibroTitulo(biblioteca.getListaLibros());
                    break;
                case 5:
                    System.out.println("\n*** MOSTRAR LIBROS ***\n");
                    biblioteca.mostrarLibros();
                    break;
                case 6:
                    System.out.println("\n*** MOSTRAR LIBROS DISPONIBLES ***\n");
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 0:
                    System.out.println("\nGracias por utilizar nuestro sistema de gestión de bibliotecas.");
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    public static void gestionarPersonal(Biblioteca biblioteca) {
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n*** GESTIONAR PERSONAL ***\n");
            System.out.println("1. Añadir persona");
            System.out.println("2. Eliminar persona");
            System.out.println("0. Salir");

            System.out.print("\nElija una opción: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n*** AÑADIR PERSONA ***\n");
                    Persona persona = new Persona("Juan", "Pérez", "12345678A", "123456789");
                    Persona.agregarPersona(persona, biblioteca.getPersonal());
                    break;
                case 2:
                    System.out.println("\n*** ELIMINAR PERSONA ***\n");
                    String nif = "12345678A";
                    Persona persona2 = null;
                    for (Persona p : biblioteca.getPersonal()) {
                        if (p.getNIF().equals(nif)) {
                            persona2 = p;
                            break;
                        }
                    }
                    if (persona2 != null) {
                        Persona.eliminarPersona(persona2, biblioteca.getPersonal());
                    } else {
                        System.out.println("No se encontró a la persona con ese NIF " + nif);
                    }
                    break;
                case 0:
                    System.out.println("\nVolviendo al menú principal...");
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }
}
