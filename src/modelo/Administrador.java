package modelo;

public class Administrador extends Usuario {

    // Metodos
    // Constructor
    public Administrador(String correoElectronico,
                         String nombreUsuario,
                         String contrasenia) {

        super(correoElectronico, nombreUsuario, contrasenia);
    }

    // toString
    @Override
    public String toString() {
        return "Administrador{" +
                "correoElectronico='" + getCorreoElectronico() + '\'' +
                ", nombreUsuario='" + getNombreUsuario() + '\'' +
                '}';
    }
}

