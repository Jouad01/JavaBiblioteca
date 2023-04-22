package edu.daw.ApartadoA;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBiblioteca {
    public static void main(String[] args) {
        System.out.println("------Menu Biblioteca-------");
        ArrayList <Libro> listaLibros = new ArrayList <>();
        ArrayList <Persona> listaBibliotecarios = new ArrayList <>();
        ArrayList <Usuario> listaUsuarios = new ArrayList <>();
        ArrayList <Libro> listaReservas = new ArrayList <>();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Gestionar reservas");
            System.out.println("2. Gestionar personal");
            System.out.println("3. Gestionar usuarios");
            System.out.println("4. Salir");

            System.out.println("Introduce una opcion");
            Scanner input = new Scanner(System.in);
            int opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    isRunning = true;
                    while (isRunning) {
                        System.out.println("1. Añadir libro");
                        System.out.println("2. Eliminar libro por ISBN");
                        System.out.println("3. Buscar libro por ISBN");
                        System.out.println("4. Buscar libro por titulo");
                        System.out.println("5. Mostrar todos los libros");
                        System.out.println("6. Volver al menu principal");
                        System.out.println("Introduce una opcion");
//                        en proceso
                    }
            }
        }
    }

}