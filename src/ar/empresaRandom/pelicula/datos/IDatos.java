package ar.empresaRandom.pelicula.datos;

import ar.empresaRandom.pelicula.domain.Pelicula;
import ar.empresaRandom.pelicula.excepciones.*;
import java.util.List;

public interface IDatos {

    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws AccesoDatosEx;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean seAnexa) throws AccesoDatosEx;

    String buscar(String nombreRecurso, String nombreAbuscar) throws AccesoDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;

}
