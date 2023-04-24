package edu.daw.ApartadoB;

import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotecario extends Persona {

    private String puestoTrabajo;
    private String NIF;
    private String password;
//    duda
    private ArrayList<Persona> listaPersonas = new ArrayList<>();

//    constructor vacio
    public Bibliotecario() {
    }

//    constructor con parametros incluido superclase
    public Bibliotecario(String nombre, String apellido1, String apellido2, int edad, String puestoTrabajo, String NIF, String password) {
        super(nombre, apellido1, apellido2, edad);
        this.puestoTrabajo = puestoTrabajo;
        this.NIF = NIF;
        this.password = password;
    }

//    constructor copia
    public Bibliotecario(Bibliotecario bibliotecario) {
        super(bibliotecario);
        this.puestoTrabajo = bibliotecario.puestoTrabajo;
        this.NIF = bibliotecario.NIF;
        this.password = bibliotecario.password;
    }

//    getters y setters
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
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
        this.password = password;
    }

//    toString

    @Override
    public String toString() {
        return "Bibliotecario = " +
                "nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                "puestoTrabajo='" + puestoTrabajo + '\'' +
                ", NIF='" + NIF + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

//    sobreescribe metodo solicitarDatos de la clase Persona

    @Override
    public void solicitarDatosPersona(ArrayList <Persona> listaPersonas, ArrayList <Bibliotecario> listaBibliotecarios, ArrayList <Usuario> listaUsuarios) {
        Bibliotecario bibliotecario = new Bibliotecario();
        System.out.println("Introduzca su nombre: ");
        Scanner nombre2 = new Scanner(System.in);
        String nombre = nombre2.nextLine();
        bibliotecario.setNombre(nombre);

        System.out.println("Introduzca su primer apellido:");
        Scanner apellido1 = new Scanner(System.in);
        String primerApellido = apellido1.nextLine();
        bibliotecario.setApellido1(primerApellido);

        System.out.println("Introduzca su segundo apellido:");
        Scanner apellido2 = new Scanner(System.in);
        String segundoApellido = apellido2.nextLine();
        bibliotecario.setApellido2(segundoApellido);

        System.out.println("Introduzca su edad:");
        Scanner edad1 = new Scanner(System.in);
        Integer edad = Integer.parseInt(edad1.nextLine());
        bibliotecario.setEdad(edad);

        System.out.println("Introduzca su puesto de trabajo:");
        Scanner pusT = new Scanner(System.in);
        String puestoTrabajo = pusT.nextLine();
        bibliotecario.setPuestoTrabajo(puestoTrabajo);


        String NIF = " ";
        while (NIF.length() < 9) {
            System.out.println("Introduce el NIF del usuario");
            Scanner NIF1 = new Scanner(System.in);
            NIF = NIF1.nextLine();
            if (NIF.length() < 9) {
                System.out.println("El NIF debe tener 9 caracteres");
            }
        }

        String password = " ";
        while (password.length() < 8) {
            System.out.println("Introduce la contraseña del usuario");
            Scanner password1 = new Scanner(System.in);
            password = password1.nextLine();
            if (password.length() < 8) {
                System.out.println("La contraseña debe tener 8 caracteres");
            }
        }

        listaBibliotecarios.add(bibliotecario);
        listaPersonas.add(bibliotecario);
        System.out.println("El usuario " + bibliotecario.getNombre() + " se ha registrado correctamente.");
    }
}
