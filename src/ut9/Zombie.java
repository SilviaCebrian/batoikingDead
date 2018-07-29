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
public class Zombie extends Personaje {

    //Contantes
    private static final int MAX_INTENTOS_CAMBIO_DIRECCION_ALEATORIA = 3;
    private static final int MAX_INTENTOS_ELECCION_DIRECCION = 8;

    //Atributos
    private int idZombie;
    private String color;
    private String nombre;
    private int casillasRecorridas;
    private int direccionZF;

    //Constructor
    public Zombie(int idZombie, Point puntoInicial, String color, String nombre) {
        super(puntoInicial);
        this.color = color;
        this.nombre = nombre;

    }

    //Constructor apartir de otro zombie
    public Zombie(Zombie zombieACopiar, int direccion) {
        this(zombieACopiar.idZombie, zombieACopiar.posicion, zombieACopiar.color, zombieACopiar.nombre);
        super.direccion = direccion;

    }

    /**
     * Obtiene el color del Zombie para usarlo en el mapa al imprimir
     *
     * @return
     */
    private String getColor() {
        return this.color;
    }

    /**
     * Genera una dirección aleatoria para el zombie dado, e intenta cambiarla
     * de dirección 4 veces y si en esa dirección no se puede mover intenta
     * otras 4 pero ahora con todas las direcciones posibles. Se tendrá en
     * cuenta a los otros zombies.
     *
     * @param posicionCasillaDeTablero
     * @param tablero
     * @param zombies
     * @return 
     */
    public boolean esCasillaTableroTransitablePorZombie(Point posicionCasillaDeTablero, Tablero tablero, Zombie[] zombies) {
        boolean casilllaEsPisable = tablero.casillaEsTransitable(posicionCasillaDeTablero);

        for (int i = 0; i < zombies.length; i++) {

            for (int j = 0; j < zombies.length; j++) {
                if (this.idZombie != i && (zombies[j].estaEnPunto(posicionCasillaDeTablero))) {
                    casilllaEsPisable = false;
                    break;
                }
            }

        }
        return casilllaEsPisable;
    }

    /**
     * Gestiona el movimiento hacia el superviviente busca el camino más corto y
     * se mueve
     *
     * @param tablero
     * @param zombies
     * @param superviviente
     */
    public void muevete(Tablero tablero, Zombie[] zombies, Superviviente superviviente) {

        // Se actualiza la próxima dirección del zombie
        hayRutaASuperviviente(tablero, zombies, superviviente, 0);
        mueveteSiEsPosible(tablero);

        System.out.println("");
        // Se mueve al zombie si procede

    }

    /**
     * Metodo que permite calcular la ruta más corta hacia el superviviente,
     * generando copias del Zombie que se va a mover hasta llegar a él. Usa
     * método recursivo, de esta manera cuando acaba obtiene la primera
     * dirección a la que se movió el zombieFantasma para llegar al
     * superviviente y se le asigna al Zombie en cuestión que se moverá a esa
     * dirección
     *
     * @param tablero
     * @param zombies
     * @param superviviente
     * @param casillasRecorridas
     * @return
     */
    public boolean hayRutaASuperviviente(Tablero tablero, Zombie[] zombies, Superviviente superviviente, int casillasRecorridas) {
        boolean hayRuta = false;

        if (super.posicion.equals(superviviente.getPosicion())) {//CASO 1
            System.out.println(this.getColor() + this.nombre + " está a " + (casillasRecorridas - 1) + " casillas" + Colores.COLOR_RESET);
            zombies[this.idZombie].casillasRecorridas = casillasRecorridas;//Si quisiera luego imprimir este valor
            //Debo coger el zombie original que lo obtenedre con la id, ya que todo zombie que se copia mantiene
            //mantiene la id inicial
            return true;
        } else {
            casillasRecorridas++;
            tablero.modificarTransitibilidadEnCasilla(super.posicion, false);
            SegmentosZombieFantasma segmentosZombie = new SegmentosZombieFantasma(this, superviviente);

            for (int i = 0; i < segmentosZombie.getLongitud(); i++) {

                if (this.ZFpuedeMoverse(tablero, segmentosZombie.getSegmento(i), casillasRecorridas, zombies, segmentosZombie, i)) {
                    this.direccionZF = segmentosZombie.getSegmento(i).getZombieFantasma().getDireccion();
                    //RECURSIVO
                    if (segmentosZombie.getSegmento(i).getZombieFantasma().hayRutaASuperviviente(tablero, zombies, superviviente, casillasRecorridas)) {
                        super.direccion = this.direccionZF;
                        tablero.modificarTransitibilidadEnCasilla(super.posicion, true);
                        return true;
                    }

                } else if (tablero.tipoCasilla(segmentosZombie.getSegmento(i).getZombieFantasma().getPosicion()) != Casilla.TIPO_LIMITE) {
                    tablero.modificarTransitibilidadEnCasilla(segmentosZombie.getSegmento(i).getZombieFantasma().getPosicion(), true);
                    hayRuta = false;
                }

            }
            if (hayRuta == false) {
                tablero.modificarTransitibilidadEnCasilla(super.posicion, true);
                hayRuta = false;
            }

            return hayRuta;
        }

    }

    /**
     * Comprueba que el Zombie puede moverse tiene en cuenta si hay otro zombie
     * y las paredes
     *
     * @param tablero
     * @param segmento
     * @param casillasRecorridas
     * @param zombies
     * @param segmentosZombie
     * @param i
     * @return
     */
    private boolean ZFpuedeMoverse(Tablero tablero, SegmentoZombieFantasma segmento, int casillasRecorridas, Zombie[] zombies, SegmentosZombieFantasma segmentosZombie, int i) {
        boolean posicionValida = false;

        Point posicionZF = new Point(segmento.getZombieFantasma().getPosicion());

        posicionValida = tablero.casillaEsTransitable(posicionZF);

        if (casillasRecorridas == 1) {
            posicionValida = this.esCasillaTableroTransitablePorZombie(segmentosZombie.getSegmento(i).getZombieFantasma().getPosicion(), tablero, zombies);

        }

        return posicionValida;
    }


}
