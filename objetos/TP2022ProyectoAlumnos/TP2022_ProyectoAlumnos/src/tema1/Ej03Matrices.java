/*
3- Escriba un programa que defina una matriz de enteros de tamaño 5x5. Inicialice
la matriz con números aleatorios entre 0 y 30.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de los elementos de la fila 1
- Generar un vector de 5 posiciones donde cada posición j contiene la suma
de los elementos de la columna j de la matriz. Luego, imprima el vector.
- Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento”.
NOTA: Dispone de un esqueleto para este programa en Ej03Matrices.java
 */
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;


public class Ej03Matrices {

    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio     
	 GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
         int DF=5;
         int i,j;
         int fila=1;
         int suma=0;
         int [][] matriz = new int[DF][DF];
         for (i=0; i<DF;i++){
           for(j=0; j<DF; j++){
               matriz[i][j]= GeneradorAleatorio.generarInt(30);
           }
         }
       
        //Paso 4. mostrar el contenido de la matriz en consola
        System.out.println("Elementos de la matriz numeros: ");
         for (i=0; i<DF; i++){
             for(j=0; j<DF; j++){
                 System.out.print(matriz[i][j]+ " " +" ");
             }
             
             System.out.println();
         }
         
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
         
         for (j=0; j<DF; j++){
             suma= suma + matriz[fila][j];
         }
         System.out.println("La suma de los elementos de la fila " + fila + " es " + suma);
         
         System.out.println();
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
         int columna;
         
         int [] vector= new int[DF];
          for(j =0; j< DF; j++){
              columna=0;
            for(i=0; i<DF; i++){
              columna= columna + matriz[i][j];
             }
            vector[j]=columna;
          }
         for (i=0; i<DF; i++){
               System.out.print(vector[i]+ " ");
         }
         System.out.println();
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".

        int numero;
        int k=0;
        int l=0;
        boolean encontre=false;
        System.out.print("Ingrese un numero para buscar en la matriz: ");
        numero=Lector.leerInt();
        for (i=0; i<DF; i++){
            for(j=0; j<DF; j++){
               if(numero == matriz[i][j]){
                   encontre=true;
                   k=i;
                   l=j;
               }                       
            }
        }
        if(encontre){
        System.out.println("El numero "+ numero + "se encuentra en la fila "+ k + " columna "+ l );}
               else{
                   System.out.println("No se encontro el valor buscado");  
        }
    }
}
