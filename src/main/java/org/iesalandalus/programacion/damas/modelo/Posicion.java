package org.iesalandalus.programacion.damas.modelo;

public class Posicion {
    private int fila;
    private char columna;

    private static final int FILA_MIN = 1;
    private static final int FILA_MAX = 8;


    public Posicion(int fila, char columna){
        setFila(fila);
        setColumna(columna);
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    private void setFila(int fila){
        if(fila < FILA_MIN){
            throw new IllegalArgumentException("ERROR: La fila no puede ser menor a 1");
        } else if (fila > FILA_MAX) {
            throw new IllegalArgumentException("ERROR: La fila no puede ser mayor a 8");
        }
        this.fila = fila;
    }

    private void setColumna(char columna){
       if (columna != 'a' && columna != 'b' && columna != 'c' && columna != 'd' && columna != 'e' && columna != 'f' && columna != 'g' && columna != 'h'){
           throw new IllegalArgumentException("ERROR: La columna solo puede ser desde a hasta h");
       }
       this.columna = columna;
    }
}
