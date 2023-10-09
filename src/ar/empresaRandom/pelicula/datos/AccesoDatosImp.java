package ar.empresaRandom.pelicula.datos;

import ar.empresaRandom.pelicula.domain.Pelicula;
import ar.empresaRandom.pelicula.excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImp implements IDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {

        var archivo = new File(nombreRecurso);

        return archivo.exists();

    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            throw new AccesoDatosEx("Excepcion a listar peliculas." + ex.getMessage());
        } catch (IOException ex) {
            throw new AccesoDatosEx("Excepcion a listar peliculas." + ex.getMessage());
        }

        return peliculas;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean seAnexa) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, seAnexa));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo." + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al escribir peliculas. :" + ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreRecurso, String nombreAbuscar) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (nombreAbuscar != null && nombreAbuscar.equalsIgnoreCase(linea)) {
                    resultado = "La pelicula encontrada es: " + linea + " encontrada en el indice: " + indice;
                } else {
                    resultado = "No se encontro la pelicula: " + nombreAbuscar;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al buscar peliculas. :" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al buscar peliculas. :" + ex.getMessage());
        }

        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo.");

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear peliculas. :" + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se ha borrado la pelicula." + archivo.toString());
        } else {
            System.out.println("La pelicula que desea borrar, no existe.");
        }

    }

}
