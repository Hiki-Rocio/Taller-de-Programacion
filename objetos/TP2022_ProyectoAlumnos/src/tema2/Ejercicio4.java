/*
4- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona y pensar en la estructura de datos a utilizar. 
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ejercicio4 {

  public static void main (String[] args){
      int dias=5;
      int personas=8;
      Persona[][]matriz= new Persona[dias][personas];
      String nombre;
      int edad=0,dni=0;
      int p=0;
      int d=0;
      
      GeneradorAleatorio.iniciar();
      System.out.println("Nombre: ");
      nombre= Lector.leerString();
      if(!"zzz".equals(nombre)){
             dni=GeneradorAleatorio.generarInt(100000);
             System.out.println("Dni: "+dni);
             edad=GeneradorAleatorio.generarInt(100);
             System.out.println("Edad "+edad);            
      }
      while((d<5)&&(!"zzz".equals(nombre))){
            p=0;
           while((p<8)&&(!"zzz".equals(nombre))){
              matriz[d][p]= new Persona(nombre,dni,edad);
              p++;
             GeneradorAleatorio.iniciar();
             System.out.println("Nombre: ");
             nombre= Lector.leerString();
             if(!"zzz".equals(nombre)){
               dni=GeneradorAleatorio.generarInt(100000);
               System.out.println("Dni: "+dni);
               edad=GeneradorAleatorio.generarInt(100);
               System.out.println("Edad "+edad);            
             }   
           }
           System.out.println("------------- "); 
           System.out.println("siguiente dia "); 
           d++;
      }
      /*b) Informar para cada día y turno el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona y pensar en la estructura de datos a utilizar. 
 */
      int P=0;
      int D=0;
      while((D < 5)&&(matriz[D][P] != null)){
           P=0;
           System.out.println("Dia------"+(D+1));
           while((P < 8)&&(matriz[D][P] != null)){
              System.out.println("Persona numero---"+(P+1));
              System.out.println("Nombre: "+matriz[D][P].getNombre());
              System.out.println("DNI: "+matriz[D][P].getDNI());
              System.out.println("Edad: "+matriz[D][P].getEdad());
              P++;
              System.out.println(D+1);
           }   
           D++;//no  me imprime el siguiente dia
           System.out.println(D+1);
       }
      
     
      }      
  }
