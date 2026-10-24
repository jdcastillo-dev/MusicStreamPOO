import modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        titulo("MUSIC STREAM POO");

        // 1. Administrador
        Administrador administrador = new Administrador(
                "admin@musicstream.com",
                "admin",
                "Admin@123"
        );

        // 2. Catálogo musical
        CatalogoMusical catalogo = new CatalogoMusical(
                "Catálogo MusicStream",
                new ArrayList<>()
        );

        // 3. Aplicación
        AplicacionMusical aplicacion = new AplicacionMusical(
                "MusicStreamPOO",
                administrador,
                catalogo,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        // 4. Artistas
        Artista artista1 = new Artista(
                "Bad Bunny",
                "Puerto Rico",
                "Solista",
                new ArrayList<>()
        );

        Artista artista2 = new Artista(
                "Drake",
                "Canadá",
                "Solista",
                new ArrayList<>()
        );

        aplicacion.registrarArtista(artista1);
        aplicacion.registrarArtista(artista2);

        // 5. Álbum
        Album album1 = new Album(
                "Un Verano Sin Ti",
                artista1,
                LocalDate.of(2022, 5, 6),
                "un_verano_sin_ti.jpg",
                new ArrayList<>()
        );

        aplicacion.registrarAlbum(album1);

        // 6. Canciones
        Cancion cancion1 = new Cancion(
                "Tití Me Preguntó",
                "Reguetón",
                artista1,
                artista1,
                LocalDate.of(2022, 5, 6),
                album1,
                "un_verano_sin_ti.jpg",
                4.8,
                1.99
        );

        Cancion cancion2 = new Cancion(
                "God's Plan",
                "Hip-Hop",
                artista2,
                artista2,
                LocalDate.of(2018, 1, 19),
                null,
                "gods_plan.jpg",
                4.9,
                2.49
        );

        catalogo.agregarCancion(cancion1);
        catalogo.agregarCancion(cancion2);

        artista1.agregarCancion(cancion1);
        artista2.agregarCancion(cancion2);
        album1.agregarCancion(cancion1);

        // 7. Usuario final
        UsuarioFinal usuario = new UsuarioFinal(
                "usuario@gmail.com",
                "josedaniel",
                "Usuario@123",
                "Jose Daniel",
                LocalDate.of(1999, 12, 2),
                "Costa Rica",
                "123456789",
                "avatar.png"
        );

        aplicacion.registrarUsuario(usuario);

        // 8. Registro de canción comprada
        usuario.agregarCancionComprada(cancion1);

        // 9. Lista de reproducción
        ListaReproduccion lista = new ListaReproduccion(
                "Mis Favoritas",
                LocalDate.now(),
                new ArrayList<>(),
                0.0
        );

        lista.agregarCancion(cancion1);
        usuario.agregarListaReproduccion(lista);

        // 10. Calificación
        Calificacion calificacion = new Calificacion(
                usuario,
                cancion1,
                5.0,
                LocalDate.now()
        );

        // MOSTRAR RESULTADOS

        seccion("1. INFORMACIÓN GENERAL");

        System.out.println("Aplicación: "
                + aplicacion.getNombre());

        System.out.println("Administrador: "
                + administrador.getNombreUsuario());

        System.out.println("Catálogo: "
                + catalogo.getNombre());

        seccion("2. ARTISTAS REGISTRADOS");

        for (Artista artista : aplicacion.getArtistas()) {

            System.out.println("Nombre: "
                    + artista.getNombre());

            System.out.println("Nacionalidad: "
                    + artista.getNacionalidad());

            System.out.println("Tipo: "
                    + artista.getTipoArtista());

            System.out.println("Canciones: "
                    + artista.getCanciones().size());

            linea();
        }

        seccion("3. ÁLBUMES REGISTRADOS");

        for (Album album : aplicacion.getAlbumes()) {

            System.out.println("Nombre: "
                    + album.getNombre());

            System.out.println("Artista: "
                    + album.getArtista().getNombre());

            System.out.println("Lanzamiento: "
                    + album.getFechaLanzamiento());

            System.out.println("Canciones: "
                    + album.getCanciones().size());

            linea();
        }

        seccion("4. CATÁLOGO MUSICAL");

        for (Cancion cancion : catalogo.getCanciones()) {
            mostrarCancion(cancion);
        }

        seccion("5. USUARIOS REGISTRADOS");

        for (UsuarioFinal u : aplicacion.getUsuarios()) {

            System.out.println("Nombre: "
                    + u.getNombreCompleto());

            System.out.println("Usuario: "
                    + u.getNombreUsuario());

            System.out.println("Nacionalidad: "
                    + u.getNacionalidad());

            System.out.printf("Saldo: $%.2f%n",
                    u.getSaldo());

            System.out.println("Canciones compradas: "
                    + u.getCancionesCompradas().size());

            System.out.println("Listas de reproducción: "
                    + u.getListasReproduccion().size());

            linea();
        }

        seccion("6. LISTA DE REPRODUCCIÓN");

        System.out.println("Nombre: "
                + lista.getNombre());

        System.out.println("Fecha: "
                + lista.getFechaCreacion());

        System.out.println("Canciones: "
                + lista.getCanciones().size());

        System.out.printf("Calificación: %.1f%n",
                lista.getCalificacion());

        for (Cancion cancion : lista.getCanciones()) {
            System.out.println(" - "
                    + cancion.getNombre());
        }

        seccion("7. CALIFICACIÓN REGISTRADA");

        System.out.println("Usuario: "
                + calificacion.getUsuario().getNombreUsuario());

        System.out.println("Canción: "
                + calificacion.getCancion().getNombre());

        System.out.println("Puntuación: "
                + calificacion.getPuntuacion());

        System.out.println("Fecha: "
                + calificacion.getFechaCalificacion());

        seccion("8. BÚSQUEDA DE CANCIÓN");

        Cancion encontrada =
                catalogo.buscarCancion("God's Plan");

        if (encontrada != null) {

            System.out.println("Canción encontrada:");
            mostrarCancion(encontrada);

        } else {

            System.out.println("Canción no encontrada.");
        }

        titulo("PRUEBAS FINALIZADAS");
    }

    // MÉTODOS PARA FORMATO DE CONSOLA

    public static void titulo(String texto) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("          " + texto);
        System.out.println("========================================");
    }

    public static void seccion(String texto) {

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(" " + texto);
        System.out.println("----------------------------------------");
    }

    public static void linea() {

        System.out.println("----------------------------------------");
    }

    public static void mostrarCancion(Cancion cancion) {

        System.out.println("Nombre: "
                + cancion.getNombre());

        System.out.println("Género: "
                + cancion.getGenero());

        System.out.println("Artista: "
                + (cancion.getArtista() != null
                ? cancion.getArtista().getNombre()
                : "Sin artista"));

        System.out.println("Álbum: "
                + (cancion.getAlbum() != null
                ? cancion.getAlbum().getNombre()
                : "Sin álbum"));

        System.out.printf("Calificación: %.1f%n",
                cancion.getCalificacion());

        System.out.printf("Precio: $%.2f%n",
                cancion.getPrecio());

        linea();
    }
}



