package edu.daw.ApartadoB;

import java.util.Arrays;

public class Usuario extends Persona {

    private int telefono;
    private String direccion;
    private int codigoPostal;
    private String email;
    private Reserva[] reservas;

//    constructor vacio
    public Usuario() {
    }

//    constructor con parametros incluido superclase
    public Usuario(String nombre, String apellido1, String apellido2, int edad, int telefono, String direccion, int codigoPostal, String email, Reserva[] reservas) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.reservas = reservas;
    }

//    constructor copia
    public Usuario(Usuario usuario) {
        super(usuario);
        this.telefono = usuario.telefono;
        this.direccion = usuario.direccion;
        this.codigoPostal = usuario.codigoPostal;
        this.email = usuario.email;
        this.reservas = usuario.reservas;
    }

//    getters y setters


    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }

//    toString con datos de superclase

    @Override
    public String toString() {
        return "Usuario{" +
                "telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", email='" + email + '\'' +
                ", reservas=" + Arrays.toString(reservas) +
                "} " + super.toString();
    }
}
