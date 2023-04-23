package edu.daw.ApartadoB;
import edu.daw.ApartadoA.Libro;
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

}
