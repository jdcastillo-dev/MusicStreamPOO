package modelo;

import java.util.ArrayList;

public class CatalogoMusical {

    // Atributos
    private String nombre;
    private ArrayList<Cancion> canciones;

    // Metodos
    // Constructor
    public CatalogoMusical(String nombre,
                           ArrayList<Cancion> canciones) {

        setNombre(nombre);
        setCanciones(canciones);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cancion> getCanciones() {
        return new ArrayList<>(canciones);
    }

    // Setters
    public void setNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del catálogo no puede estar vacío.");
        }

        this.nombre = nombre;
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
                        "El catálogo no puede contener canciones nulas.");
            }

            if (!nuevasCanciones.contains(cancion)) {
                nuevasCanciones.add(cancion);
            }
        }

        this.canciones = nuevasCanciones;
    }

    // Registrar una canción
    public void agregarCancion(Cancion cancion) {

        if (cancion == null) {
            throw new IllegalArgumentException(
                    "La canción no puede ser nula.");
        }

        if (!canciones.contains(cancion)) {
            canciones.add(cancion);
        }
    }

    // Buscar canción por nombre
    public Cancion buscarCancion(String nombreCancion) {

        if (nombreCancion == null || nombreCancion.isBlank()) {
            return null;
        }

        String nombreBuscado = nombreCancion.trim();

        for (Cancion cancion : canciones) {

            if (cancion.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return cancion;
            }
        }

        return null;
    }

    // Mostrar canciones del catálogo
    public void mostrarCanciones() {

        if (canciones.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }

        System.out.println("=== CATÁLOGO MUSICAL ===");

        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

    // toString
    @Override
    public String toString() {
        return "CatalogoMusical{" +
                "nombre='" + nombre + '\'' +
                ", cantidadCanciones=" + canciones.size() +
                '}';
    }
}


