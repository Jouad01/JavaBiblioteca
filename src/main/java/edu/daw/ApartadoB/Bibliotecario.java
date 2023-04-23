package edu.daw.ApartadoB;

public class Bibliotecario extends Persona {

    private String puestoTrabajo;
    private String NIF;
    private String password;

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
        return "Bibliotecario{" +
                "puestoTrabajo='" + puestoTrabajo + '\'' +
                ", NIF='" + NIF + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
