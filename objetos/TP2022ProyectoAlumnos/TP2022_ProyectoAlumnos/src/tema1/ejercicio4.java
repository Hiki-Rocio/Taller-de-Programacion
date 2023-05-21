/*
 4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). Realice un programa que permita informar la cantidad de personas que 
concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al 
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de 
oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro. 
de piso 9. Al finalizar la llegada de personas, informe lo pedido.
 */
package tema1;

import PaqueteLectura.Lector;

/**
 *
 * @author admin
 */
public class ejercicio4 {

    public static void main(String[] args) {
        int pisos=8;
        int oficina=4;
        int i,j;
       int [][]matriz= new int [pisos][oficina];
       int numP;
       int numO;
       
       for(i=0; i<pisos; i++){
           for(j=0; j<4; j++){
               matriz[i][j]=0;
           }
       }
       /*informar la cantidad de personas que 
concurrieron a cada oficina de cada piso.
       */
       
       
       System.out.print("Ingrese numero de piso: ");
         numP= Lector.leerInt();
         while(numP !=9){
           System.out.print("Ingrese numero de oficina: ");
            numO= Lector.leerInt();
            System.out.print("Ingrese numero de piso: ");
            numP= Lector.leerInt();
         }
         
         for(i=0; i<pisos; i++){
           for(j=0; j<oficina; j++){
               matriz[i][j]=
           }
         }
    }
}
         
         

