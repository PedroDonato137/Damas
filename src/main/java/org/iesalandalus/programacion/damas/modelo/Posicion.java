package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

/**
 * Clase Posicion: Esta clase sirve para definir cómo será una posición dentro del tablero
 *
 * @author Pedro Donato García López
 */

public class Posicion {
    private int fila;
    private char columna;

    // Valores iniciales definidos por defecto
    private static final int FILA_MIN = 1;
    private static final int FILA_MAX = 8;

    /**
     * Constructor de la clase Posicion: Crea una posición con su fila y su columna
     *
     * @param fila Entero con la fila del tablero
     * @param columna Caracter con la columna del tablero
     */
    public Posicion(int fila, char columna){
            setFila(fila);
            setColumna(columna);
    }

    /**
     * Constructor (Copia) de la clase Poscion: Crea una posición con su fila y su columna
     * @param posicion Una posición ya creada para reemplazar
     */
    public Posicion(Posicion posicion){
        Objects.requireNonNull(posicion, "ERROR: No es posible copiar una posición nula.");
        this.fila = posicion.fila;
        this.columna = posicion.columna;
    }

    /**
     * Método getFila: Devuelve la fila de la ficha
     *
     * @return Un entero con la fila de la dama
     */
    public int getFila(){
        return fila;
    }

    /**
     * Método getColumna: Devuelve la columna de la ficha
     *
     * @return Un caracter con la colunma de la dama
     */
    public char getColumna(){
        return columna;
    }

    /**
     * Método setFila: este método valida que la fila no sea menor que 0 y mayor que 8 , los limites del tablero
     *
     * @param fila Una fila valida
     */

    // Métodos SET
    private void setFila(int fila){
        if(fila < FILA_MIN){
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        } else if (fila > FILA_MAX) {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
        this.fila = fila;
    }

    /**
     * Método setColumna: Valida que la columna este entre las letras a y h
     *
     * @param columna Una columna valida
     */

    private void setColumna(char columna){
       if (columna != 'a' && columna != 'b' && columna != 'c' && columna != 'd' && columna != 'e' && columna != 'f' && columna != 'g' && columna != 'h'){
           throw new IllegalArgumentException("ERROR: Columna no válida.");
       }
       this.columna = columna;
    }

    /**
     * Métodos equals y hashCode
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicion posicion)) return false;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    /**
     *Método toString: Devuelve la posición completa de la ficha
     *
     * @return Una cadena de carecteres con la posición
     */
    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}
