package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.damas.modelo.*;

public class Consola {

    //Constructor de la clase
    private Consola(){ // Apartado 5.2

    }

    public static void mostrarMenu(){ //Apartado 5.3
        System.out.println("------------------------------------------");
        System.out.println("--              MENÚ DEL JUEGO          --");
        System.out.println("------------------------------------------");
        System.out.println("--                                      --");
        System.out.println("-- 1. CREAR DAMA POR DEFECTO            --");
        System.out.println("-- 2. CREAR DAMA ELIGIENDO COLOR        --");
        System.out.println("-- 3. MOVER                             --");
        System.out.println("-- 4. SALIR                             --");
        System.out.println("------------------------------------------");
        System.out.println();
    }

    public static int elegirOpcionMenu(){ //Apartado 5.4
        int opcionMenu = 1;

        do {
            System.out.print("Selecciona que opción quiere realizar: ");
            opcionMenu = Entrada.entero();
            if(opcionMenu < 0 || opcionMenu > 4){
                System.out.println("ERROR: Opción incorrecta");
            }
        } while(opcionMenu <= 0 || opcionMenu > 4);

        return opcionMenu;
    }

    public static Color elegirColor(){ // Apartado 5.5 (elegirOpcion)

        String opcionMenu = " ";

        do {
            System.out.print("Selecciona el color de la ficha (Blanco/Negro): ");
            opcionMenu = Entrada.cadena();
            if(!opcionMenu.equals("Blanco") && !opcionMenu.equals("Negro")){
                System.out.println("ERROR: Opción incorrecta");
            }
        } while(!opcionMenu.equals("Blanco") && !opcionMenu.equals("Negro"));

        if(opcionMenu.equals("Blanco")){
           return Color.BLANCO;
        }else{
            return Color.NEGRO;
        }
    }

    public static void mostrarMenuDirecciones(){ //Apartado 5.6
        System.out.println("------------------------------------------");
        System.out.println("--              DIRECCIONES             --");
        System.out.println("------------------------------------------");
        System.out.println("--                                      --");
        System.out.println("-- 1. NORESTE                           --");
        System.out.println("-- 2. SURESTE                           --");
        System.out.println("-- 3. SUROESTE                          --");
        System.out.println("-- 4. NOROESTE                          --");
        System.out.println("------------------------------------------");
        System.out.println();
    }

    public static Direccion elegirDireccion(){ //Apartado 5.7
        int opcionMenu = 1;

        do {
            System.out.print("Selecciona que opción quiere realizar: ");
            opcionMenu = Entrada.entero();
            if(opcionMenu < 0 || opcionMenu > 4){
                System.out.println("ERROR: Opción incorrecta");
            }
        } while(opcionMenu <= 0 || opcionMenu > 4);

        switch (opcionMenu){
            case 1:
                return Direccion.NORESTE;
            case 2:
                return Direccion.SURESTE;
            case 3:
                return Direccion.SUROESTE;
            case 4:
                return Direccion.NOROESTE;
            default:
                return null;
        }
    }

    public static int elegirPasos(){ //Apartado 5.8
        int numeroPasos = 1;

        do {
            System.out.print("Selecciona el numero de pasos: ");
            numeroPasos = Entrada.entero();
            if(numeroPasos <= 0){
                System.out.println("ERROR: Opción incorrecta");
            }
        } while(numeroPasos <= 0);

        return numeroPasos;
    }

    public static void despedirse(){ //Apartado 5.9
        System.out.println("------------------------------------------");
        System.out.println("--              GAME OVER               --");
        System.out.println("------------------------------------------");
        System.out.println("--                                      --");
        System.out.println("--   THANK YOU FOR PLAYING THIS GAME!   --");
        System.out.println("--   BUT OUR LADIES IS IN               --");
        System.out.println("--   ANOTHER CASTLE!                    --");
        System.out.println("--                                      --");
        System.out.println("------------------------------------------");
    }
}
