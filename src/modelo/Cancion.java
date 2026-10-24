package modelo;

import java.time.LocalDate;

public class Cancion {

    // Atributos
    private String nombre;
    private String genero;
    private Artista artista;
    private Artista compositor;
    private LocalDate fechaLanzamiento;
    private Album album;
    private String caratula;
    private double calificacion;
    private double precio;

    // Metodos
    // Constructor
    public Cancion(String nombre,
                   String genero,
                   Artista artista,
                   Artista compositor,
                   LocalDate fechaLanzamiento,
                   Album album,
                   String caratula,
                   double calificacion,
                   double precio) {

        setNombre(nombre);
        setGenero(genero);
        setArtista(artista);
        setCompositor(compositor);
        setFechaLanzamiento(fechaLanzamiento);
        setAlbum(album);
        setCaratula(caratula);
        setCalificacion(calificacion);
        setPrecio(precio);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public Artista getCompositor() {
        return compositor;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public Album getAlbum() {
        return album;
    }

    public String getCaratula() {
        return caratula;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre de la canción no puede estar vacío.");
        }

        this.nombre = nombre;
    }

    public void setGenero(String genero) {

        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException(
                    "El género musical no puede estar vacío.");
        }

        this.genero = genero;
    }

    public void setArtista(Artista artista) {

        if (artista == null) {
            throw new IllegalArgumentException(
                    "La canción debe tener un artista.");
        }

        this.artista = artista;
    }

    public void setCompositor(Artista compositor) {

        if (compositor == null) {
            throw new IllegalArgumentException(
                    "La canción debe tener un compositor.");
        }

        this.compositor = compositor;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {

        if (fechaLanzamiento == null) {
            throw new IllegalArgumentException(
                    "La fecha de lanzamiento no puede ser nula.");
        }

        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setCaratula(String caratula) {

        if (caratula == null || caratula.isBlank()) {
            throw new IllegalArgumentException(
                    "La carátula no puede estar vacía.");
        }

        this.caratula = caratula;
    }

    public void setCalificacion(double calificacion) {

        if (!Double.isFinite(calificacion)
                || calificacion < 0.0
                || calificacion > 5.0
                || Math.abs(calificacion * 10
                - Math.rint(calificacion * 10)) > 0.000001) {

            throw new IllegalArgumentException(
                    "La calificación debe estar entre 0.0 y 5.0 "
                            + "y tener máximo un decimal.");
        }

        this.calificacion = calificacion;
    }

    public void setPrecio(double precio) {

        if (!Double.isFinite(precio)
                || precio < 0.0
                || Math.abs(precio * 100
                - Math.rint(precio * 100)) > 0.000001) {

            throw new IllegalArgumentException(
                    "El precio no puede ser negativo "
                            + "y debe tener máximo dos decimales.");
        }

        this.precio = precio;
    }

    // toString
    @Override
    public String toString() {

        return "Cancion{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", artista='" +
                (artista != null
                        ? artista.getNombre()
                        : "Sin artista") + '\'' +
                ", compositor='" +
                (compositor != null
                        ? compositor.getNombre()
                        : "Sin compositor") + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", album='" +
                (album != null
                        ? album.getNombre()
                        : "Sin álbum") + '\'' +
                ", caratula='" + caratula + '\'' +
                ", calificacion=" + calificacion +
                ", precio=$" + precio +
                '}';
    }
}


