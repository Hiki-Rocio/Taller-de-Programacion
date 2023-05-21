/*
1-A- Incluya la clase Triángulo a la jerarquía de figuras vista (carpeta tema4). Triángulo
debe heredar de Figura todo lo que es común y definir su constructor y sus atributos y
métodos propios. Además debe redefinir el método toString.
B- De igual manera, incluya la clase Círculo a la jerarquía de figuras.
C- Añada a la representación String el valor del perímetro. Piense ¿qué método toString
debe modificar: el de cada subclase o el de Figura?
D- Añada el método despintar que establece los colores de la figura a línea “negra” y
relleno “blanco”. Piense ¿dónde debe definir el método: en cada subclase o en Figura?

E- Realizar un programa que instancie un triángulo y un círculo. Muestre en consola la
representación String de cada uno. Pruebe el funcionamiento del método despintar
 */
package tema4;

import PaqueteLectura.Lector;

public class Ejer01 {

    public static void main(String[] args) {

        Circulo c;
        Triangulo t;
        
        t= new Triangulo(10,10,10,"Rojo","violeta");      
        c = new Circulo(13.5,"Amarillo","Naranja");
        
        System.out.print(" ");  
        System.out.println("REPRESENTACION DEL CIRCULO------------------- ");  
        System.out.println(c.toString());
        System.out.println(" ");
        System.out.println("REPRESENTACION DEL TRIANGULO------------------ ");
        System.out.println(t.toString());
        
        c.despintar();
        t.despintar();
        System.out.print(" ");  
        System.out.println("REPRESENTACION DEL CIRCULO------------------- ");  
        System.out.println(c.toString());
        System.out.println(" ");
        System.out.println("REPRESENTACION DEL TRIANGULO------------------ ");
        System.out.println(t.toString());        
    }
    
}
