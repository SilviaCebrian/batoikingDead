/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut9;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Silvia
 */
public final class Movimientos {

    /**
     * Constantes para los 4 movimientos posibles
     */
    public static final String TECLA_ARRIBA = "w";
    public static final String TECLA_ABAJO = "s";
    public static final String TECLA_IZQUIERDA = "a";
    public static final String TECLA_DERECHA = "d";

    /**
     * Constantes para las 5 direcciones posibles
     */
    public static final int CENTRO = -1;
    public static final int ARRIBA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int DERECHA = 3;
    public static final int NUM_DESPLAZAMIENTOS = 4;

    //Atributo
    private static String movimientoAnterior = "w";

    /**
     * Crea un movimiento aleatorio
     *
     * @return un número entre 0 y 3 que representa a los cuatro tipos de
     * movimiento
     */
    public static int creaMovimientoAleatorio() {

        return new Random(System.currentTimeMillis()).nextInt(Movimientos.NUM_DESPLAZAMIENTOS);
    }

    /**
     * Lee un movimiento introducido por el usuario, forzando a una nueva
     * lectura si el movimiento no es correcto
     *
     * @param scanner
     * @return El movimiento leido
     */
    public static String leerMovimientoCorrecto(Scanner scanner) {

        // Pide al usuario por pantalla el movimiento
        boolean esMovimientoCorrecto;

        String movimiento = "";

        do {
            System.out.print("Introduce el movimiento (W/S/A/D - h para salir): ");
            movimiento = scanner.nextLine();
            System.out.println("");
            if (movimiento.length() == 0) {
                movimiento = movimientoAnterior;
            }
            esMovimientoCorrecto = comprobarMovimiento(movimiento);

            if (!esMovimientoCorrecto) {
                System.out.println("Error. Movimiento desconocido.");
            }

        } while (!esMovimientoCorrecto);
        return movimiento;

    }

    /**
     * Comprueba que el movimiento proporcionado sea correcto
     *
     * @param movimientoTexto Movimiento en formato texto a comprobar
     * @return true si es correcto, false en caso contrario
     */
    public static boolean comprobarMovimiento(String movimientoTexto) {
        int movimiento;
        boolean movimientoValido = false;
        if (movimientoTexto == " ") {
            movimiento = movimientoANumero(movimientoAnterior);
            movimientoValido = movimiento != Movimientos.CENTRO;
        } else {
            movimiento = movimientoANumero(movimientoTexto);
            movimientoValido = movimiento != Movimientos.CENTRO;
        }
        return movimientoValido;
    }

    /**
     * Transforma un movimiento en formato texto a formato numérico (del 0 al 3)
     *
     * @param movimiento
     * @return
     */
    private static int movimientoANumero(String movimiento) {

        if (TECLA_ARRIBA.equals(movimiento)) {
            movimientoAnterior = TECLA_ARRIBA;
            return ARRIBA;
        } else if (TECLA_ABAJO.equals(movimiento)) {
            movimientoAnterior = TECLA_ABAJO;
            return ABAJO;
        } else if (TECLA_IZQUIERDA.equals(movimiento)) {
            movimientoAnterior = TECLA_IZQUIERDA;
            return IZQUIERDA;
        } else if (TECLA_DERECHA.equals(movimiento)) {
            movimientoAnterior = TECLA_DERECHA;
            return DERECHA;
        } else {
            return CENTRO;
        }
    }
}
