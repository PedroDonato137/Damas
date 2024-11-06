package org.iesalandalus.programacion.damas.modelo;

public class MainApp {

    private Dama ficha;  // Apartado 6.1

    private void ejecutarOpcion(int opcion){ //Apartado 6.2

        switch (opcion){
            case 1: // Apartado 6.3
                // Crear dama por defecto
                crearDamaDefecto();
            case 2:
                // Crear dama eligiendo el color
            case 3:
                // Mover
            case 4:
                // Salir
        }
    }
    private void crearDamaDefecto(){ // Apartado 6.3
        ficha = new Dama();
    }

}
