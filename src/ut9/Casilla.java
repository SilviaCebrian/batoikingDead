/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut9;

/**
 *
 * @author Silvia
 */
public class Casilla {

    /**
     ** Constantes de estados de las casillas
     */
    public static final int TIPO_VACIA = 1;
    public static final int TIPO_LIMITE = 2;
    public static final int TIPO_ITEM = 3;

    /**
     * Constantes de la representación gráfica de cada estado
     */
    public static final String TIPO_VACIA_TEXTO = " ";
    public static final String TIPO_LIMITE_TEXTO = "|";
    public static final String TIPO_ITEM_TEXTO = "x";

    //Atributos
    private int tipo;
    private boolean soy_transitable = true;

    //Constructor
    public Casilla(int tipo) {

        this.tipo = tipo;
        if (tipo == TIPO_LIMITE) {
            this.soy_transitable = false;
        }
    }

    public void setSoyTransitable(boolean estado) {
        this.soy_transitable = estado;
    }

    /**
     * Comprueba si una casilla es transitable
     *
     * @return true si es traspasable, false si no lo es o si las coordenadas
     * son incorrectas
     */
    public boolean esTransitable() {

        return this.soy_transitable;
    }

    public int getTipo() {
        return this.tipo;
    }

    /**
     * Comprueba si en una casilla hay item
     *
     * @return true si es un punto, false si no lo es o si las coordenadas son
     * incorrectas
     */
    public boolean hayItem() {

        return this.tipo == TIPO_ITEM;
    }

    /**
     * Marca la casilla indicada como vacía, no efectuando ningua operación si
     * las coordenadas son incorrectas
     */
    public void vaciaCasilla() {

        this.tipo = TIPO_VACIA;
    }

    /**
     * Devuelve la casilla representada en forma de cadena de texto
     *
     * @return La casilla representada en forma de cadena de texto o null si las
     * coordenadas son incorrectas
     */
    public String casillaATexto() {

        switch (this.tipo) {
            case TIPO_VACIA:
                return TIPO_VACIA_TEXTO;
            case TIPO_LIMITE:
                return TIPO_LIMITE_TEXTO;
            case TIPO_ITEM:
                return TIPO_ITEM_TEXTO;
            default:
                return "";
        }
    }
}
