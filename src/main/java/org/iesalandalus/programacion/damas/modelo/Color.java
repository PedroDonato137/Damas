package org.iesalandalus.programacion.damas.modelo;

public enum Color {
    BLANCO("Blanco"),
    NEGRO("Negro");

    private final String cadenaAMostrar;

    private Color(String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
