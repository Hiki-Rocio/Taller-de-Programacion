/*
5-A- Modifique la clase VisorFiguras: ahora debe permitir guardar las figuras a mostrar (a 
lo sumo 5) y también mostrar todas las figuras guardadas. Use la siguiente estructura
 */
package tema4;

public class Ejer05MainVisorFiguras {

    public static void main(String[] args) {
       VisorFiguras2 visor = new VisorFiguras2();

       
       Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
       visor.guardar(c1);
       Rectangulo r= new Rectangulo(20,10,"Azul","Celeste");
       visor.guardar(r);
       Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
       visor.guardar(r);
       Rectangulo r2= new Rectangulo(40,10,"Azul","Celeste");
       visor.guardar(r2);
 
       visor.mostrar(c1);
       visor.mostrar(r);
       visor.mostrar(c2);

    System.out.println(visor.getGuardadas());   
    System.out.println(visor.getMostradas());
  //  visor.mostrarVector();

} 
    
}
