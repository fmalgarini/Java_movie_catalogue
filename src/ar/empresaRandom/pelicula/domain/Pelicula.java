package ar.empresaRandom.pelicula.domain;

public class Pelicula {

    private String nombrePelicula;

    public Pelicula() {
    }

    public Pelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    
    @Override
    public String toString() {
        return this.nombrePelicula;
    }
    
    

}
