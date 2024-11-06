package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.*;

public class MainApp {

    private static Dama ficha;  // Apartado 6.1

    public static void main(String[] args) { // Apartado 6.7

        int opcionMenu = 0;

        Consola.mostrarMenu();
        do{
            opcionMenu = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcionMenu);
        } while (opcionMenu != 4);

    }

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
                mover();
                mostrarDama();
                break;
            case 4:
                // Salir
                Consola.despedirse();
                break;
        }
    }
    private static void crearDamaDefecto(){ // Apartado 6.3

        ficha = new Dama();
    }

    private static void crearDamaColor(){ // Apartado 6.4

        Color colorSeleccionado = Consola.elegirColor();
        ficha = new Dama(colorSeleccionado);
    }

    private static void mover(){ // Apartado 6.5

        int pasos = 1;
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

    public static void mostrarDama(){ // Apartado 6.6

        if (ficha != null){
            String datosDama = ficha.toString();
            System.out.println(datosDama);
        }else{
            System.out.println("ERROR: La Dama no esta creada");
        }
    }

}
