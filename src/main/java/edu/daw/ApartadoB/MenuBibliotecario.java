package edu.daw.ApartadoB;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBibliotecario {
    public static void main(String[] args) {
        ArrayList <Persona> listaPersonas = new ArrayList<>();
        ArrayList <Bibliotecario> listaBibliotecarios = new ArrayList<>();
        ArrayList <Usuario> listaUsuarios = new ArrayList<>();
//        menu que se encarga de dar de alta más bibliotecarios y usuarios

        Scanner input = new Scanner(System.in);
        System.out.println("------Menu Bibliotecario-------\n");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Dar de alta bibliotecario");
            System.out.println("2. Dar de alta usuario");
            System.out.println("3. Mostrar lista de personas");
            System.out.println("4. Salir");
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
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}
