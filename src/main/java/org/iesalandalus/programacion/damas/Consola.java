package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.damas.modelo.*;

/**
 * Clase de utilidades Consola: Esta clase sirve para mostrar menú
 * y seleccionar las opciones de dichos menús.
 *
 * @author Pedro Donato García López
 */

public class Consola {

    /**
     * Constructor de la clase Consola: Este contructor es privado, no deja instanciar ningun objeto de la clase
     */
    private Consola(){ // Apartado 5.2
        // No se permiten instanciar objetos de esta clase
    }

    /**
     * Método estático mostrarMenu: Este método muestra el menú principal con distintas opciones
     * (Crear dama por defecto, Crear dama eligiendo color, mover dama, y salir)
     */
    public static void mostrarMenu(){ //Apartado 5.3
        System.out.println("------------------------------------------");
        System.out.println("--            MENÚ DEL JUEGO            --");
        System.out.println("------------------------------------------");
        System.out.println("--                                      --");
        System.out.println("-- 1. CREAR DAMA POR DEFECTO            --");
        System.out.println("-- 2. CREAR DAMA ELIGIENDO COLOR        --");
        System.out.println("-- 3. MOVER DAMA                        --");
        System.out.println("-- 4. SALIR                             --");
        System.out.println("------------------------------------------");
        System.out.println();
    }

    /**
     * Método estático elegirOpcionMenu: Este método te pregunta que opción del método  mostrarMenu quieres hacer.
     * Repite hasta que la opción sea 4. SALIR
     *
     * @return Un entero con la opción del menú
     */
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

    /**
     * Método estático elegirColor: Este método te pregunta de que color quieres la ficha del juego,
     * te deja elegir entre dos opciones (Blanco y Negro), valida el color
     *
     * @return Un color seleccionado
     */

    public static Color elegirColor(){ // Apartado 5.5 (elegirOpcion)

        String opcionMenu = " ";

        do {
            System.out.print("Selecciona el color de la ficha (Blanco/Negro): ");
            opcionMenu = Entrada.cadena();
            if(!opcionMenu.equalsIgnoreCase("Blanco") && !opcionMenu.equalsIgnoreCase("Negro")){
                System.out.println("ERROR: Opción incorrecta");
            }
        } while(!opcionMenu.equalsIgnoreCase("Blanco") && !opcionMenu.equalsIgnoreCase("Negro"));

        if(opcionMenu.equalsIgnoreCase("Blanco")){
           return Color.BLANCO;
        }else{
            return Color.NEGRO;
        }
    }

    /**
     * Método estático mostrarMenuDirecciones: Este método muestra el menú con distintas Direcciones
     * (NORESTE, SURESTE, SUROESTE, NOROESTE)
     */
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

    /**
     * Método estático elegirDireccion: Este método te pregunta que opción del método mostrarMenuDirecciones quieres hacer.
     *
     * @return Una dirección escogida
     */
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

    /**
     *Método estático elegirPasos: Este método es para cuando la dama sea especial, se usa para preguntar el
     * número de pasos que quiere dar. Tiene que ser positivo el número
     *
     * @return Un entero con los pasos
     */
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

    /**
     * Método estático despedirse: Este método muestra un mensaje de despedida por consola
     */
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
