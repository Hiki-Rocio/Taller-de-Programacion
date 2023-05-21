/*
2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
 - Informe la cantidad de personas mayores de 65 años.
 - Muestre la representación de la persona con menor DNI.

 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;

public class Ejercicio2 {

    public static void main(String[] args) {
       int DF= 15;
       int DL=0;
       Persona [] vector = new Persona[DF];//guardo personas ccon sus datos

           
       GeneradorAleatorio.iniciar();
       int edad,dni;
       String nombre;
       
       System.out.println("---------Datos-----------");
       edad =(GeneradorAleatorio.generarInt(100));
       while((edad != 0)&& (DL<DF)){
                 nombre = (GeneradorAleatorio.generarString(20));
                 dni=(GeneradorAleatorio.generarInt(10000));
                 vector[DL]= new Persona(nombre,dni,edad);
                 DL++;
                 edad= (GeneradorAleatorio.generarInt(100));     
       }
       
       //recorro el vector para sacar los datos que me piden 
       int cant =0;
       int min = 999999;

       Persona personaMin = null;
       
       
       for(int i=0; i<DL; i++){
             System.out.println(vector[i].toString());
             if(vector[i].getDNI()<min){
                    min = vector[i].getDNI();
                    personaMin= vector[i];
              }
             if(vector[i].getEdad() > 65){
                     cant++;
             }   
       }   
        System.out.println("La cantidad de personas mayores a 65 años es : " + cant );
        if(personaMin != null){
              System.out.println(personaMin.toString());
        }
        else{
            System.out.println("El vector estaba vacio");
        }
            
        }

    }
