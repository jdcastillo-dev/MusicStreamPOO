package modelo;

import java.time.LocalDate;

public class Calificacion {

    // Atributos
    private UsuarioFinal usuario;
    private Cancion cancion;
    private double puntuacion;
    private LocalDate fechaCalificacion;

    // Metodos
    // Constructor
    public Calificacion(UsuarioFinal usuario,
                        Cancion cancion,
                        double puntuacion,
                        LocalDate fechaCalificacion) {

        setUsuario(usuario);
        setCancion(cancion);
        setPuntuacion(puntuacion);
        setFechaCalificacion(fechaCalificacion);
    }

    // Getters
    public UsuarioFinal getUsuario() {
        return usuario;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public LocalDate getFechaCalificacion() {
        return fechaCalificacion;
    }

    // Setters
    public void setUsuario(UsuarioFinal usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "El usuario no puede ser nulo.");
        }

        this.usuario = usuario;
    }

    public void setCancion(Cancion cancion) {

        if (cancion == null) {
            throw new IllegalArgumentException(
                    "La canción no puede ser nula.");
        }

        this.cancion = cancion;
    }

    public void setPuntuacion(double puntuacion) {

        if (!Double.isFinite(puntuacion)
                || puntuacion < 0.0
                || puntuacion > 5.0
                || Math.abs(puntuacion * 10
                - Math.rint(puntuacion * 10)) > 0.000001) {

            throw new IllegalArgumentException(
                    "La puntuación debe estar entre 0.0 y 5.0 "
                            + "y tener máximo un decimal.");
        }

        this.puntuacion = puntuacion;
    }

    public void setFechaCalificacion(
            LocalDate fechaCalificacion) {

        if (fechaCalificacion == null) {
            throw new IllegalArgumentException(
                    "La fecha de calificación no puede ser nula.");
        }

        this.fechaCalificacion = fechaCalificacion;
    }

    // toString
    @Override
    public String toString() {
        return "Calificacion{" +
                "usuario='" + usuario.getNombreUsuario() + '\'' +
                ", cancion='" + cancion.getNombre() + '\'' +
                ", puntuacion=" + puntuacion +
                ", fechaCalificacion=" + fechaCalificacion +
                '}';
    }
}


