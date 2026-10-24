package modelo;

import java.util.ArrayList;

public class Artista {

    // Atributos
    private String nombre;
    private String nacionalidad;
    private String tipoArtista;
    private ArrayList<Cancion> canciones;

    // Metodos
    // Constructor
    public Artista(String nombre, String nacionalidad,
                   String tipoArtista,
                   ArrayList<Cancion> canciones) {

        setNombre(nombre);
        setNacionalidad(nacionalidad);
        setTipoArtista(tipoArtista);
        setCanciones(canciones);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getTipoArtista() {
        return tipoArtista;
    }

    public ArrayList<Cancion> getCanciones() {
        return new ArrayList<>(canciones);
    }

    // Setters
    public void setNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del artista no puede estar vacío.");
        }

        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {

        if (nacionalidad == null || nacionalidad.isBlank()) {
            throw new IllegalArgumentException(
                    "La nacionalidad del artista no puede estar vacía.");
        }

        this.nacionalidad = nacionalidad;
    }

    public void setTipoArtista(String tipoArtista) {

        if (tipoArtista == null || tipoArtista.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de artista no puede estar vacío.");
        }

        this.tipoArtista = tipoArtista;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {

        if (canciones == null) {
            throw new IllegalArgumentException(
                    "La lista de canciones no puede ser nula.");
        }

        for (Cancion cancion : canciones) {

            if (cancion == null) {
                throw new IllegalArgumentException(
                        "La lista no puede contener canciones nulas.");
            }

            if (cancion.getArtista() != this) {
                throw new IllegalArgumentException(
                        "La canción no pertenece a este artista.");
            }
        }

        this.canciones = new ArrayList<>(canciones);
    }

    // Agregar una canción al artista
    public void agregarCancion(Cancion cancion) {

        if (cancion == null) {
            throw new IllegalArgumentException(
                    "La canción no puede ser nula.");
        }

        if (cancion.getArtista() != this) {
            throw new IllegalArgumentException(
                    "La canción no pertenece a este artista.");
        }

        if (!canciones.contains(cancion)) {
            canciones.add(cancion);
        }
    }

    // toString
    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", tipoArtista='" + tipoArtista + '\'' +
                ", cantidadCanciones=" + canciones.size() +
                '}';
    }
}


