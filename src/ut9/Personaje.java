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
public abstract class Personaje {

    //Atributos
    protected Point posicionInicial;
    protected Point posicion;
    protected int direccion;

    //Constructor
    public Personaje(Point puntoInicial) {

        this.posicion = new Point(puntoInicial);
        this.posicionInicial = new Point(this.posicion);
        this.direccion = Movimientos.CENTRO;

    }

    //Gets y sets
    public Point getPosicion() {

        return this.posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = new Point(posicion);
    }

    public int getDireccion() {
        return this.direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    /**
     * Comprueba si el personaje se encuentra o no en el punto dado
     *
     * @param punto
     * @return
     */
    public boolean estaEnPunto(Point punto) {

        return punto.equals(this.posicion);
    }

    /**
     * Reinicia la posicion del personaje a la inicial
     */
    public void reiniciaPosicion() {

        this.posicion.setLocation(this.posicionInicial);
    }

    /**
     * Dado dos personajes compara si coinciden en posicion
     *
     * @param zombie
     * @param superviviente
     * @return
     */
    public boolean coinciden(Point zombie, Point superviviente) {

        return zombie.equals(superviviente);
    }

    /**
     * Dado el tablero el personaje se mueve con la direccion que tiene guardada
     * Una vez creada la nueva posicion comprueba si es transitable o no
     *
     * @param tablero
     */
    protected void mueveteSiEsPosible(Tablero tablero) {

        Point nuevaPosicion = nuevaPosicion();
        if (tablero.casillaEsTransitable(nuevaPosicion)) {
            this.posicion.setLocation(nuevaPosicion);
        }

    }

    /**
     * Genera una posicion nueva en funcion de la direccion que tiene
     *
     * @return
     */
    protected Point nuevaPosicion() {

        int xNuevaPosicion = this.posicion.x;
        int yNuevaPosicion = this.posicion.y;

        // Se mueve
        switch (this.direccion) {

            case Movimientos.ARRIBA:

                xNuevaPosicion = xNuevaPosicion - 1;
                break;

            case Movimientos.ABAJO:

                xNuevaPosicion = xNuevaPosicion + 1;
                break;

            case Movimientos.IZQUIERDA:

                yNuevaPosicion = yNuevaPosicion - 1;
                break;

            case Movimientos.DERECHA:

                yNuevaPosicion = yNuevaPosicion + 1;
                break;
        }

        return new Point(xNuevaPosicion, yNuevaPosicion);
    }

}
