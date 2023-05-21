/*
5-A- Definir una clase para representar círculos. Los círculos se caracterizan por su radio 
(double), el color de relleno (String) y el color de línea (String). 
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para: 
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un círculo, le cargue información leída de teclado e 
informe en consola el perímetro y el área. 
NOTA: la constante PI es Math.PI
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author HIKI
 */
public class Eje05 {

    public static void main(String[] args) {
        
        Circulo c=new Circulo();
        GeneradorAleatorio.iniciar();
        
        double radio;
        String relleno;
        String linea;
        System.out.println("----------CIRCULO-----------");
        System.out.print("Radio: ");
        radio=Lector.leerDouble();
        System.out.print("Color de relleno: ");
        relleno=Lector.leerString();   
        System.out.print("Color de linea: ");
        linea=Lector.leerString();        
        
        c=new Circulo(radio,relleno,linea);
        
       System.out.println(" ");
       System.out.println("-------------DATOS DEL CIRCULO------------ "); 
       System.out.println(c.toString());
             
    }
}
