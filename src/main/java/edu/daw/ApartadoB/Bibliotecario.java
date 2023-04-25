package edu.daw.ApartadoB;

import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotecario extends Persona {

    private String puestoTrabajo;
    private String NIF;
    private static String password;
    //    duda
    private ArrayList <Persona> listaPersonas = new ArrayList <>();

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
        if (NIF.length() < 9) {
            System.out.println("El NIF debe tener 9 caracteres");
        }
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
        return "Bibliotecario = " +
                "nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                "puestoTrabajo='" + puestoTrabajo + '\'' +
                ", NIF='" + NIF + '\'' +
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

        System.out.println("Introduzca su NIF: ");
        Scanner NIF = new Scanner(System.in);
        String NIF1 = NIF.nextLine();
        bibliotecario.setNIF(NIF1);

        System.out.println("Introduzca su contraseña: ");
        Scanner password = new Scanner(System.in);
        String password1 = password.nextLine();
        bibliotecario.setPassword(password1);

        for (Bibliotecario bibliotecario1 : listaBibliotecarios) {
            if (bibliotecario1.getNIF().equals(NIF1)) {
                System.out.println("El NIF introducido ya existe");
                return;
            }
        }

        listaBibliotecarios.add(bibliotecario);
        listaPersonas.add(bibliotecario);
        System.out.println("El bibliotecario " + bibliotecario.getNombre() + " se ha registrado correctamente.");
    }

    //    metodo para hacer bibliotecario haga login. Se ha cambiado a uno statico para el menu
    public static Object loginBibliotecario(ArrayList <Bibliotecario> listaBibliotecarios, ArrayList <Usuario> listaUsuarios, ArrayList <Libro> listaLibros, ArrayList <Reserva> listaReservas) {
        System.out.println("----INICIO DE SESION----\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca su usuario: ");
        String usuario = input.nextLine();
        System.out.println("Introduzca su contraseña: ");
        String contrasena = input.nextLine();
        int comprobacion = 1;
        for (int i = 0; i < listaBibliotecarios.size(); i++) {
            if (listaBibliotecarios.get(i).getNombre().equals(usuario) && listaBibliotecarios.get(i).getPassword().equals(contrasena)) {
                System.out.println("Acceso concedido. Bienvenido " + listaBibliotecarios.get(i).getNombre() + "!\n");
                boolean isRunning = true;
                while (isRunning) {
                    System.out.println("1. Reservar libro");
                    System.out.println("2. Devolver libro");
                    System.out.println("3. Añadir copia de libro");
                    System.out.println("4. Salir\n");
                    System.out.println("Introduce una opcion: ");
                    int opcion = input.nextInt();
                    switch (opcion) {
                        case 1:
                            reservarLibro(listaUsuarios, listaLibros, listaReservas);
                            break;
                        case 2:
                            devolverLibro(listaLibros, listaReservas);
                            break;
                        case 3:
                            agregarLibroCopia(listaLibros);
                            break;
                        case 4:
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                }
                comprobacion = 0;
                break;
            }
        }
        if (comprobacion == 1) {
            System.out.println("Acceso denegado. Usuario o contraseña incorrectos.");
        }
        return null;
}

//    metodo para que bibliotecario pueda reservarLibro una vez inicie sesion pedirá al usuario el teléfono y el correo electrónico,

    public static void reservarLibro(ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros, ArrayList<Reserva> listaReservas) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca su teléfono: ");
        int telefono1 = Integer.parseInt(input.nextLine());
        System.out.println("Introduzca su correo electrónico: ");
        String correo1 = input.nextLine();
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getTelefono() == telefono1 && usuario.getEmail().equals(correo1)) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        if (usuarioEncontrado == null) {
            System.out.println("No se encontró al usuario");
            return;
        }
        System.out.println("Introduzca el ISBN del libro que desea reservar: ");
        String ISBN = input.nextLine();

        Libro libroEncontrado = null;
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(ISBN)) {
                libroEncontrado = libro;
                break;
            }
        }
        if (libroEncontrado == null) {
            System.out.println("No se encontró el libro");
            return;
        }

        if (libroEncontrado.getNumCopiasDispobibles() <= 0) {
            System.out.println("No quedan unidades disponibles");
            return;
        }

        Reserva reserva = new Reserva();
        listaReservas.add(reserva);

        libroEncontrado.setNumCopiasDispobibles(libroEncontrado.getNumCopiasDispobibles() - 1);
        System.out.println("El libro " + libroEncontrado.getTitulo() + " se ha reservado correctamente");
        System.out.println("Quedan " + libroEncontrado.getNumCopiasDispobibles() + " unidades disponibles");
    }

