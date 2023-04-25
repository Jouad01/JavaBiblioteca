package edu.daw.ApartadoB;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBibliotecario {
    public static void main(String[] args) {
        ArrayList <Persona> listaPersonas = new ArrayList<>();
        ArrayList <Bibliotecario> listaBibliotecarios = new ArrayList<>();
        ArrayList <Usuario> listaUsuarios = new ArrayList<>();
        ArrayList <Libro> listaLibros = new ArrayList<>();
        ArrayList <Reserva> listaReservas = new ArrayList<>();

//        menu encargado de gestionar las opciones del bibliotecario, usuario y libros.

        Scanner input = new Scanner(System.in);
        System.out.println("------Menu Bibliotecario-------\n");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Añade a un bibliotecario");
            System.out.println("2. Añade a un usuario");
            System.out.println("3. Mostrar lista de personas (todos)");
            System.out.println("4. Añadir un libro");
            System.out.println("5. Mostrar lista de libros");
            System.out.println("6. Iniciar sesion como bibliotecario");
            System.out.println("7. Cambiar contraseña");
            System.out.println("8. Salir\n");
            System.out.println("Introduce una opcion: ");
            int opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    Bibliotecario bibliotecario = new Bibliotecario();
                    bibliotecario.solicitarDatosPersona(listaPersonas, listaBibliotecarios, listaUsuarios);
                    break;
                case 2:
                    Usuario usuario = new Usuario();
                    usuario.solicitarDatosPersona(listaPersonas, listaBibliotecarios, listaUsuarios);
                    break;
                case 3:
                    if (listaPersonas.size() == 0) {
                        System.out.println("No hay personas\n");
                    } else {
                        System.out.println("Lista de personas: \n");
                        for (Persona persona : listaPersonas) {
                            System.out.println(persona);
                        }
                    }
                    break;
                case 4:
                    Libro libro = new Libro();
                    Libro.agregarLibro(listaLibros);
                    break;
                case 5:
                    Libro.verLibros(listaLibros);
                    break;
                case 6:
                    Bibliotecario.loginBibliotecario(listaBibliotecarios, listaUsuarios, listaLibros, listaReservas);
                    break;
                case 7:
                    System.out.println("Seleccione el tipo de persona para cambiar la contraseña:");
                    System.out.println("1. Bibliotecario");
                    System.out.println("2. Usuario");
                    int opcion2 = input.nextInt();
                    switch (opcion2) {
                        case 1:
                            Bibliotecario bibliotecario1 = new Bibliotecario();
                            bibliotecario1.cambiarPassword();
                            break;
                        case 2:
                            Usuario usuario1 = new Usuario();
                            usuario1.cambiarPassword();
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                    break;
                case 8:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

}

