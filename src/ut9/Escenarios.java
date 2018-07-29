/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut9;

/**
 *
 * @author silvi
 */
public class Escenarios {

    //Atributos en este caso distintos escenarios
    public static int[][] escenario1() {

        int lmte = Casilla.TIPO_LIMITE;
        int item = Casilla.TIPO_ITEM;
        int nada = Casilla.TIPO_VACIA;

        return new int[][]{
            {lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte},
            {lmte, nada, lmte, lmte, nada, nada, nada, nada, nada, nada, nada, nada, nada, nada, item, lmte},
            {lmte, nada, nada, nada, item, lmte, lmte, lmte, nada, nada, nada, lmte, lmte, lmte, nada, lmte},
            {lmte, nada, lmte, lmte, nada, nada, nada, nada, nada, nada, nada, nada, nada, nada, nada, lmte},
            {lmte, nada, lmte, lmte, nada, lmte, item, lmte, lmte, lmte, lmte, lmte, item, lmte, nada, lmte},
            {lmte, nada, nada, nada, nada, lmte, nada, nada, nada, nada, nada, nada, nada, lmte, nada, lmte},
            {lmte, lmte, lmte, lmte, item, lmte, lmte, lmte, item, lmte, item, lmte, lmte, lmte, nada, lmte},
            {lmte, nada, nada, nada, nada, lmte, item, nada, nada, nada, nada, nada, nada, lmte, nada, lmte},
            {lmte, nada, lmte, lmte, nada, nada, nada, lmte, lmte, lmte, lmte, lmte, nada, item, nada, lmte},
            {lmte, nada, lmte, lmte, nada, lmte, nada, nada, nada, nada, nada, nada, nada, lmte, nada, lmte},
            {lmte, nada, lmte, lmte, nada, lmte, lmte, lmte, nada, lmte, item, lmte, lmte, lmte, nada, lmte},
            {lmte, item, nada, nada, nada, lmte, nada, nada, nada, lmte, nada, nada, item, lmte, nada, lmte},
            {lmte, nada, lmte, lmte, lmte, lmte, nada, lmte, lmte, lmte, lmte, lmte, nada, lmte, nada, lmte},
            {lmte, nada, nada, nada, nada, item, nada, nada, nada, nada, nada, nada, nada, nada, nada, lmte},
            {lmte, nada, lmte, lmte, nada, lmte, lmte, lmte, item, lmte, nada, lmte, lmte, lmte, nada, lmte},
            {lmte, nada, nada, nada, nada, nada, nada, nada, nada, lmte, nada, nada, nada, nada, nada, lmte},
            {lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte}
        };

    }

    public static int[][] escenario2() {

        int lmte = Casilla.TIPO_LIMITE;
        int item = Casilla.TIPO_ITEM;
        int nada = Casilla.TIPO_VACIA;

        return new int[][]{
            {lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte},
            {lmte, nada, lmte, lmte, nada, nada, nada, nada, nada, lmte},
            {lmte, nada, lmte, lmte, item, lmte, lmte, lmte, nada, lmte},
            {lmte, nada, nada, nada, nada, nada, nada, nada, nada, lmte},
            {lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte}
        };

    }

    public static int[][] escenario3() {

        int lmte = Casilla.TIPO_LIMITE;
        int item = Casilla.TIPO_ITEM;
        int nada = Casilla.TIPO_VACIA;

        return new int[][]{
            {lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte},
            {lmte, nada, lmte, lmte, nada, nada, nada, nada, nada, lmte},
            {lmte, nada, lmte, lmte, lmte, lmte, lmte, nada, nada, lmte},
            {lmte, nada, lmte, nada, nada, nada, nada, nada, nada, lmte},
            {lmte, nada, lmte, nada, nada, nada, nada, nada, nada, lmte},
            {lmte, nada, nada, nada, nada, nada, nada, nada, item, lmte},
            {lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte, lmte}
        };

    }
}
