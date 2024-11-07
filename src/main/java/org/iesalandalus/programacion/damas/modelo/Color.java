package org.iesalandalus.programacion.damas.modelo;

/**
 * Enumerado Color: Esta clase contiene los diferentes colores de las fichas
 *
 * @author Pedro Donato García López
 */
public enum Color {
    BLANCO("Blanco"),
    NEGRO("Negro");

    private final String cadenaAMostrar;

    /**
     * Constructor del Enumerado: Este contructor es privado, no deja instanciar ningun objeto de la clase
     *
     * @param cadenaAMostrar
     */
    Color(String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    /**
     *Método toString: Devuelve  el valor del color
     *
     * @return Una cadena de carecteres con el color
     */
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
