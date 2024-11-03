package org.iesalandalus.programacion.damas.modelo;

public class Dama {

    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    private static final Color COLOR_INICIAL = Color.BLANCO;
    private static final int POSICION_INICIAL = (int) Math.floor(Math.random() * 3); // Número aleatorio entre 0 y 2
    private static final char POSICION_INICIAL_COL = columnaAleatoria(POSICION_INICIAL + 1);
    private static final Boolean DAMAESPECIAL_INICIAL = false;

    //Constructor por defecto
    public Dama(){
        this.color = COLOR_INICIAL;
        this.posicion = new Posicion((POSICION_INICIAL + 1), POSICION_INICIAL_COL); // Al sumarle 1 a la posición inicial se transforma en 1 a 3
        this.esDamaEspecial = DAMAESPECIAL_INICIAL;
    }

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

    public static char columnaAleatoria(int filaFicha){

        int columnaAleatoria = (int) Math.floor(Math.random() * 4) + 1; // Genera un numero aleatorio desde 1 a 4
        char posicionColumna = ' ';

        if (filaFicha%2 == 0){
            switch (columnaAleatoria){
                case 1:
                    posicionColumna = 'b';
                case 2:
                    posicionColumna = 'd';
                case 3:
                    posicionColumna = 'f';
                case 4:
                    posicionColumna = 'h';
            }
        }else{
            switch (columnaAleatoria){
                case 1:
                    posicionColumna = 'a';
                case 2:
                    posicionColumna = 'c';
                case 3:
                    posicionColumna = 'e';
                case 4:
                    posicionColumna = 'g';
            }
        }
        return posicionColumna;
    }
}
