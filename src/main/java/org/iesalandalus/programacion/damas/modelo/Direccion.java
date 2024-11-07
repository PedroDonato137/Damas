package org.iesalandalus.programacion.damas.modelo;

/**
 * Enumerado Direccion: Esta clase contiene las diferentes direcciones en la que se puede mover una ficha
 *
 * @author Pedro Donato García López
 */

public enum Direccion {
    NORESTE("Noreste"),
    SURESTE("Sureste"),
    SUROESTE("Suroeste"),
    NOROESTE("Noroeste");

    private final String cadenaAMostrar;

    /**
     * Contructor del Enumerado: Este contructor es privado, no deja instanciar ningun objeto de la clase
     * @param cadenaAMostrar
     */
    Direccion(String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    /**
     *Método toString: Devuelve  el valor de la dirección
     *
     * @return Una cadena de caracteres con una dirección
     */
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
