/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut9;

import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author silvi
 */
public class Partida {

    //Contante
    private static final int NUM_ZOMBIES = 3;
    //Atributos
    private Superviviente superviviente;
    private Zombies zombies;
    private Tablero tablero;
    private static int vidas;
    private static int puntos;
    private static int[] objetosObtenidos = new int[12];

    //Constructor
    public Partida() {

        /**
         * Configuración inicial del juego: escenario, posiciones iniciales de
         * los personajes, vidas y puntos
         */
        int[][] casillasEnteros = Escenarios.escenario1();
        this.tablero = new Tablero(casillasEnteros);

        Point puntoInicialSuperv = new Point(1, 1);
        this.superviviente = new Superviviente(puntoInicialSuperv);

        Point[] puntosInicialesZombies = new Point[NUM_ZOMBIES];

        puntosInicialesZombies[0] = new Point(1, 11);//MAPA1
        puntosInicialesZombies[1] = new Point(12, 8);//MAPA1
        puntosInicialesZombies[2] = new Point(5, 11);//MAPA1

        //puntosInicialesZombies[0] = new Point(1,5);//MAPA 2
        //puntosInicialesZombies[1] = new Point(2,8);//MAPA2
        //puntosInicialesZombies[2] = new Point(2,4);//MAPA2
        //puntosInicialesZombies[0] = new Point(1,5);//MAPA3
        //puntosInicialesZombies[1] = new Point(2,8);//MAPA3
        //puntosInicialesZombies[2] = new Point(3,4);//MAPA3
        this.zombies = new Zombies(puntosInicialesZombies);

        this.vidas = 10;
        this.puntos = 0;
    }

    public static int getVidas() {
        return vidas;
    }

    public static void setVidas(int vidas) {
        Partida.vidas = vidas;
    }

    public static int getPuntos() {
        return puntos;
    }

    public static void setPuntos(int puntos) {
        Partida.puntos = puntos;
    }

    public static int[] getObjetosObtenidos() {
        return objetosObtenidos;
    }

    public static void setObjetosObtenidos(int[] objetosObtenidos) {
        Partida.objetosObtenidos = objetosObtenidos;
    }

    /**
     * Inicia la partida
     */
    public void iniciarPartida() {

        boolean juegoAcabado;
        boolean quedanVidas = true;
        this.vidas = definirNumeroVidas();
        do {
            // Imprime las casillas del tablero

            mostrarEstadoPartida();

            Scanner scanner = new Scanner(System.in);
            String movimiento = Movimientos.leerMovimientoCorrecto(scanner);

            if (!movimiento.equals("h")) {

                puntos += realizaSiguienteMovimiento(movimiento);

                if (juegoPerdido()) {

                    vidas -= 1;

                    if (vidas <= 0) {
                        System.out.println("\n¡Has perdido!\n");
                        mostrarObjetos(this.objetosObtenidos);
                        quedanVidas = false;
                    } else {
                        System.out.println("\n¡Has perdido una vida!\n");

                        this.superviviente.reiniciaPosicion();
                        this.zombies.reiniciaPosiciones();
                    }
                }

                juegoAcabado = juegoGanado();

                if (juegoAcabado) {
                    System.out.println("\n¡Has ganado!\n");
                    mostrarObjetos(this.objetosObtenidos);
                }
            } else {
                juegoAcabado = true;
                System.out.println("\nAbandonaste. ¡Chao!\n");
            }

        } while (!juegoAcabado && quedanVidas);
    }

    public static int definirNumeroVidas() {
        System.out.println(Colores.AZUL + "Bienvenido al programa BatoikingDead");
        System.out.println(Colores.AZUL + "¿Cuantas vidas quieres tener?");
        System.out.println("");
        boolean valido = false;
        int numeroVidas = 0;
        Scanner teclado = new Scanner(System.in);
        while (!valido) {
            if (teclado.hasNextInt()) {
                numeroVidas = teclado.nextInt();
                valido = true;
            } else {
                System.out.println(Colores.RED + "Introduce un número entero");
                teclado.next();
            }
        }
        return numeroVidas;
    }

    /**
     * Realiza el siguiente movimiento del tablero, moviendo tanto a los zombies
     * como al superviviente.
     *
     * @param movimiento Movimiento del superviviente introducido por el usuario
     * @return Los posibles puntos obtenidos con el movimiento
     */
    private int realizaSiguienteMovimiento(String movimiento) {

        // Variable que almacenará los puntos obtenidos en el movimiento
        int puntosObtenidos;

        // Primero mueve al superviviente según tecla pulsada
        this.superviviente.actualizaDireccion(movimiento);
        this.superviviente.mueveteSiEsPosible(tablero);
        puntosObtenidos = this.superviviente.recogeItemSiEstasSobreEl(this.tablero);

        // Mueve los zombies de manera aleatoria
        //this.zombies.modificarTransitibilidadEnCasillaPasadaPorZombie(tablero,false);//Para que no vuelva a la posicion inicial
        this.zombies.moveros(this.superviviente, this.tablero);

        return puntosObtenidos;
    }

