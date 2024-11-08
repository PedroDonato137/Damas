package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

/**
 * Clase Dama: Esta clase sirve para definir cómo será una Dama
 *
 * @author Pedro Donato García López
 */

public class Dama {

    private Color       color;
    private Posicion    posicion;
    private boolean     esDamaEspecial;

    // Valores iniciales definidos por defecto
    private static final Color   COLOR_INICIAL        = Color.BLANCO;
    private static final Boolean DAMAESPECIAL_INICIAL = false;

    /**
     * Constructor de la clase Dama (por defecto): Crea una dama, simpre blanca, con una posición aleatoria valida
     * y siempre como dama normal
     */
    public Dama() {
        setColor(COLOR_INICIAL);
        setPosicion(crearPosicionInicial());
        setEsDamaEspecial(DAMAESPECIAL_INICIAL);
    }

    /**
     * Constructor de la clase Dama: Crea una dama, del color que recibe, con una posición aleatoria valida
     * y siempre como dama normal
     *
     * @param color El color de la dama
     */
    public Dama(Color color) {
        Objects.requireNonNull(color, "ERROR: El color no puede ser nulo.");
        setColor(color);
        setPosicion(crearPosicionInicial());
        setEsDamaEspecial(DAMAESPECIAL_INICIAL);
    }

    /**
     * Método getColor: Devuelve el color de la dama
     *
     * @return color El color de la dama
     */

    public Color getColor() {
        return color;
    }

    /**
     * Método getPosicion: Devuelve la posición completa de la dama
     *
     * @return posicion La posición de la dama
     */
    public Posicion getPosicion() {
        return posicion;
    }


    /**
     * Método getDamaEspecial: Devuelve si la dama es especial o no
     *
     * @return esDamaEspecial Si es dama especial -> True || Si no lo es -> False
     */
    public Boolean getDamaespecial(){
        return esDamaEspecial;
    }

    /**
     * Método setColor: Asigna el color a la dama
     *
     * @param color El color de la dama
     */
    private void setColor(Color color) {
        this.color = color;
    }

    /**
     * Método setPosicion: Asigna una posición a la dama
     *
     * @param posicion La posición de la dama
     */
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    /**
     * Método setEsDamaEspecial: Asigna si es o no dama especial
     *
     * @param esDamaEspecial Si es o no dama especial
     */
    public void setEsDamaEspecial(Boolean esDamaEspecial){
        this.esDamaEspecial = esDamaEspecial;
    }

    /**
     * Método crearPosicionInicial: Este método crea una posición aleatoria valida usando el método Math.random()
     *
     * @return posiconAleatoria Una posición aleatoria valida
     */
    private Posicion crearPosicionInicial() { // Apartado 4.1

        int  posicionFila     = 0;
        int  columnaAleatoria = (int) Math.floor(Math.random() * 4) + 1; // Genera un número aleatorio desde 1 a 4
        char posicionColumna  = ' ';

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

    /**
     * Método mover: Este método mueve la ficha creada por el tablero, también cambia el atriburo de la clase dama de esDamaEspecial
     * a true cuando la ficha llega a la ultima fila del tablero
     *
     * @param direccion Una dirección donde va a ir la ficha
     * @param pasos Número de pasos que va a avanzar la ficha
     * @throws OperationNotSupportedException Validación del movimiento
     */
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {

        int  nuevaFila  = posicion.getFila();
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
                    setEsDamaEspecial(true);
                }
            } else{
                throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
            }
        } else if (color.toString().equalsIgnoreCase("Negro")) {
            if (direccion.toString().equalsIgnoreCase("SURESTE") || direccion.toString().equalsIgnoreCase("SUROESTE")) { // Apartado 5.4
                nuevaFila--;
                if (nuevaFila == 1) { // Apartado 5.3
                    setEsDamaEspecial(true);
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
                        default:
                            nuevaLetra = ' ';
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
                        default:
                            nuevaLetra = ' ';
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


    /**
     *Método toString: Devuelve la información de la dama completa
     *
     * @return Una cadena de carecteres con el color y la posición
     */
    public String toString() { // Apartado 6
        return "color=" + color + ", posicion=(fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ")";
    }
}
