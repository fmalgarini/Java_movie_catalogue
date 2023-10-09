package ar.empresaRandom.pelicula.servicio;

import ar.empresaRandom.pelicula.datos.*;
import ar.empresaRandom.pelicula.domain.Pelicula;
import ar.empresaRandom.pelicula.excepciones.*;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IDatos datos;

    public CatalogoPeliculasImpl() {

        this.datos = new AccesoDatosImp();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos.");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso datos.");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPeliculas(String peliculaAbuscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, peliculaAbuscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar pelicula.");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas.");
            ex.printStackTrace(System.out);
        }

    }

}
