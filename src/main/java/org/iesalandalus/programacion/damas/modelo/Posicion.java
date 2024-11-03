package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    private static final int FILA_MIN = 1;
    private static final int FILA_MAX = 8;

    //Constructor
    public Posicion(int fila, char columna){

        //Comprobar fila
        try{
            setFila(fila);
        }
        catch (IllegalArgumentException e){
            System.out.println("Fila incorrecta: " + e.getMessage());
        }

        // Comprobar Columna
        try{
            setColumna(columna);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Columna incorrecta: " + e.getMessage());
        }
    }

    //Constructor Copia
    public Posicion(Posicion posicon){
        this.fila = posicon.fila;
        this.columna = posicon.columna;
    }

    // Métodos GET
    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    // Métodos SET
    private void setFila(int fila){
        if(fila < FILA_MIN){
            throw new IllegalArgumentException("La fila no puede ser menor a 1");
        } else if (fila > FILA_MAX) {
            throw new IllegalArgumentException("La fila no puede ser mayor a 8");
        }
        this.fila = fila;
    }

    private void setColumna(char columna){
       if (columna != 'a' && columna != 'b' && columna != 'c' && columna != 'd' && columna != 'e' && columna != 'f' && columna != 'g' && columna != 'h'){
           throw new IllegalArgumentException("La columna solo puede ser desde a hasta h");
       }
       this.columna = columna;
    }

    // Métodos equals y hashCode
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

    //Método toString()
    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}
