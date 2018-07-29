/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut9;

import java.awt.Point;

/**
 *
 * @author mati
 */
public class SegmentoZombieFantasma {

    private Zombie zombieFantasma;
    private int direccionZombie;
    private Superviviente superviviente;

    /**
     * Constructor del segmento
     *
     * @param zombieFantasma
     * @param direccionZombie
     * @param superviviente
     */
    public SegmentoZombieFantasma(Zombie zombieFantasma, int direccionZombie, Superviviente superviviente) {

        Zombie nuevoZombieFantasma = clonaZombieFantasmaEnDireccion(zombieFantasma, direccionZombie);

        this.zombieFantasma = nuevoZombieFantasma;
        this.direccionZombie = direccionZombie;
        this.superviviente = superviviente;
    }

    /**
     * Obtiene el zombie fantasma que se encuentra en un extremo del segmento
     *
     * @return la posición del zombie
     */
    public Zombie getZombieFantasma() {

        return this.zombieFantasma;
    }

    /**
     * Devuelve la dirección con la que se modificó la posición del zombie
     * fantasma al crear el segmento
     *
     * @return la dirección del zombie
     */
    public int getDireccionZombieFantasma() {
        return this.direccionZombie;
    }

    /**
     *
     * Comprueba si un segmento es menor que otro según la distancia entre el
     * zombie fantasma y el superviviente del segmento
     *
     * @param szf
     * @return true si la distancia es menor y false en caso contrario
     */
    public boolean menor(SegmentoZombieFantasma szf) {
        return calcularDistancia() < szf.calcularDistancia();
    }

    /**
     * Devuelve el distancia de un segmento zombie fantasma
     *
     * @return la distancia del segmento
     */
    private double calcularDistancia() {
        return Math.sqrt(Math.pow(this.superviviente.getPosicion().x - this.zombieFantasma.getPosicion().x, 2)
                + Math.pow(this.superviviente.getPosicion().y - this.zombieFantasma.getPosicion().y, 2));
    }

    /**
     * Crea una réplica del zombie dado, marcando su dirección inicial como la
     * indicaca
     *
     * @param zombieACopiar
     * @param direccionInicial
     * @return El nuevo zombie
     */
    private Zombie clonaZombieFantasmaEnDireccion(Zombie zombieACopiar, int direccionInicial) {

        Zombie nuevoZombieFantasma = new Zombie(zombieACopiar, direccionInicial);
        Point posicionNuevoZombieFantasma = nuevoZombieFantasma.nuevaPosicion();
        nuevoZombieFantasma.setPosicion(posicionNuevoZombieFantasma);

        return nuevoZombieFantasma;
    }

}
