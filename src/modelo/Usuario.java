package modelo;

public class Usuario {

    // Atributos
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;

    // Metodos
    // Constructor
    public Usuario(String correoElectronico,
                   String nombreUsuario,
                   String contrasenia) {

        setCorreoElectronico(correoElectronico);
        setNombreUsuario(nombreUsuario);
        setContrasenia(contrasenia);
    }

    // Getters
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    // Setters
    public void setCorreoElectronico(String correoElectronico) {

        if (correoElectronico == null ||
                correoElectronico.isBlank()) {

            throw new IllegalArgumentException(
                    "El correo electrónico no puede estar vacío.");
        }

        this.correoElectronico = correoElectronico;
    }

    public void setNombreUsuario(String nombreUsuario) {

        if (nombreUsuario == null ||
                nombreUsuario.isBlank()) {

            throw new IllegalArgumentException(
                    "El nombre de usuario no puede estar vacío.");
        }

        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasenia(String contrasenia) {

        if (contrasenia == null ||
                !contrasenia.matches(
                        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)" +
                                "(?=.*[^a-zA-Z0-9\\s])\\S{8,12}$")) {

            throw new IllegalArgumentException(
                    "La contraseña debe tener entre 8 y 12 caracteres, " +
                            "una mayúscula, una minúscula, " +
                            "un número y un carácter especial.");
        }

        this.contrasenia = contrasenia;
    }

    // toString
    @Override
    public String toString() {
        return "Usuario{" +
                "correoElectronico='" + correoElectronico + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}

