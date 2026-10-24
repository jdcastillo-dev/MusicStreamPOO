
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Album {

    // Atributos
    private String nombre;
    private Artista artista;
    private LocalDate fechaLanzamiento;
    private String caratula;
    private ArrayList<Cancion> canciones;

    // Metodos
    // Constructor
    public Album(String nombre, Artista artista,
                 LocalDate fechaLanzamiento,
                 String caratula,
                 ArrayList<Cancion> canciones) {

        setNombre(nombre);
        setArtista(artista);
        setFechaLanzamiento(fechaLanzamiento);
        setCaratula(caratula);
        setCanciones(canciones);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Artista getArtista() {
        return artista;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getCaratula() {
        return caratula;
    }

    public ArrayList<Cancion> getCanciones() {
        return new ArrayList<>(canciones);
    }

    // Setters
    public void setNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del álbum no puede estar vacío.");
        }

        this.nombre = nombre;
    }

    public void setArtista(Artista artista) {

        if (artista == null) {
            throw new IllegalArgumentException(
                    "El álbum debe tener un artista.");
        }

        this.artista = artista;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {

        if (fechaLanzamiento == null) {
            throw new IllegalArgumentException(
                    "La fecha de lanzamiento no puede ser nula.");
        }

        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setCaratula(String caratula) {

        if (caratula == null || caratula.isBlank()) {
            throw new IllegalArgumentException(
                    "La carátula del álbum no puede estar vacía.");
        }

        this.caratula = caratula;
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

            if (cancion.getAlbum() != this) {
                throw new IllegalArgumentException(
                        "La canción no pertenece a este álbum.");
            }
        }

        this.canciones = new ArrayList<>(canciones);
    }

    // Agregar una canción al álbum
    public void agregarCancion(Cancion cancion) {

        if (cancion == null) {
            throw new IllegalArgumentException(
                    "La canción no puede ser nula.");
        }

        if (cancion.getAlbum() != this) {
            throw new IllegalArgumentException(
                    "La canción no pertenece a este álbum.");
        }

        if (!canciones.contains(cancion)) {
            canciones.add(cancion);
        }
    }

    // Mostrar las canciones del álbum
    public void mostrarCanciones() {

        System.out.println("Álbum: " + nombre);

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
        return "Album{" +
                "nombre='" + nombre + '\'' +
                ", artista=" +
                (artista != null
                        ? artista.getNombre()
                        : "Sin artista") +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", caratula='" + caratula + '\'' +
                ", cantidadCanciones=" + canciones.size() +
                '}';
    }
}
