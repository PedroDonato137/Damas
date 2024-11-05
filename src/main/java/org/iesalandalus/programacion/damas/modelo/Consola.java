package org.iesalandalus.programacion.damas.modelo;

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
    }
}
