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
public class Tablero {

    //Atributo
    private Casilla[][] casillas;

    //Constructor
    public Tablero(int[][] casillasEnteros) {

        this.casillas = new Casilla[casillasEnteros.length][casillasEnteros[0].length];

        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {

                this.casillas[i][j] = new Casilla(casillasEnteros[i][j]);
            }
        }
    }

    /**
     * Comprueba si hay items en el tablero
     *
     * @return true si hay al menos uno, false si no hay ninguno
     */
    public boolean hayItems() {

        for (int i = 0; i < this.casillas.length; i++) {

            for (int j = 0; j < this.casillas[i].length; j++) {

                if (this.casillas[i][j].hayItem()) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Comprueba si no hay un límite en la casilla del tablero que se encuentre
     * en el punto dado
     *
     * @param punto Posicion casilla a analizar
     * @return true si no hay un límite en esa casilla, o false en caso
     * contrario
     */
    public boolean casillaEsTransitable(Point punto) {
        boolean soyTransitable = false;
        if (puntoPerteneceATablero(punto)) {
            soyTransitable = this.casillas[punto.x][punto.y].esTransitable();
        }
        return soyTransitable;

    }

    /**
     * Dado un Point comprueba que este se encuentra dentro del tablero y
     * obtiene la casilla que se encuentra en ese punto devolviendo el tipo de
     * esta.
     *
     * @param punto
     * @return
     */
    public int tipoCasilla(Point punto) {
        int noPared = 1;
        if (puntoPerteneceATablero(punto)) {
            return this.casillas[punto.x][punto.y].getTipo();
        }
        return noPared;
    }

    /**
     * Dado un punto y un True/False establece esa casilla como transitable o no
     *
     * @param punto
     * @param nuevoValor
     */
    public void modificarTransitibilidadEnCasilla(Point punto, boolean nuevoValor) {
        if (puntoPerteneceATablero(punto)) {
            this.casillas[punto.x][punto.y].setSoyTransitable(nuevoValor);
        }
    }

    /**
     * Comprueba si hay un item en la casilla del tablero que se encuentre en el
     * punto dado
     *
     * @param punto Posicion casilla a analizar
     * @return true si hay un item en esa casilla, o false en caso contrario
     */
    public boolean casillaHayItem(Point punto) {

        if (puntoPerteneceATablero(punto)) {
            return this.casillas[punto.x][punto.y].hayItem();
        }

        return false;
    }

    /**
     * Vacia la casilla del tablero que se encuentre en el punto dado
     *
     * @param punto Posicion casilla a analizar
     */
    public void vaciaCasilla(Point punto) {

        if (puntoPerteneceATablero(punto)) {
            this.casillas[punto.x][punto.y].vaciaCasilla();
        }
    }

    /**
     * Transforma a texto la casilla del tablero que se encuentre en el punto
     * dado
     *
     * @param punto Posicion casilla a analizar
     * @return el texto de la casilla indicada
     */
    public String casillaATexto(Point punto) {

        if (puntoPerteneceATablero(punto)) {
            return this.casillas[punto.x][punto.y].casillaATexto();
        }

        return null;
    }

    /**
     * Devuelve el número de filas del tablero
     *
     * @return el número de filas
     */
    public int numFilas() {

        return this.casillas.length;
    }

    /**
     * Devuelve el número de columnas de la fila dada
     *
     * @param indiceFila
     * @return el número de columnas
     */
    public int numColumnas(int indiceFila) {

        return this.casillas[indiceFila].length;
    }

    /**
     * Comprueba si el punto es valido para el tablero
     *
     * @return true si la coordenada es adecuada para el array dado
     */
    private boolean puntoPerteneceATablero(Point punto) {

        return punto.x >= 0 && punto.y >= 0 && punto.x < this.casillas.length && punto.y < this.casillas[punto.x].length;
    }

}
