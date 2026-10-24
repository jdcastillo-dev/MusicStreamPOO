package modelo;

import java.util.ArrayList;

public class AplicacionMusical {

    // Atributos
    private String nombre;
    private Administrador administrador;
    private CatalogoMusical catalogoMusical;
    private ArrayList<UsuarioFinal> usuarios;
    private ArrayList<Artista> artistas;
    private ArrayList<Album> albumes;

    // Metodos
    // Constructor
    public AplicacionMusical(String nombre,
                             Administrador administrador,
                             CatalogoMusical catalogoMusical,
                             ArrayList<UsuarioFinal> usuarios,
                             ArrayList<Artista> artistas,
                             ArrayList<Album> albumes) {

        setNombre(nombre);
        setAdministrador(administrador);
        setCatalogoMusical(catalogoMusical);
        setUsuarios(usuarios);
        setArtistas(artistas);
        setAlbumes(albumes);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public CatalogoMusical getCatalogoMusical() {
        return catalogoMusical;
    }

    public ArrayList<UsuarioFinal> getUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public ArrayList<Artista> getArtistas() {
        return new ArrayList<>(artistas);
    }

    public ArrayList<Album> getAlbumes() {
        return new ArrayList<>(albumes);
    }

    // Setters
    public void setNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre de la aplicación no puede estar vacío.");
        }

        this.nombre = nombre;
    }

    public void setAdministrador(Administrador administrador) {

        if (administrador == null) {
            throw new IllegalArgumentException(
                    "La aplicación debe tener un administrador.");
        }

        this.administrador = administrador;
    }

    public void setCatalogoMusical(CatalogoMusical catalogoMusical) {

        if (catalogoMusical == null) {
            throw new IllegalArgumentException(
                    "La aplicación debe tener un catálogo musical.");
        }

        this.catalogoMusical = catalogoMusical;
    }

    public void setUsuarios(ArrayList<UsuarioFinal> usuarios) {

        if (usuarios == null) {
            throw new IllegalArgumentException(
                    "La lista de usuarios no puede ser nula.");
        }

        ArrayList<UsuarioFinal> nuevosUsuarios = new ArrayList<>();

        for (UsuarioFinal usuario : usuarios) {

            if (usuario == null) {
                throw new IllegalArgumentException(
                        "La lista no puede contener usuarios nulos.");
            }

            validarUsuarioDuplicado(usuario, nuevosUsuarios);
            nuevosUsuarios.add(usuario);
        }

        this.usuarios = nuevosUsuarios;
    }

    public void setArtistas(ArrayList<Artista> artistas) {

        if (artistas == null) {
            throw new IllegalArgumentException(
                    "La lista de artistas no puede ser nula.");
        }

        ArrayList<Artista> nuevosArtistas = new ArrayList<>();

        for (Artista artista : artistas) {

            if (artista == null) {
                throw new IllegalArgumentException(
                        "La lista no puede contener artistas nulos.");
            }

            if (!nuevosArtistas.contains(artista)) {
                nuevosArtistas.add(artista);
            }
        }

        this.artistas = nuevosArtistas;
    }

    public void setAlbumes(ArrayList<Album> albumes) {

        if (albumes == null) {
            throw new IllegalArgumentException(
                    "La lista de álbumes no puede ser nula.");
        }

        ArrayList<Album> nuevosAlbumes = new ArrayList<>();

        for (Album album : albumes) {

            if (album == null) {
                throw new IllegalArgumentException(
                        "La lista no puede contener álbumes nulos.");
            }

            if (!nuevosAlbumes.contains(album)) {
                nuevosAlbumes.add(album);
            }
        }

        this.albumes = nuevosAlbumes;
    }

    // Validar usuarios duplicados
    private void validarUsuarioDuplicado(
            UsuarioFinal usuario,
            ArrayList<UsuarioFinal> listaUsuarios) {

        for (UsuarioFinal registrado : listaUsuarios) {

            if (registrado == usuario ||
                    registrado.getNombreUsuario().equalsIgnoreCase(
                            usuario.getNombreUsuario()) ||
                    registrado.getCorreoElectronico().equalsIgnoreCase(
                            usuario.getCorreoElectronico())) {

                throw new IllegalArgumentException(
                        "Ya existe un usuario con ese nombre o correo electrónico.");
            }
        }
    }

    // Registrar usuario
    public void registrarUsuario(UsuarioFinal usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "El usuario no puede ser nulo.");
        }

        validarUsuarioDuplicado(usuario, usuarios);
        usuarios.add(usuario);
    }

    // Registrar artista
    public void registrarArtista(Artista artista) {

        if (artista == null) {
            throw new IllegalArgumentException(
                    "El artista no puede ser nulo.");
        }

        if (!artistas.contains(artista)) {
            artistas.add(artista);
        }
    }

    // Registrar álbum
    public void registrarAlbum(Album album) {

        if (album == null) {
            throw new IllegalArgumentException(
                    "El álbum no puede ser nulo.");
        }

        if (!albumes.contains(album)) {
            albumes.add(album);
        }
    }

    // Mostrar usuarios
    public void mostrarUsuarios() {

        System.out.println("=== USUARIOS ===");

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (UsuarioFinal usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    // Mostrar artistas
    public void mostrarArtistas() {

        System.out.println("=== ARTISTAS ===");

        if (artistas.isEmpty()) {
            System.out.println("No hay artistas registrados.");
        } else {
            for (Artista artista : artistas) {
                System.out.println(artista);
            }
        }
    }

    // Mostrar álbumes
    public void mostrarAlbumes() {

        System.out.println("=== ÁLBUMES ===");

        if (albumes.isEmpty()) {
            System.out.println("No hay álbumes registrados.");
        } else {
            for (Album album : albumes) {
                System.out.println(album);
            }
        }
    }

    // toString
    @Override
    public String toString() {
        return "AplicacionMusical{" +
                "nombre='" + nombre + '\'' +
                ", administrador=" +
                (administrador != null
                        ? administrador.getNombreUsuario()
                        : "Sin administrador") +
                ", catalogoMusical=" + catalogoMusical +
                ", cantidadUsuarios=" + usuarios.size() +
                ", cantidadArtistas=" + artistas.size() +
                ", cantidadAlbumes=" + albumes.size() +
                '}';
    }
}


