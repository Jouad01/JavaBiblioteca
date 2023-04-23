package edu.daw.ApartadoA;

import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
    private String nombre;
    private String apellidos;
    private String NIF;
    private String password;

//    Constructor vacio
    public Persona() {
    }

//    Constructor con parametros
    public Persona(String nombre, String apellidos, String NIF, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.password = password;
    }

//    Constructor copia
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.apellidos = persona.apellidos;
        this.NIF = persona.NIF;
        this.password = persona.password;
    }

//    getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 8) {
            System.out.println("La contraseña debe tener al menos 8 caracteres");
        } else {
            this.password = password;
        }
    }

//    toString

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", NIF='" + NIF + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

//    metodos para agregar, ver y eliminar bibliotecarios

    public static void agregarBibliotecario(ArrayList <Persona> listaBibliotecarios) {
        System.out.println("--- Agregar bibliotecario ---");
        Scanner input = new Scanner(System.in);

        Persona persona = new Persona();

        System.out.print("Nombre: ");
        String nombre = input.nextLine();
        persona.setNombre(nombre);

        System.out.print("Apellidos: ");
        String apellidos = input.nextLine();
        persona.setApellidos(apellidos);

        System.out.print("NIF: ");
        String NIF = input.nextLine();
        persona.setNIF(NIF);

        String password = " ";
        while (password.length() < 8) {
            System.out.print("Contraseña: ");
            password = input.nextLine();
            persona.setPassword(password);
        }
        persona = new Persona(nombre, apellidos, NIF, password);
        listaBibliotecarios.add(persona);
    }

    public static void eliminarBibliotecario(ArrayList <Persona> listaBibliotecarios) {
            System.out.println("--- Eliminar bibliotecario ---");
            Scanner input = new Scanner(System.in);

            System.out.println("NIF: ");
            String NIF = input.nextLine();

            for (int i = 0; i < listaBibliotecarios.size(); i++) {
                if (listaBibliotecarios.get(i).getNIF().equals(NIF)) {
                    listaBibliotecarios.remove(i);
                }
            }
    }

    public static void verBibliotecarios(ArrayList <Persona> listaBibliotecarios) {
        System.out.println("--- Ver bibliotecarios ---");
        for (Persona persona : listaBibliotecarios) {
            System.out.println(persona.toString());
        }
    }
}