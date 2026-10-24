package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaReproduccion {

    // Atributos
    private String nombre;
    private LocalDate fechaCreacion;
    private ArrayList<Cancion> canciones;
    private double calificacion;

    // Metodos
    // Constructor
    public ListaReproduccion(String nombre,
                             LocalDate fechaCreacion,
                             ArrayList<Cancion> canciones,
                             double calificacion) {

        setNombre(nombre);
        setFechaCreacion(fechaCreacion);
        setCanciones(canciones);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public ArrayList<Cancion> getCanciones() {
        return new ArrayList<>(canciones);
    }

    public double getCalificacion() {
        return calificacion;
    }

    // Setters
    public void setNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre de la lista no puede estar vacío.");
        }

        this.nombre = nombre;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {

        if (fechaCreacion == null) {
            throw new IllegalArgumentException(
                    "La fecha de creación no puede ser nula.");
        }

        this.fechaCreacion = fechaCreacion;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {

        if (canciones == null) {
            throw new IllegalArgumentException(
                    "La lista de canciones no puede ser nula.");
        }

        ArrayList<Cancion> nuevasCanciones = new ArrayList<>();

        for (Cancion cancion : canciones) {

            if (cancion == null) {
                throw new IllegalArgumentException(
                        "La lista no puede contener canciones nulas.");
            }

            if (!nuevasCanciones.contains(cancion)) {
                nuevasCanciones.add(cancion);
            }
        }

        this.canciones = nuevasCanciones;
        calcularCalificacion();
    }

    // Agregar una canción
    public void agregarCancion(Cancion cancion) {

        if (cancion == null) {
            throw new IllegalArgumentException(
                    "La canción no puede ser nula.");
        }

        if (!canciones.contains(cancion)) {
            canciones.add(cancion);
            calcularCalificacion();
        }
    }

    // Eliminar una canción
    public void eliminarCancion(Cancion cancion) {

        if (canciones.remove(cancion)) {
            calcularCalificacion();
        }
    }

    // Calcular promedio de calificaciones
    public void calcularCalificacion() {

        if (canciones.isEmpty()) {
            calificacion = 0.0;
            return;
        }

        double suma = 0.0;

        for (Cancion cancion : canciones) {
            suma += cancion.getCalificacion();
        }

        calificacion = Math.round(
                (suma / canciones.size()) * 10.0
        ) / 10.0;
    }

    // Mostrar canciones registradas
    public void mostrarCanciones() {

        System.out.println("Lista: " + nombre);

        if (canciones.isEmpty()) {
            System.out.println("No hay canciones registradas.");
        } else {
            for (Cancion cancion : canciones) {
                System.out.println(cancion);
            }
        }
    }

    // toString
    @Override
    public String toString() {
        return "ListaReproduccion{" +
                "nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", cantidadCanciones=" + canciones.size() +
                ", calificacion=" + calificacion +
                '}';
    }
}

