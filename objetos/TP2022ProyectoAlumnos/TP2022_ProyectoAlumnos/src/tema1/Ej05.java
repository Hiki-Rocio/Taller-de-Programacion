/*
5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen 
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad 
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes 
para cada uno de los aspectos y almacene la información en una estructura. Luego 
imprima la calificación promedio obtenida por cada aspecto
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej05 {

    public static void main(String[] args) {
    int cliente= 5;
    int aspecto= 4;
    int [][]puntaje = new int [cliente][aspecto];
    int i,j,punt;
    double suma;
    double promedio;
    double []vector=new double[aspecto];
    
    for(i=0; i<cliente; i++){
      for(j=0; j<aspecto; j++){
          puntaje[i][j]=0;
      }
    }
    for(i=0; i<cliente; i++){
      for(j=0; j<aspecto; j++){
          punt=GeneradorAleatorio.generarInt(10);
          puntaje[i][j]=punt;
      }
    }
    for(i=0; i<cliente; i++){
         System.out.println("CLIENTE--------"+i+"---------------------");
      for(j=0; j<aspecto; j++){
         
          System.out.println("Aspecto-->"+j);
          System.out.println("puntaje-"+puntaje[i][j]);
      }
          
      }
      for(j=0;j<aspecto; j++){
          suma=0;
          for(i=0; i<cliente; i++){
              suma=suma + puntaje[i][j];
             
          }
          promedio=suma/cliente;  
          vector[j]=promedio;
      }
      System.out.println("--------------PROMEDIOS----------------");
          for(j=0;j<aspecto; j++){
              System.out.println("ASPECTO--"+j+"-----------");
              System.out.println("Promedio puntaje--->"+vector[j]);
          }

    }
    
}
