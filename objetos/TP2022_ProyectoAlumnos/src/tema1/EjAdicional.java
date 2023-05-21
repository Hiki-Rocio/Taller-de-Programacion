/*
1- a) Simular la entrada de autos al estacionamiento municipal en el centro de la ciudad.
El estacionamiento está dividido en 5 pisos y cada piso tiene 10 plazas.
Realice un programa que genere aleatoriamente números (patentes) hasta el 0. Por cada
patente generada, debe leer por teclado el número de piso y número de plaza donde
debe estacionar el auto, debiendo marcar ese lugar como ocupado en una estructura de
datos adecuada.
Nota: Al principio todas las plazas del estacionamiento deben marcarse desocupadas.
Además, durante la lectura, puede considerar que el lugar leído (número de piso,
número de plaza) está desocupado y dichos números son válidos.
b) Informe cuál es el piso más ocupado.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Alumno
 */
public class EjAdicional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int pisos=5;
        int plazas=10;
        boolean[][]matriz=new boolean[pisos][plazas];
        int patentes;
        int numPiso,numPlaza;
        boolean desocupado=false;
        int i,j,suma;
        int max=0;
        int maxPiso=0;
        
        //inicializo la mariz en desoupado
       for(i=0; i<pisos; i++){
         for(j=0; j<plazas; j++){
             matriz[i][j]=false;
         }
        }
       
        GeneradorAleatorio.iniciar();
        
        patentes=GeneradorAleatorio.generarInt(10);
        while(patentes != 0){
            System.out.println("Numero de patente "+ patentes);
            System.out.print("Numero de piso del 1 al 5: ");
            numPiso=Lector.leerInt();
            System.out.print("Numero de Plaza del 1 al 10: ");
            numPlaza=Lector.leerInt();
            
           if(matriz[numPiso - 1][numPlaza - 1 ]!= true){ //si esta desocupado puedo guardar el auto en esa plaza
                matriz[numPiso-1][numPlaza-1]=true;
            }
            patentes=GeneradorAleatorio.generarInt(10);
        }

        //b) Informe cuál es el piso más ocupado.
        
        
       for(i=0; i<pisos; i++){
          suma=0;
          for(j=0; j<plazas; j++){
             if(matriz[i][j]== true){ 
              suma=suma+1;
             }
          }
          if(suma>max){
              max= suma;
              maxPiso=i + 1;
          }
        }
        System.out.println("El piso mas ocupado es: "+ maxPiso);
    }
    
}
