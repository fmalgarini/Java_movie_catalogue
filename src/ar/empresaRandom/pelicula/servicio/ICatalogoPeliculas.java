package ar.empresaRandom.pelicula.servicio;

public interface ICatalogoPeliculas {

    String NOMBRE_RECURSO = "Peliculas.txt";

    void agregarPelicula(String nombrePelicula);

    void listarPeliculas();

    void buscarPeliculas(String peliculaAbuscar);

    void iniciarCatalogoPeliculas();

}
