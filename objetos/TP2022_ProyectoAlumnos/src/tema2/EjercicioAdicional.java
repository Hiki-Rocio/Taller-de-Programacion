/*
Cree un nuevo proyecto en Netbeans y resuelva: 
1- a) Cargue la clase Auto.java (dada por la cátedra) en su proyecto. 
Un objeto auto se crea sin valores iniciales y responde a los siguientes mensajes: 
getPatente() retorna la patente (int) del auto
getDueño() retorna el nombre del dueño (String) del auto
setPatente(X) modifica el número de patente al “int” pasado por parámetro (X)
setDueño(X) modifica el nombre del dueño al “String” pasado por parámetro (X)
toString() retorna un String que representa al objeto. Ej: “Patente 111222 Dueño Carla 
Perez” 
b) Simular la entrada de autos al estacionamiento municipal en el centro de la ciudad. El 
estacionamiento está dividido en 5 pisos y cada piso tiene 10 plazas, y debemos 
almacenar en una estructura de datos adecuada los autos estacionados. 
Realice un programa que lea la información de 5 autos que desean estacionar. Por cada 
auto, también lea número de piso y número de plaza e ingréselo al estacionamiento. 
Nota: Al principio el estacionamiento debe estar vacío (sin autos). 
c) A partir de la estructura de autos, informar para cada número de piso y número de 
plaza ocupado, la representación del auto que la ocupa.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class EjercicioAdicional {
    
    public static void main(String[] args) {
        int pisos=5;
        int plazas= 10;
        Auto[][]matriz= new Auto [pisos][plazas];
        
        int i,j;
        for(i=0; i<pisos; i++){
          for(j=0; j<plazas; j++){
              matriz[i][j]=null;
          }
        }
        int a=0;
        int p;
        int pz;
        String Dueño;
        int patente;
        
        for(i=0;i<5; i++){
            GeneradorAleatorio.iniciar();
            System.out.println("Auto------------------"+(a+1));
            p=GeneradorAleatorio.generarInt(pisos);
            System.out.println("Numero de Piso: "+(p+1));
            pz=GeneradorAleatorio.generarInt(plazas);  
            System.out.println("Numero de Plaza: "+(pz+1)); 
            matriz[p][pz]= new Auto();
            patente=GeneradorAleatorio.generarInt(5);
            System.out.println("Patente: "+patente);
            matriz[p][pz].setPatente(patente);
            Dueño=GeneradorAleatorio.generarString(1);
            System.out.println("Dueño: "+Dueño);
            matriz[p][pz].setDueño(Dueño);
        
        }
        
        System.out.println("----------------------------ESTACIONAMIENTO---------------");
        for(i=0; i<5; i++){
            System.out.println("Numero de piso------"+(i+1));
          for(j=0; j<10; j++){
              System.out.println("Numero Plaza: "+(j+1));
              if(matriz[i][j] != null){
                 System.out.println(matriz[i][j].toString());
              }
              else{
                  System.out.println("Lugar desocupado");
              }
          }
          
        }       
    }
    
}
