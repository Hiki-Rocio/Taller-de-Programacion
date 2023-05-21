/*
4- Un objeto visor de figuras se encarga de mostrar en consola cualquier figura que reciba 
y también mantiene cuántas figuras mostró. Analice y ejecute el siguiente programa y 
responda: ¿Qué imprime? ¿Por qué?
 */
package tema4;

/**
 *
 * @author admin
 */
public class Ejer04MainVisorFiguras {

public static void main(String[] args) {
 VisorFiguras visor = new VisorFiguras();
 
 Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
 Rectangulo r= new Rectangulo(20,10,"Azul","Celeste");
 Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
 
 visor.mostrar(c1);
 visor.mostrar(r);
 visor.mostrar(c2);
 
 System.out.println(visor.getMostradas());
} 
}
// imprime los datos de todos las figuras y al final imprime la cantidad de figuras mostradas
//el metodo mostrar cuenta cada vez que se instancia una figura ademas de sus datos