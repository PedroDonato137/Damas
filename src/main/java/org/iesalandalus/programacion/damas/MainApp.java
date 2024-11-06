package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.*;

public class MainApp {

    private Dama ficha;  // Apartado 6.1

    public static void main(String[] args) { // Apartado 6.7

        int opcionMenu = 0;

        Consola.mostrarMenu();
        do{
            opcionMenu = Consola.elegirOpcionMenu();
        } while (opcionMenu != 4);

        Consola.despedirse();
    }

    private void ejecutarOpcion(int opcion){ //Apartado 6.2

        switch (opcion){
            case 1: // Apartado 6.3
                // Crear dama por defecto
                crearDamaDefecto();
            case 2:
                // Crear dama eligiendo el color
                crearDamaColor();
            case 3:
                // Mover
                mover();
            case 4:
                // Salir
                Consola.despedirse();
        }
    }
    private void crearDamaDefecto(){ // Apartado 6.3
        ficha = new Dama();
    }

    private void crearDamaColor(){ // Apartado 6.4

        Color colorSeleccionado = Consola.elegirColor();
        ficha = new Dama(colorSeleccionado);
    }

    private void mover(){ // Apartado 6.5

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

    public void mostrarDama(){ // Apartado 6.6

        if (ficha != null){
            String datosDama = ficha.toString();
            System.out.println(datosDama);
        }else{
            System.out.println("ERROR: La Dama no esta creada");
        }
    }

}
