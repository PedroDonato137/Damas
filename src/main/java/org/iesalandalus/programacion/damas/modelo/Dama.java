package org.iesalandalus.programacion.damas.modelo;

public class Dama {

    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    private static final Color COLOR_INICIAL = Color.BLANCO;
    private static final Boolean DAMAESPECIAL_INICIAL = false;

    //Constructor por defecto
    public Dama(){
        this.color = COLOR_INICIAL;
        this.posicion = crearPosicionInicial();
        this.esDamaEspecial = DAMAESPECIAL_INICIAL;
    }

    //Contructor para la clase
    public Dama(Color color){
        this.color = color;
        this.posicion = crearPosicionInicial();
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

        int columnaAleatoria = (int) Math.floor(Math.random() * 4) + 1; // Genera un número aleatorio desde 1 a 4
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

    private Posicion crearPosicionInicial(){

        int posicionFila = 0;
        char posicionColumnas = ' ';

        if(color.toString().equals("Blanco")){
            posicionFila = (int) Math.floor((Math.random() * 3) + 1); // Genera un número aleatorio entre 1 y 3
        }
        else if (color.toString().equals("Negro")){
            posicionFila = (int) Math.floor((Math.random() * 3) + 6); // Genera un número aleatorio entre 6 y 8
        }

        posicionColumnas = columnaAleatoria((posicionFila));

        Posicion posicionAleatoria = new Posicion(posicionFila, posicionColumnas);

        return posicionAleatoria;
    }
}
