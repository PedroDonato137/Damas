package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.io.FileNotFoundException;

public class MainApp {

    private Dama ficha = new Dama();  // Apartado 6.1

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


}
