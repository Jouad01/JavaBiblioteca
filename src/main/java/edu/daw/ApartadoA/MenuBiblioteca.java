package edu.daw.ApartadoA;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBiblioteca {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("------Menu Biblioteca-------\n");

        ArrayList<Libro> listaLibros = new ArrayList<>();
        ArrayList<Persona> listaBibliotecarios = new ArrayList<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Libro> listaReservas = new ArrayList<>();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Gestionar reservas");
            System.out.println("2. Gestionar personal");
            System.out.println("3. Gestionar usuarios");
            System.out.println("4. Salir\n");

            System.out.print("Introduce una opcion: ");
//            primer menu encargado de gestionar libros
            int opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    boolean isRunning1 = true;
                    while (isRunning1) {
                        System.out.println("\n1. Añadir libro");
                        System.out.println("2. Eliminar libro por ISBN");
                        System.out.println("3. Buscar libro por ISBN");
                        System.out.println("4. Buscar libro por titulo");
                        System.out.println("5. Mostrar todos los libros");
                        System.out.println("6. Volver al menu principal\n");

                        System.out.print("Introduce una opcion: ");
                        opcion = input.nextInt();
                        switch (opcion) {
                            case 1:
                                Libro.agregarLibro(listaLibros);
                                System.out.println("Libro añadido\n");
                                break;
                            case 2:
                                Libro.eliminarLibro(listaLibros);
                                System.out.println("Libro eliminado\n");
                                break;
                            case 3:
                                Libro.buscarLibroISBN(listaLibros);
                                break;
                            case 4:
                                Libro.buscarLibroTitulo(listaLibros);
                                break;
                            case 5:
                                Libro.verLibros(listaLibros);
                                break;
                            case 6:
                                isRunning1 = false;
                                break;
                            default:
                                System.out.println("Opcion no valida\n");
                                break;
                        }
                    }
                    break;
//                    segundo menu encargado de gestionar bibliotecarios
                case 2:
                    boolean isRunning2 = true;
                    while (isRunning2) {
                        System.out.println("\n1. Añadir bibliotecario");
                        System.out.println("2. Eliminar bibliotecario por NIF");
                        System.out.println("3. Mostar todos los bibliotecarios");
                        System.out.println("4. Volver al menu principal\n");

                        System.out.print("Introduce una opcion: ");
                        opcion = input.nextInt();
                        switch (opcion) {
                            case 1:
                                Persona.agregarBibliotecario(listaBibliotecarios);
                                break;
                            case 2:
                                Persona.eliminarBibliotecario(listaBibliotecarios);
                                break;
                            case 3:
                                Persona.verBibliotecarios(listaBibliotecarios);
                                break;
                            case 4:
                                isRunning2 = false;
                                break;
                            default:
                                System.out.println("Opcion no valida\n");
                                break;
                        }
                    }
                    break;
//                    tercer menu encargado de gestionar usuarios
                case 3:
                    boolean isRunning3 = true;
                    while (isRunning3) {
                        System.out.println("\n1. Añadir usuario");
                        System.out.println("2. Eliminar usuario por NIF");
                        System.out.println("3. Mostar todos los usuarios");
                        System.out.println("4. Reservar libro");
                        System.out.println("5. Volver al menu principal\n");

                        System.out.print("Introduce una opcion: ");
                        opcion = input.nextInt();
                        Usuario usuario = new Usuario();

                        switch (opcion) {
                            case 1:
                                usuario.agregarUsuario(listaUsuarios);
                                break;
                            case 2:
                                usuario.eliminarUsuario(listaUsuarios);
                                System.out.println("Usuario eliminado\n");
                                break;
                            case 3:
                                usuario.verUsuarios(listaUsuarios);
                                break;
                            case 4:
                                usuario.reservarLibro(listaUsuarios, listaLibros, listaReservas);
                                break;
                            case 5:
                                isRunning3 = false;
                                break;
                            default:
                                System.out.println("Opcion no valida\n");
                                break;
                        }
                    }
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("No hay presupuesto para un programa más elaborado. Vuelve a intentarlo.\n");
                    break;
            }
        }
    }
}

