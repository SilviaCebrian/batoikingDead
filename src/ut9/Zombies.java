/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut9;

import java.awt.Point;

/**
 *
 * @author silvi
 */
public class Zombies {

    //Constantes
    public static final String SIMBOLO = " ";

    //Atributos
    private Zombie[] zombies;
    private String nombreZombies[] = {"Pancracio", "Gustavo", "Manuela"};
    private String color[] = {Colores.ROJO, Colores.VERDE, Colores.NARANJA};
    private final Point[] posicionesAnteriores = new Point[3];
 
    

    
    //Consturctor
    public Zombies(Point[] posicionesIniciales) {

        this.zombies = new Zombie[posicionesIniciales.length];

        for (int i = 0; i < posicionesIniciales.length; i++) {
            this.zombies[i] = new Zombie(i, posicionesIniciales[i], color[i], nombreZombies[i]);
        }
    }

    /**
     * Permite obtener la primera letra del nombre del zombie y asignarselo como simbolo en el mapa
     * @param posicionArrayZombie
     * @return 
     */
    public String obtenerSimboloZombie(int posicionArrayZombie) {
        

         return this.color[posicionArrayZombie] + this.nombreZombies[posicionArrayZombie].substring(0, 1)+Colores.COLOR_RESET;
    }

    /**
     * Mueve a los zombies en función de las casillas del tablero, los otros
     * zombies, el superviviente
     *
     * @param superviviente
     * @param tablero
     */
    public void moveros(Superviviente superviviente, Tablero tablero) {

        for (int i = 0; i < this.zombies.length; i++) {
            // Si no está encima del protagonista, se mueve

            if (!this.zombies[i].coinciden(zombies[i].getPosicion(), superviviente.getPosicion())) {
                // Se mueve el zombie indicado por su indice
                this.zombies[i].muevete(tablero, zombies, superviviente);

            }
        }
    }

    /**
     * Poner false la casilla en la que está el zombie antes de moverse por
     * primera vez porque si no. cuando se mueva por segunda vez puede volver a
     * la posicion inicial
     *
     * @param tablero
     */
    public void modificarTransitibilidadEnCasillaPasadaPorZombie(Tablero tablero, Boolean estado) {

        for (int i = 0; i < this.zombies.length; i++) {
            posicionesAnteriores[i] = new Point(zombies[i].getPosicion());
            tablero.modificarTransitibilidadEnCasilla(posicionesAnteriores[i], estado);
        }
    }

    /**
     * Comprueba si alguno de los zombies coincide con la posición del
     * superviviente
     *
     * @param superviviente
     * @return
     */
    public boolean algunZombieCoincideConSuperviviente(Superviviente superviviente) {

        // Comprueba si algún zombie ha alcanzado al superviviente
        for (int i = 0; i < this.zombies.length; i++) {

            if (this.zombies[i].coinciden(zombies[i].posicion, superviviente.posicion)) {

                return true;
            }
        }

        return false;
    }

    /**
     * Comprueba si alguno de los zombies coincide con la posición del
     * superviviente
     *
     * @param punto
     * @return
     */
    public boolean algunZombieEstaEnPunto(Point punto) {

        // Comprueba si algún zombie ha alcanzado al superviviente
        for (int i = 0; i < this.zombies.length; i++) {

            if (zombies[i].estaEnPunto(punto)) {

                return true;
            }
        }

        return false;
    }

    public int obtenerZombie(Point punto) {
        int zombie = 0;
        for (int i = 0; i < this.zombies.length; i++) {

            if (zombies[i].estaEnPunto(punto)) {

                zombie = i;
            }
        }
        return zombie;
    }

    /**
     * obtiene el número de zombies de la partida
     *
     * @return el número de zombies
     */
    public int numZombies() {

        return this.zombies.length;
    }

    /**
     * Reinicia las posiciones de los zombies a la inicial
     */
    public void reiniciaPosiciones() {

        for (int i = 0; i < this.zombies.length; i++) {

            this.zombies[i].reiniciaPosicion();
        }
    }

}
