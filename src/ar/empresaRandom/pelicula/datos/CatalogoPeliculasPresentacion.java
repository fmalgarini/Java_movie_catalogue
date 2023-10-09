package ar.empresaRandom.pelicula.datos;

import ar.empresaRandom.pelicula.servicio.*;
import java.util.Scanner;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        int opcion = -1;
        Scanner read = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar catalogo de peliculas.\n"
                    + "2. Agregar pelicula. \n"
                    + "3. Listar peliculas. \n"
                    + "4. Buscar peliculas. \n"
                    + "0. Salir.");
            opcion = Integer.parseInt(read.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula que deseas agregar.");
                    catalogo.agregarPelicula(read.nextLine());
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;

                case 4:
                    System.out.println("Introduce el nombre de la pelicula que deseas buscar.");
                    catalogo.buscarPeliculas(read.nextLine());
                    break;
                    
                case 0: System.out.println("Usted salio del programa. Saludos");
                break;

                default:
                    System.out.println("La opcion que usted ingreso es incorrecta.");

            }
        }
    }

}
