package edu.daw.ApartadoA;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String NIF;
    private String password;
    public ArrayList <Libro> listaReservas;
    public ArrayList <Usuario> listaUsuarios;

    //    Constructor vacio
    public Usuario() {
    }

    //    Constructor con parametros
    public Usuario(String nombre, String apellidos, String NIF, String password, ArrayList<Libro> listaReservas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.password = password;
        this.listaReservas = listaReservas;
    }

    //    Constructor copia
    public Usuario(Usuario usuario) {
        this.nombre = usuario.nombre;
        this.apellidos = usuario.apellidos;
        this.NIF = usuario.NIF;
        this.password = usuario.password;
        this.listaReservas = usuario.listaReservas;
    }

    //  getters y setters
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

//    hazme el nif con un formato adecuado
    public void setNIF(String NIF) {
        if(!NIF.matches("[0-9]{8}[A-Z]"))
            throw new IllegalArgumentException("El NIF debe tener 8 numeros y una letra mayuscula");
        this.NIF = NIF;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 8)
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        this.password = password;
    }

    public ArrayList <Libro> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList <Libro> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList <Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList <Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

//    toString
        @Override
        public String toString() {
            return "Usuario{" +
                    "nombre='" + nombre + '\'' +
                    ", apellidos='" + apellidos + '\'' +
                    ", NIF='" + NIF + '\'' +
                    ", password='" + password + '\'' +
                    ", listaReservas=" + listaReservas +
                    ", listaUsuarios=" + listaUsuarios +
                    '}';
        }
//    metodos agregar, ver y eliminar usuarios
    public void agregarUsuario(ArrayList<Usuario> listaUsuarios) {
        System.out.println("---Añadir usuario---");
        Scanner input = new Scanner(System.in);

        Usuario usuario = new Usuario();

        System.out.println("Introduce el nombre del usuario");
        String nombre = input.nextLine();
        usuario.setNombre(nombre);

        System.out.println("Introduce los apellidos del usuario");
        String apellidos = input.nextLine();
        usuario.setApellidos(apellidos);

        System.out.println("Introduce el NIF del usuario");
        String NIF = input.nextLine();
        usuario.setNIF(NIF);

        String password = " ";
        while (password.length() < 8) {
            System.out.println("Introduce la contraseña del usuario");
            password = input.nextLine();
            usuario.setPassword(password);
        }

        usuario = new Usuario(nombre, apellidos, NIF, password, new ArrayList<>());
    }

    public void eliminarUsuario(ArrayList<Usuario> listaUsuarios) {
        System.out.println("---Eliminar usuario---");
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el NIF del usuario que quieres eliminar");
        String NIF = input.nextLine();

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getNIF().equals(NIF)) {
                listaUsuarios.remove(i);
            }
        }
    }

    public void verUsuarios(ArrayList<Usuario> listaUsuarios) {
        System.out.println("---Ver usuarios---");
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.toString());
        }
    }

//    metodos para comprobar requisitos de reserva (booleanos)

    public static boolean comprobarNumReservas(ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros, String NIF) {
        for (Usuario listaUsuario : listaUsuarios) {
            if (listaUsuario.getNIF().equals(NIF)) {
                if (listaUsuario.getListaReservas().size() >= 5) {
                    return true;
                }
            }
        }
        System.out.println("No puedes reservar mas de 5 libros");
        return false;
    }

    public static boolean comprobarReservas(ArrayList<Usuario> listaUsuarios, Libro libro) {
        for (Usuario listaUsuario : listaUsuarios) {
            if (listaUsuario.getListaReservas().contains(libro)) {
                System.out.println("El libro ya esta reservado");
                return true;
            }
        }
        return false;
    }

    public static boolean comprobarUsuario(ArrayList<Usuario> listaUsuarios, String NIF) {
        for (Usuario listaUsuario : listaUsuarios) {
            if (listaUsuario.getNIF().equals(NIF)) {
                return true;
            }
        }
        System.out.println("El usuario no existe");
        return false;
    }

    public static boolean comprobarLibro(ArrayList<Libro> listaLibros, String getISBN) {
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(getISBN)) {
                return true;
            }
        }
        System.out.println("El libro no existe");
        return false;
    }

//    metodo para reservar un libro pregunta al usuario y el isbn del libro que quiere reservar

    public void reservarLibro(ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros, ArrayList<Libro> listaReservas) {
        System.out.println("---Reservar libro---");
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el NIF del usuario");
        String NIF = input.nextLine();

        if (comprobarUsuario(listaUsuarios, NIF)) {
            System.out.println("Introduce el ISBN del libro");
            String ISBN = input.nextLine();

            if (comprobarLibro(listaLibros, ISBN)) {
                for (Libro libro : listaLibros) {
                    if (libro.getISBN().equals(ISBN)) {
                        if (!comprobarReservas(listaUsuarios, libro)) {
                            if (!comprobarNumReservas(listaUsuarios, listaLibros, NIF)) {
                                for (Usuario listaUsuario : listaUsuarios) {
                                    if (listaUsuario.getNIF().equals(NIF)) {
                                        listaUsuario.getListaReservas().add(libro);
                                        System.out.println("Libro reservado");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

//    metodo para devolver un libro pregunta al usuario y el isbn del libro que quiere devolver

    public void devolverLibro(ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros, ArrayList<Libro> listaReserva) {
        System.out.println("---Devolver libro---");
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el NIF del usuario");
        String NIF = input.nextLine();

        if (comprobarUsuario(listaUsuarios, NIF)) {
            System.out.println("Introduce el ISBN del libro");
            String ISBN = input.nextLine();

            if (comprobarLibro(listaLibros, ISBN)) {
                for (Libro libro : listaLibros) {
                    if (libro.getISBN().equals(ISBN)) {
                        for (Usuario listaUsuario : listaUsuarios) {
                            if (listaUsuario.getNIF().equals(NIF)) {
                                listaUsuario.getListaReservas().remove(libro);
                                System.out.println("Libro devuelto");
                            }
                        }
                    }
                }
            }
        }
    }

}

