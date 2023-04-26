package edu.daw.ApartadoB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Usuario extends Persona {

    private static int telefono;
    private String direccion;
    private int codigoPostal;
    private static String email;
    protected ArrayList <Reserva> listaReservas;

//    constructor vacio
    public Usuario() {
    }

//    constructor con parametros incluido superclase
    public Usuario(String nombre, String apellido1, String apellido2, int edad, int telefono, String direccion, int codigoPostal, String email, ArrayList <Reserva> listaReservas) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.listaReservas = listaReservas;
    }


//    constructor copia
    public Usuario(Usuario usuario) {
        super(usuario);
        this.telefono = usuario.telefono;
        this.direccion = usuario.direccion;
        this.codigoPostal = usuario.codigoPostal;
        this.email = usuario.email;
        this.listaReservas = usuario.listaReservas;
    }

    public Usuario(String telefono, String email) {
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

    public ArrayList <Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList <Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    //    toString con datos de superclase
    @Override
    public String toString() {
        return "Usuario = " +
                "telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", email='" + email + '\'' +
                ", reservas=" + listaReservas +
                '}';
    }

    //   sobreescribe metodo solicitarDatos de la clase Persona
//    este metodo utiliza el metodo de la superclase para solicitar los datos de la persona
//    y ademas solicita los datos propios de la clase Usuario junto al metodo de la clase Reserva
    public void solicitarDatosPersona(ArrayList <Persona> listaPersonas, ArrayList <Bibliotecario> listaBibliotecarios, ArrayList <Usuario> listaUsuarios) {
        ArrayList<Reserva> listaReservas = new ArrayList<>();
        Usuario usuario = new Usuario();
        ArrayList<Persona> usuarioList = new ArrayList<>();
        System.out.println("Introduce el nombre: ");
        Scanner nombre1 = new Scanner(System.in);
        String nombre = nombre1.nextLine();
        usuario.setNombre(nombre);

        System.out.println("Introduzca su primer apellido:");
        Scanner apellido1 = new Scanner(System.in);
        String primerApellido = apellido1.nextLine();
        usuario.setApellido1(primerApellido);

        System.out.println("Introduzca su segundo apellido: ");
        Scanner apellido2 = new Scanner(System.in);
        String segundoApellido = apellido2.nextLine();
        usuario.setApellido2(segundoApellido);

        System.out.println("Introduzca su edad: ");
        Scanner edad1 = new Scanner(System.in);
        Integer edad = Integer.parseInt(edad1.nextLine());
        usuario.setEdad(edad);

        System.out.println("Introduzca su teléfono: ");
        Scanner tel = new Scanner(System.in);
        Integer telefono = Integer.parseInt(tel.nextLine());
        usuario.setTelefono(telefono);

        System.out.println("Introduzca su dirección: ");
        Scanner direc = new Scanner(System.in);
        String direccion = direc.nextLine();
        usuario.setDireccion(direccion);

        System.out.println("Introduzca su código postal: ");
        Scanner cp = new Scanner(System.in);
        Integer codigoPostal = Integer.parseInt(cp.nextLine());
        usuario.setCodigoPostal(codigoPostal);

        System.out.println("Introduzca su correo electrónico: ");
        Scanner email = new Scanner(System.in);
        String correo = email.nextLine();
        usuario.setEmail(correo);
        usuario.setListaReservas(listaReservas);


        usuarioList.add(usuario);
        listaUsuarios.add(usuario);
        listaPersonas.add(usuario);
        System.out.println("El usuario " + usuario.getNombre() + " ha sido añadido correctamente. ");
    }

//    metodo para que el usuario pueda cambiar (añadir) contraseña
    public void cambiarPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu numero de teléfono: ");
        int oldPhone = Integer.parseInt(input.nextLine());
        System.out.println("Introduce tu correo electrónico: ");
        String oldEmail = input.nextLine();
        if (oldPhone == telefono && oldEmail.equals(email)) {
            System.out.println("Bien. Ahora introduce la nueva contraseña: ");
            String newPassword = input.nextLine();
            System.out.println("Introduce de nuevo la nueva contraseña: ");
            String newPassword2 = input.nextLine();
            if (newPassword.equals(newPassword2)) {
                System.out.println("Contraseña cambiada correctamente.");
            } else {
                System.out.println("Las contraseñas no coinciden.");
            }
        } else {
            System.out.println("Los datos introducidos no son correctos.");
        }
    }

//    metodo que añade reserva al usuario
    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }

//    metodo que elimina reserva del usuario
    public void eliminarReserva(Reserva reserva) {
        listaReservas.remove(reserva);
    }
}
