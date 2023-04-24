package edu.daw.ApartadoB;

import java.util.Scanner;

public class Reserva {
    private Libro libro;
    private String fechaReserva;
    private String horaReserva;

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
    public void solicitarDatosReserva() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el título del libro: ");
        String titulo = input.nextLine();
        System.out.println("Ingrese el autor del libro: ");
        String autor = input.nextLine();
        System.out.println("Ingrese la fecha de reserva (dd/mm/aaaa): ");
        String fechaReserva = input.nextLine();
        System.out.println("Ingrese la hora de reserva (hh:mm:ss): ");
        String horaReserva = input.nextLine();
        this.libro = new Libro(titulo, autor);
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
    }
}
