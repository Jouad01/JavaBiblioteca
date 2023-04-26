package edu.daw.ApartadoB;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MenuBibliotecario {
    public static void main(String[] args) {
        ArrayList <Persona> listaPersonas = new ArrayList<>();
        ArrayList <Bibliotecario> listaBibliotecarios = new ArrayList<>();
        ArrayList <Usuario> listaUsuarios = new ArrayList<>();
        ArrayList <Libro> listaLibros = new ArrayList<>();
        ArrayList <Reserva> listaReservas = new ArrayList<>();
        leerDatosDeArchivo(listaPersonas, listaBibliotecarios, listaUsuarios, listaLibros);

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
            System.out.println("8. Guardar toda la informacion");
            System.out.println("9. Mostrar toda la informacion");
            System.out.println("10. Salir\n");
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
                    guardarDatosEnArchivo(listaPersonas, listaBibliotecarios, listaUsuarios, listaLibros);
                    break;
                case 9:
                    mostrarDatosEnArchivo();
                    break;
                case 10:
                    isRunning = false;
                    break;
                default:
                    System.out.println("No hay presupuesto para un programa más elaborado. Vuelve a intentarlo.\n");
                    break;
            }
        }
    }

//    metodo que guardara toda la informacion
    public static void guardarDatosEnArchivo(ArrayList<Persona> listaPersonas, ArrayList<Bibliotecario> listaBibliotecarios, ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros) {
        try {
            File archivo = new File("C:\\Users\\jouad\\OneDrive\\Documentos\\JAVA\\JavaBiblioteca\\src\\main\\java\\edu\\daw\\ApartadoB\\datos.txt");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            FileWriter writer = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            PrintWriter printWriter = new PrintWriter(buffer);

            // Leer los datos existentes del archivo y guardarlos en un HashSet
            HashSet<String> datosExisten = new HashSet<>();
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                datosExisten.add(linea);
            }
            br.close();

            // Escribir solo los datos nuevos que no existen en el archivo
            for (Libro libro : listaLibros) {
                String datoNuevo = "Libros: " + libro.getTitulo() + " - " + libro.getAutor() + "\n";
                if (!datosExisten.contains(datoNuevo)) {
                    printWriter.println(datoNuevo);
                }
            }
            for (Bibliotecario bibliotecario : listaBibliotecarios) {
                String datoNuevo = "Bibliotecarios: " + bibliotecario.getNombre() + " " + bibliotecario.getApellido1() + "\n";
                if (!datosExisten.contains(datoNuevo)) {
                    printWriter.println(datoNuevo);
                }
            }
            for (Usuario usuario : listaUsuarios) {
                String datoNuevo = "Usuarios: " + usuario.getNombre() + " " + usuario.getApellido1() + "\n";
                if (!datosExisten.contains(datoNuevo)) {
                    printWriter.println(datoNuevo);
                }
            }

            printWriter.close();
            buffer.close();
            writer.close();
            System.out.println("Datos guardados en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //   metodo provisional que lee los datos del archivo para que al volver a ejecutar el menu la informacion pueda ser recuperada
    public static void leerDatosDeArchivo(ArrayList<Persona> listaPersonas, ArrayList<Bibliotecario> listaBibliotecarios, ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros) {
        try {
            File archivo = new File("C:\\Users\\jouad\\OneDrive\\Documentos\\JAVA\\JavaBiblioteca\\src\\main\\java\\edu\\daw\\ApartadoB\\datos.txt");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            FileReader reader = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(reader);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                String[] datos = linea.split(":");
                if (datos[0].equals("Libros")) {
                    String[] datosLibro = datos[1].split("-");
                    Libro libro = new Libro(datosLibro[0].trim(), datosLibro[1].trim());
                    listaLibros.add(libro);
                } else if (datos[0].equals("Bibliotecarios")) {
                    String[] datosBibliotecario = datos[1].split(" ");
                    Bibliotecario bibliotecario = new Bibliotecario(datosBibliotecario[0].trim(), datosBibliotecario[1].trim());
                    listaBibliotecarios.add(bibliotecario);
                } else if (datos[0].equals("Usuarios")) {
                    String[] datosUsuario = datos[1].split(" ");
                    Usuario usuario = new Usuario(datosUsuario[0].trim(), datosUsuario[1].trim());
                    listaUsuarios.add(usuario);
                }
            }
            buffer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    metodo encargado de mostrar los datos del archivo .txt
    public static void mostrarDatosEnArchivo() {
        try {
            File archivo = new File("C:\\Users\\jouad\\OneDrive\\Documentos\\JAVA\\JavaBiblioteca\\src\\main\\java\\edu\\daw\\ApartadoB\\datos.txt");
            if (!archivo.exists()) {
                System.out.println("No hay datos guardados");
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

