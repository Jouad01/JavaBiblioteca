package edu.daw.ApartadoB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reserva implements Material{
    private Libro libro;
    private String fechaReserva;
    private String horaReserva;

    ArrayList <Reserva> listaReservas = new ArrayList <>();
    ArrayList<Libro> listaLibros = new ArrayList <>();

//    constructor vacio
    public Reserva() {
    }

//    constructor con parametros
    public Reserva(Libro libro, String fechaReserva, String horaReserva) {
        this.libro = libro;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
    }

//    constructor copia
    public Reserva(Reserva reserva) {
        this.libro = reserva.libro;
        this.fechaReserva = reserva.fechaReserva;
        this.horaReserva = reserva.horaReserva;
    }

//    getters y setters

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

//    toString

    @Override
    public String toString() {
        return "Reserva{" +
                "libro=" + libro +
                ", fechaReserva='" + fechaReserva + '\'' +
                ", horaReserva='" + horaReserva + '\'' +
                '}';
    }

//    metodo que solicita los datos de la reserva
    public void agregarReserva(String ISBN, Usuario usuario) {
        Biblioteca biblioteca = new Biblioteca();
        for (Libro libro : biblioteca.getListaLibros()) {
            if (libro.getISBN().equals(ISBN)) {
                Reserva reserva = new Reserva(libro, LocalDate.now().toString() , LocalDate.now().toString());
                libro.setNumCopiasDispobibles(libro.getNumCopiasDispobibles() - 1);
                usuario.agregarReserva(reserva);
                System.out.println("Reserva realizada con exito");
                System.out.println("El libro es: ");
                System.out.println(reserva.mostrarInfoChula());
            }
        }
    }

//    metodos de la interfaz Material
    @Override
    public LocalDate obtenerFechaDevolucion() {
        LocalDate fechaDevolucion = LocalDate.parse(this.fechaReserva).plusDays(7);
        return fechaDevolucion;
    }

    @Override
    public String mostrarInfoChula() {
        return "Libro: " + libro + "\n fecha de reserva: + " + fechaReserva + "\n hora de reserva: " + horaReserva;
    }
}
