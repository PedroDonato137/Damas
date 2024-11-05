package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Dama {

    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    private static final Color COLOR_INICIAL = Color.BLANCO;
    private static final Boolean DAMAESPECIAL_INICIAL = false;

    //Constructor por defecto
    public Dama() {
        setColor(COLOR_INICIAL);
        setPosicion(crearPosicionInicial());
        this.esDamaEspecial = DAMAESPECIAL_INICIAL;
    }

    //Contructor para la clase
    public Dama(Color color) {
        Objects.requireNonNull(color, "ERROR: El color no puede ser nulo.");
        setColor(color);
        setPosicion(crearPosicionInicial());
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

    // Métodos crearPosicionInicial
    private Posicion crearPosicionInicial() { // Apartado 4.1

        int posicionFila = 0;
        int columnaAleatoria = (int) Math.floor(Math.random() * 4) + 1; // Genera un número aleatorio desde 1 a 4
        char posicionColumna = ' ';

        if (color.toString().equalsIgnoreCase("Blanco")) {
            posicionFila = (int) Math.floor((Math.random() * 3) + 1); // Genera un número aleatorio entre 1 y 3
        } else if (color.toString().equalsIgnoreCase("Negro")) {
            posicionFila = (int) Math.floor((Math.random() * 3) + 6); // Genera un número aleatorio entre 6 y 8
        }

        if (posicionFila % 2 == 0) {
            switch (columnaAleatoria) {
                case 1:
                    posicionColumna = 'b';
                    break;
                case 2:
                    posicionColumna = 'd';
                    break;
                case 3:
                    posicionColumna = 'f';
                    break;
                case 4:
                    posicionColumna = 'h';
                    break;
            }
        } else {
            switch (columnaAleatoria) {
                case 1:
                    posicionColumna = 'a';
                    break;
                case 2:
                    posicionColumna = 'c';
                    break;
                case 3:
                    posicionColumna = 'e';
                    break;
                case 4:
                    posicionColumna = 'g';
                    break;
            }
        }

        Posicion posicionAleatoria = new Posicion(posicionFila, posicionColumna);

        return posicionAleatoria;
    }

    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {

        int nuevaFila = posicion.getFila();
        char nuevaLetra = posicion.getColumna();

        int ejeX = 0; // 0 -> Derecha | 1 -> Izquierda || Variable auxiliar para ver la dirreción de la ficha

        //Validaciones
        Objects.requireNonNull(direccion, "ERROR: La dirección no puede ser nula.");
        if (pasos <= 0) { // Apartado 5.2
            throw new IllegalArgumentException("El número de pasos debe ser mayor que cero.");
        }
        if (!this.esDamaEspecial && pasos != 1) { // Apartado 5.2.1.
            throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");
        }

        // Método Mover
        if (this.esDamaEspecial) {
            if ((direccion.toString().equalsIgnoreCase("NOROESTE") || (direccion.toString().equalsIgnoreCase("NORESTE")))) {
                nuevaFila += pasos;
            } else {
                nuevaFila -= pasos;
            }
        } else if (color.toString().equalsIgnoreCase("Blanco")) {
            if (direccion.toString().equalsIgnoreCase("NORESTE") || direccion.toString().equalsIgnoreCase("NOROESTE")){ // Apartado 5.4
                nuevaFila++;
                if (nuevaFila == 8) { // Apartado 5.3
                    this.esDamaEspecial = true;
                }
            } else{
                throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
            }
        } else if (color.toString().equalsIgnoreCase("Negro")) {
            if (direccion.toString().equalsIgnoreCase("SURESTE") || direccion.toString().equalsIgnoreCase("SUROESTE")) { // Apartado 5.4
                nuevaFila--;
                if (nuevaFila == 1) { // Apartado 5.3
                    this.esDamaEspecial = true;
                }
            }else{
                throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
            }
        }

        if(direccion.toString().equalsIgnoreCase("NOROESTE") || direccion.toString().equalsIgnoreCase("SUROESTE")){
            ejeX = 1;
        }
        for (int i = pasos; i != 0; i--) {
            switch (ejeX) {
                case 0:
                    switch (nuevaLetra) {
                        case 'a':
                            nuevaLetra = 'b';
                            break;
                        case 'b':
                            nuevaLetra = 'c';
                            break;
                        case 'c':
                            nuevaLetra = 'd';
                            break;
                        case 'd':
                            nuevaLetra = 'e';
                            break;
                        case 'e':
                            nuevaLetra = 'f';
                            break;
                        case 'f':
                            nuevaLetra = 'g';
                            break;
                        case 'g':
                            nuevaLetra = 'h';
                            break;
                    }
                    break;
                case 1:
                    switch (nuevaLetra) {
                        case 'b':
                            nuevaLetra = 'a';
                            break;
                        case 'c':
                            nuevaLetra = 'b';
                            break;
                        case 'd':
                            nuevaLetra = 'c';
                            break;
                        case 'e':
                            nuevaLetra = 'd';
                            break;
                        case 'f':
                            nuevaLetra = 'e';
                            break;
                        case 'g':
                            nuevaLetra = 'f';
                            break;
                        case 'h':
                            nuevaLetra = 'g';
                            break;
                    }
                    break;
            }
        }
        try {
            posicion = new Posicion(nuevaFila, nuevaLetra);
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
        }
    }

    public String toString() { // Apartado 6
        return "color=" + color + ", posicion=(fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ")";
    }
}
