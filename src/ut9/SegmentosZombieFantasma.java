/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut9;

/**
 *
 * @author mati
 */
public class SegmentosZombieFantasma {

    private static final int NUM_SEGMENTOS = 4;
    private SegmentoZombieFantasma[] segmentos;

    /**
     * Se crean cuatro segmentos, uno por cada dirección donde el zombie puede
     * moverse
     *
     * @param zombie
     * @param superviviente
     */
    public SegmentosZombieFantasma(Zombie zombie, Superviviente superviviente) {

        // Se construyen los cuatro posibles segmentos (se estima la distancia en el proceso)
        this.segmentos = new SegmentoZombieFantasma[NUM_SEGMENTOS];
        segmentos[0] = new SegmentoZombieFantasma(zombie, Movimientos.ARRIBA, superviviente);
        segmentos[1] = new SegmentoZombieFantasma(zombie, Movimientos.ABAJO, superviviente);
        segmentos[2] = new SegmentoZombieFantasma(zombie, Movimientos.IZQUIERDA, superviviente);
        segmentos[3] = new SegmentoZombieFantasma(zombie, Movimientos.DERECHA, superviviente);

        // Se ordenan los segmentos según su método "menor"
        ordenarBurbuja();
    }

    /**
     * Número de segmentos zombie fantasma
     *
     * @return
     */
    public int getLongitud() {

        return this.segmentos.length;
    }

    /**
     * Obtiene un segmento dado
     *
     * @param indiceSegmento
     * @return
     */
    public SegmentoZombieFantasma getSegmento(int indiceSegmento) {

        return this.segmentos[indiceSegmento];
    }

    /**
     * Método de burbuja
     */
    private void ordenarBurbuja() {
        SegmentoZombieFantasma aux;
        boolean cambio = true;

        int ultimo = segmentos.length - 1;
        for (int i = 1; i <= ultimo && cambio; i++) {
            cambio = false;
            for (int j = 0; j <= ultimo - i; j++) {
                if (!segmentos[j].menor(segmentos[j + 1])) {
                    cambio = true;
                    aux = segmentos[j + 1];
                    segmentos[j + 1] = segmentos[j];
                    segmentos[j] = aux;
                }
            }
        }
    }

}
