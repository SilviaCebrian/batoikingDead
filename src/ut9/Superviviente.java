/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut9;

import java.awt.Point;

/**
 *
 * @author Silvia
 */
public class Superviviente extends Personaje {

    /**
     * * Constantes públicas**
     */
    public static final String SIMBOLO = "S";

    /**
     * * Constantes privadas**
     */
    /* Puntos sumados cada vez que se pasa por una casilla nueva */
    private static final int INCREMENTO_PUNTOS = 10;

    //Constructor
    public Superviviente(Point puntoInicial) {
        super(puntoInicial);
    }

    /**
     * Dado un movimiento dado asignar que direccion es
     *
     * @param movimiento
     */
    public void actualizaDireccion(String movimiento) {

        if (Movimientos.TECLA_ARRIBA.equals(movimiento)) {
            direccion = Movimientos.ARRIBA;
        } else if (Movimientos.TECLA_ABAJO.equals(movimiento)) {
            direccion = Movimientos.ABAJO;
        } else if (Movimientos.TECLA_IZQUIERDA.equals(movimiento)) {
            direccion = Movimientos.IZQUIERDA;
        } else if (Movimientos.TECLA_DERECHA.equals(movimiento)) {
            direccion = Movimientos.DERECHA;
        } else {
            direccion = Movimientos.CENTRO;
        }
    }

    /**
     * Dado el tablero recoge un objeto si el superviviente pasa por encima
     *
     * @param tablero
     * @return
     */
    public int recogeItemSiEstasSobreEl(Tablero tablero) {

        // Actualiza el estado de las casillas añadiendo puntos si es necesario
        if (tablero.casillaHayItem(this.posicion)) {
            tablero.vaciaCasilla(this.posicion);
            int[] puntosAObtener = Partida.puntosAObtener();
            int vidas=Partida.getVidas();
            int[] objetosObtenidos = Partida.getObjetosObtenidos();
            int objeto = Partida.objetoAlAzar(puntosAObtener,objetosObtenidos);
            int puntos = Partida.puntosObtenidos(objeto);
            return puntos;
        }

        return 0;
    }



}
