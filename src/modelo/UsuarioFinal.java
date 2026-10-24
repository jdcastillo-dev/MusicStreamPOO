
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioFinal extends Usuario {

    // Atributos
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String cedula;
    private String avatar;
    private double saldo;
    private ArrayList<Cancion> cancionesCompradas;
    private ArrayList<ListaReproduccion> listasReproduccion;

    // Metodos
    // Constructor
    public UsuarioFinal(String correoElectronico,
                        String nombreUsuario,
                        String contrasenia,
                        String nombreCompleto,
                        LocalDate fechaNacimiento,
                        String nacionalidad,
                        String cedula,
                        String avatar) {

        super(correoElectronico, nombreUsuario, contrasenia);

        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.cedula = cedula;
        this.avatar = avatar;
        this.saldo = 4.99;
        this.cancionesCompradas = new ArrayList<>();
        this.listasReproduccion = new ArrayList<>();
    }

    // Constructor super
    public UsuarioFinal(String correoElectronico,
                        String nombreUsuario,
                        String contrasenia,
                        String nombreCompleto,
                        LocalDate fechaNacimiento,
                        String nacionalidad,
                        String cedula,
                        String avatar,
                        double saldo,
                        ArrayList<Cancion> cancionesCompradas,
                        ArrayList<ListaReproduccion> listasReproduccion) {

        super(correoElectronico, nombreUsuario, contrasenia);

        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.cedula = cedula;
        this.avatar = avatar;

        setSaldo(saldo);
        setCancionesCompradas(cancionesCompradas);
        setListasReproduccion(listasReproduccion);
    }

    // Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getAvatar() {
        return avatar;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Cancion> getCancionesCompradas() {
        return new ArrayList<>(cancionesCompradas);
    }

    public ArrayList<ListaReproduccion> getListasReproduccion() {
        return new ArrayList<>(listasReproduccion);
    }

    // Setters
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setSaldo(double saldo) {

        if (!Double.isFinite(saldo) || saldo < 0) {
            throw new IllegalArgumentException(
                    "El saldo debe ser un número válido y no negativo.");
        }

        this.saldo = saldo;
    }

    public void setCancionesCompradas(
            ArrayList<Cancion> cancionesCompradas) {

        if (cancionesCompradas == null) {
            throw new IllegalArgumentException(
                    "La lista de canciones no puede ser nula.");
        }

        this.cancionesCompradas =
                new ArrayList<>(cancionesCompradas);
    }

    public void setListasReproduccion(
            ArrayList<ListaReproduccion> listasReproduccion) {

        if (listasReproduccion == null) {
            throw new IllegalArgumentException(
                    "La lista de reproducción no puede ser nula.");
        }

        this.listasReproduccion =
                new ArrayList<>(listasReproduccion);
    }

    // Agregar una canción comprada
    public void agregarCancionComprada(Cancion cancion) {

        if (cancion != null &&
                !cancionesCompradas.contains(cancion)) {

            cancionesCompradas.add(cancion);
        }
    }

    // Agregar una lista de reproducción
    public void agregarListaReproduccion(
            ListaReproduccion lista) {

        if (lista != null &&
                !listasReproduccion.contains(lista)) {

            listasReproduccion.add(lista);
        }
    }

    // toString
    @Override
    public String toString() {
        return "UsuarioFinal{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", cedula='" + cedula + '\'' +
                ", avatar='" + avatar + '\'' +
                ", saldo=" + saldo +
                ", cancionesCompradas=" + cancionesCompradas.size() +
                ", listasReproduccion=" + listasReproduccion.size() +
                ", nombreUsuario='" + getNombreUsuario() + '\'' +
                '}';
    }
}


