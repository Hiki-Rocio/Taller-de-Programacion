
package tema1;

import PaqueteLectura.Lector;

/*2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio
NOTA: Dispone de un esqueleto para este programa en Ej02Jugadores.java*/


//Paso 1: Importar la funcionalidad para lectura de datos


public class Ej02Jugadores {

  
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        int dimF= 5;
        
        //Paso 3: Crear el vector para 15 double 
        double [] vector = new double [dimF];

        //Paso 4: Declarar indice y variables auxiliares a usar
        int i, cant;
        double altura, suma, promedio;//para que el promedio me de double tengo que fijarme que al menos una variable sea double
        suma=0;
        cant=0;
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for (i=0;i<5;i++){
           System.out.print("Altura: ");
           altura =Lector.leerDouble();
           vector[i]= altura;
           suma= suma + altura;
        }
        //Paso 7: Calcular el promedio de alturas, informarlo
        promedio= suma / dimF;
        System.out.println("El promedio de altura de  todos los jugadores es " + promedio);
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        for (i=0;i<5;i++){
            if(vector[i]>promedio){
                 cant++;
            }
           
        }
        //Paso 9: Informar la cantidad.
         System.out.println("La cantidad de alturas que superan el proomedio es " + cant);
    }
    
}
