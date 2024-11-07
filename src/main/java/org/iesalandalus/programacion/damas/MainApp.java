package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.*;

/**
 * Clase principal MainApp: En esta clase se ejecuta todo el contenido del programa
 *
 * @author Pedro Donato García López
 */

public class MainApp {

    private static Dama ficha;  // Apartado 6.1

    /**
     * Método estático main: Cuerpo principal del programa. Muestra el menú del juego y va ejecutándolas hasta que
     * el usuario quiera salir
     *
     * @param args
     */
    public static void main(String[] args) { // Apartado 6.7

        int opcionMenu = 0;

        do{
            Consola.mostrarMenu();
            opcionMenu = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcionMenu);
        } while (opcionMenu != 4);
    }

    /**
     * Método estático ejecutarOpcion: Este método recibe un entero con la opción seleccionado en otro método.
     * Ejecuta una opción dependiendo del entero
     *
     * @param opcion Opción del menú
     */

    private static void ejecutarOpcion(int opcion){ //Apartado 6.2

        switch (opcion){
            case 1: // Apartado 6.3
                // Crear dama por defecto
                crearDamaDefecto();
                mostrarDama();
                break;
            case 2:
                // Crear dama eligiendo el color
                crearDamaColor();
                mostrarDama();
                break;
            case 3:
                // Mover
                if(ficha != null){
                    mover();
                    mostrarDama();
                }else{
                    System.out.println("ERROR: Dama no creada");
                }
                break;
            case 4:
                // Salir
                Consola.despedirse();
                break;
        }
    }

    /**
     * Método estático crearDamaDefecto: Este método instancia un objeto nuevo de tipo Dama con el constructor por
     * defecto de la clase Dama
     */

    private static void crearDamaDefecto(){ // Apartado 6.3

        ficha = new Dama();
    }

    /**
     * Método estático crearDamaColor: Este método instancia un objeto nuevo de tipo dama
     * del color que se obtiene del método elegirColor de la clase Consola
     */
    private static void crearDamaColor(){ // Apartado 6.4

        Color colorSeleccionado = Consola.elegirColor();
        ficha = new Dama(colorSeleccionado);
    }

    /**
     * Método estático mover: Muestra el menú de la clase Consola con las distintas direcciones que se pueden elegir,
     * comprueba si la dama es especial, si lo es, pide los pasos y cambia ese total de pasos, si no lo es, solo hace 1 paso
     */
    private static void mover(){ // Apartado 6.5

        int pasos = 1; // Por defecto es 1, si no es dama especial hace solo 1 paso
        Consola.mostrarMenuDirecciones();
        Direccion direccionSeleccionada = Consola.elegirDireccion();

        if(ficha.getDamaespecial()){
            pasos = Consola.elegirPasos();
        }

        try {
            ficha.mover(direccionSeleccionada, pasos);
        }
        catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método estático mostrarDama: Comprueba si la ficha esta creada, si lo está,
     * muestra la información de su posición y su color
     */
    public static void mostrarDama(){ // Apartado 6.6

        if (ficha != null){
            String datosDama = ficha.toString();
            System.out.println(datosDama);
        }else{
            System.out.println("ERROR: La Dama no esta creada");
        }
    }

}