    public static int objetoAlAzar(int[] puntosAObtener, int[] objetosObtenidos) {
        int puntos = 0;
        int objeto = (int) Math.round(Math.random() * 12 + 1);
        int i = objeto - 1;
        switch (objeto) {
            case 1:
                puntos = Items.item1(puntosAObtener);
                objetosObtenidos[0]++;
                break;
            case 2:
                puntos = Items.item2(puntosAObtener);
                objetosObtenidos[1]++;
                break;
            case 3:
                puntos = Items.item3(puntosAObtener);
                objetosObtenidos[2]++;
                break;
            case 4:
                puntos = Items.item4(puntosAObtener);
                objetosObtenidos[3]++;
                break;
            case 5:
                puntos = Items.item5(puntosAObtener);
                objetosObtenidos[4]++;
                break;
            case 6:
                puntos = Items.item6(puntosAObtener);
                objetosObtenidos[5]++;
                break;
            case 7:
                puntos = Items.item7(puntosAObtener);
                objetosObtenidos[6]++;
                break;
            case 8:
                puntos = Items.item8(puntosAObtener);
                objetosObtenidos[7]++;
                break;
            case 9:
                puntos = Items.item9(puntosAObtener);
                objetosObtenidos[8]++;
                break;
            case 10:
                puntos = Items.item10(puntosAObtener);
                objetosObtenidos[9]++;
                break;
            case 11:
                puntos = Items.item11(puntosAObtener);
                objetosObtenidos[10]++;
                break;
            case 12:
                puntos = Items.item12(puntosAObtener);
                objetosObtenidos[11]++;
                break;
        }
        return puntos;
    }

    public static int puntosObtenidos(int puntosPorItem) {
       Partida.puntos =+ puntosPorItem;
        return Partida.puntos;
    }

    public static int[] puntosAObtener() {
        int[] puntos = {100, 200, 300, 400, 400, 500, 600, 700, 800, 900, 1000, 1100};

        return puntos;
    }

    public static void mostrarObjetos(int[] objetosObtenidos) {
        String[] nombres = Items.nombreItems();
        System.out.println("");
        System.out.println(Colores.AZUL + "Durante tu aventura has conseguido:");
        for (int i = 0; i < nombres.length; i++) {
            if (objetosObtenidos[i] != 0) {
                System.out.println(Colores.AZUL + nombres[i] + ": " + objetosObtenidos[i]);
            }

        }
        System.out.println("");
        System.out.println(Colores.MAGENTA+"Y un total de: " + Partida.puntos + " puntos");
    }

    /**
     * Comprueba si se ha perdido el juego. Se comprueba que ningún zombie se ha
     * comido al superviviente
     *
     * @return true si se ha perdido, false si no
     */
    private boolean juegoPerdido() {

        return zombies.algunZombieCoincideConSuperviviente(this.superviviente);

    }

    /**
     * Comprueba si se ha ganado el juego
     *
     * @return true si se ha ganado, false si no
     */
    private boolean juegoGanado() {

        return this.tablero.hayItems();
    }

    /**
     * Devuelve la representación del tablero según el estado de las casillas y
     * la posición del superviviente y los zombies
     */
    private void mostrarEstadoPartida() {

        String tableroTexto = "";

        for (int i = 0; i < this.tablero.numFilas(); i++) {

            for (int j = 0; j < this.tablero.numColumnas(i); j++) {

                Point puntoIJ = new Point(i, j);
                // Si el superviviente está en la casilla, lo imprime
                if (superviviente.estaEnPunto(puntoIJ)) {
                    tableroTexto += Superviviente.SIMBOLO;
                } else {

                    boolean noHayNadieEnCasilla = true;

                    // Si hay algún zombie en la casilla, lo imprime
                    for (int k = 0; k < this.zombies.numZombies(); k++) {

                        if (this.zombies.algunZombieEstaEnPunto(puntoIJ)) {
                            tableroTexto += this.zombies.obtenerSimboloZombie(this.zombies.obtenerZombie(puntoIJ));
                            noHayNadieEnCasilla = false;
                            break;
                        }
                    }

                    // Si no, imprime la casilla segun su estado
                    if (noHayNadieEnCasilla) {
                        if (this.tablero.casillaHayItem(puntoIJ)) {
                            tableroTexto += Colores.MAGENTA + this.tablero.casillaATexto(puntoIJ) + Colores.COLOR_RESET;
                        } else {
                            tableroTexto += Colores.AZUL + this.tablero.casillaATexto(puntoIJ) + Colores.COLOR_RESET;
                        }

                    }
                }
            }
            tableroTexto += "\n";
        }
        tableroTexto += "\n" + Colores.AZUL + "PUNTOS: " + Colores.MAGENTA + puntos + "\n";
        tableroTexto += Colores.AZUL + "VIDAS:  " + Colores.VERDE + vidas + "\n" + Colores.COLOR_RESET;

        System.out.println(tableroTexto);
    }
}
