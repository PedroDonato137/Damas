package org.iesalandalus.programacion.damas.modelo;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    //Constructor de la clase
    private Consola(){ // Apartado 5.1

    }

    public void mostrarMenu(){
        System.out.println("------------------------------------------");
        System.out.println("--              MENÚ DEL JUEGO          --");
        System.out.println("------------------------------------------");
        System.out.println("--                                      --");
        System.out.println("-- 1. Crear dama por defecto            --");
        System.out.println("-- 2. Crear dama eligiendo color        --");
        System.out.println("-- 3. Mover                             --");
        System.out.println("-- 4. Salir                             --");
        System.out.println("------------------------------------------");
        System.out.println();
    }

    public int elegirOpcionMenu(){
        int opcionMenu = 0;

        do {
            System.out.print("Selecciona el numero del menú del juego: ");
            opcionMenu = Entrada.entero();
            if(opcionMenu < 0 || opcionMenu > 4){
                System.out.println("ERROR: Opción incorrecta");
            }
        } while(opcionMenu <= 0 || opcionMenu > 4);

        return opcionMenu;
    }
}