//    metodo devolverLibro que pide correo y telefono una vez inicie sesion el usuario
public static void devolverLibro(ArrayList<Libro> listaLibros, ArrayList<Reserva> listaReservas) {
    Scanner input = new Scanner(System.in);
    System.out.println("Introduzca el ISBN del libro que desea devolver: ");
    String ISBN = input.nextLine();
    int comprobacion = 1;
    for (int j = 0; j < listaLibros.size(); j++) {
        if (listaLibros.get(j).getISBN().equals(ISBN)) {
            System.out.println("El libro " + listaLibros.get(j).getTitulo() + " se ha devuelto correctamente");
            listaLibros.get(j).setNumCopiasDispobibles(listaLibros.get(j).getNumCopiasDispobibles() + 1);
            comprobacion = 0;
            break;
        }
    }
    if (comprobacion == 1) {
        System.out.println("No se encontró el libro");
    }
}

//   método añadirLibroCopia que permite cambiar datos de un libro y añadir una copia del mismo
    public static void agregarLibroCopia(ArrayList<Libro> listaLibros) {
        Scanner input = new Scanner(System.in);
        System.out.println("------AÑADIR LIBRO COPIA------\n");
        System.out.println("Introduzca el ISBN del libro origen: ");
        String ISBN1 = input.nextLine();
        Libro libroEncontrado = null;
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(ISBN1)) {
                libroEncontrado = libro;
                break;
            }
        }
        if (libroEncontrado == null) {
            System.out.println("No se encontró el libro");
            return;
        }
        System.out.println("Introduzca el ISBN del libro destino: ");
        String ISBN2 = input.nextLine();
        Libro libroEncontrado2 = null;
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(ISBN2)) {
                libroEncontrado2 = libro;
                break;
            }
        }
        if (libroEncontrado2 == null) {
            System.out.println("No se encontró el libro");
            return;
        }
        System.out.println("Introduzca el dato que desea modificar: ");
        System.out.println("1. ISBN");
        System.out.println("2. Título");
        System.out.println("3. Autor");
        System.out.println("4. Editorial");
        System.out.println("5. Salir");
        int opcion = Integer.parseInt(input.nextLine());
        switch (opcion) {
            case 1:
                System.out.println("Introduzca el nuevo ISBN: ");
                String ISBN3 = input.nextLine();
                libroEncontrado2.setISBN(ISBN3);
                break;
            case 2:
                System.out.println("Introduzca el nuevo título: ");
                String titulo = input.nextLine();
                libroEncontrado2.setTitulo(titulo);
                break;
            case 3:
                System.out.println("Introduzca el nuevo autor: ");
                String autor = input.nextLine();
                libroEncontrado2.setAutor(autor);
                break;
            case 4:
                System.out.println("Introduzca la nueva editorial: ");
                String editorial = input.nextLine();
                libroEncontrado2.setEditorial(editorial);
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción incorrecta");
                break;
        }
    }


//    metodo para que el bibliotecario pueda cambiar su contraseña
    public void cambiarPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu contraseña actual:");
        String oldPassword = input.nextLine();
        if (oldPassword.equals(password)) {
            System.out.println("Introduce la nueva contraseña:");
            String newPassword = input.nextLine();
            password = newPassword;
            System.out.println("Contraseña actualizada correctamente.");
        } else {
            System.out.println("La contraseña actual no es correcta.");
        }
    }
}