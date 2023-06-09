package edu.daw.ApartadoB;

import java.util.ArrayList;

public abstract class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    //    constructor vacio
    public Persona() {
    }

    //    constructor con parametros
    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }

    //    constructor copia
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.apellido1 = persona.apellido1;
        this.apellido2 = persona.apellido2;
        this.edad = persona.edad;
    }

//    getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

//    toString

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", edad=" + edad +
                '}';
    }

//    metodo que solicita datos declarado

    public void solicitarDatosPersona(ArrayList <Persona> listaPersonas, ArrayList <Bibliotecario> listaBibliotecarios, ArrayList <Usuario> listaUsuarios) {

    }

//    declara metodo abstracto para las clases hijas
    public abstract void cambiarPassword();

}
