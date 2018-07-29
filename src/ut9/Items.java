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
public class Items {
     public static String []nombreItems(){
        String [] nombreItems={"Pato troll","Gafas de sol","Pulsera molona","Sombrero de paja","Batamanta sospechosa","Zapato de Zombie","Mechero sin gas","Comida gato amenazante","Vida","Pata de Cabra","Gato Amenazante","Lucille"};
        return nombreItems;
    }

    public static int item1(int []puntosPorItem){
        int gato=puntosPorItem[0];
        System.out.println(Colores.MAGENTA+"Has encontrado un Pato Troll Miauuuuuuuu!!.\n"+Colores.MAGENTA+"Obtienes "+gato+" puntos.");
        System.out.println("");
        return gato;
    }
     public static int item2(int []puntosPorItem){
        int gafasDeSol=puntosPorItem[1];
        System.out.println(Colores.MAGENTA+"Has encontrado unas Gafas de sol. Obtienes "+gafasDeSol+" puntos.");
        System.out.println("");
        return gafasDeSol;
    }
     
      public static int item3(int []puntosPorItem){
        int pulseraMolona=puntosPorItem[2];
        System.out.println(Colores.MAGENTA+"Has encontrado una Pulsera molona. Obtienes "+pulseraMolona+" puntos.");
        System.out.println("");
        return pulseraMolona;
    }
      
       public static int item4(int []puntosPorItem){
        int sombreroDePaja=puntosPorItem[3];
        System.out.println(Colores.MAGENTA+"Has encontrado un Sombrero de paja. Obtienes "+sombreroDePaja+" puntos.");
        System.out.println("");
        return sombreroDePaja;
    }
       
        public static int item5(int []puntosPorItem){
        int manta=puntosPorItem[4];
        System.out.println(Colores.MAGENTA+"Has encontrado una Batamanta con sospechosas manchas.\n"+Colores.MAGENTA+" Obtienes "+manta+" puntos.");
        System.out.println("");
        return manta;
    }
        
         public static int item6(int []puntosPorItem){
        int zapatoDeZombie=puntosPorItem[5];
        System.out.println(Colores.MAGENTA+"Has encontrado un Zapato de zombie. Obtienes "+zapatoDeZombie+" puntos.");
        System.out.println("");
        return zapatoDeZombie;
    }
         
          public static int item7(int []puntosPorItem){
        int mechero=puntosPorItem[6];
        System.out.println(Colores.MAGENTA+"Has encontrado un mechero sin gas. Obtienes "+mechero+" puntos.");
        System.out.println("");
        return mechero;
    }
          
    public static int item8(int []puntosPorItem){
        int comida=puntosPorItem[7];
        System.out.println(Colores.MAGENTA+"Has encontrado una Comida para un gato amenazante.\n"+Colores.MAGENTA+"Obtienes "+comida+" puntos.");
        
        return comida;
    }
     public static int item9(int []puntosPorItem){
        int vida=puntosPorItem[8];
        System.out.println(Colores.MAGENTA+"Has encontrado una vida. Obtienes "+vida+" puntos.");
        System.out.println("");
        
        return vida;
    }
      public static int item10(int []puntosPorItem){
        int pataDeCabra=puntosPorItem[9];
        System.out.println(Colores.MAGENTA+"Has encontrado una Pata De Cabra. Obtienes "+pataDeCabra+" puntos.");
        System.out.println("");
        
        return pataDeCabra;
    }
       public static int item11(int []puntosPorItem){
        int gatoAmenazante=puntosPorItem[10];
        System.out.println(Colores.MAGENTA+"Has encontrado un Gato Amenazante. Obtienes "+gatoAmenazante+" puntos.");
        System.out.println("");
        
        return gatoAmenazante;
    }
       
        public static int item12(int []puntosPorItem){
        int lucille=puntosPorItem[11];
        System.out.println(Colores.MAGENTA+"Has encontrado a Lucille un respetado bate. Obtienes "+lucille+" puntos.");
        System.out.println("");
        
        return lucille;
    }
}
