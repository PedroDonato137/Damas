package org.iesalandalus.programacion.damas.modelo;

public class Dama {

    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    // Métodos GET
    public Color getColor() {
        return color;
    }
    public Posicion getPosicion() {
        return posicion;
    }

    //Métodos SET
    private void setColor(Color color) {
        this.color = color;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

}
