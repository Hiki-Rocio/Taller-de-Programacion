/*
3- Un productor musical desea administrar los recitales que organiza, que pueden ser:
eventos ocasionales y giras.
 De todo recital se conoce el nombre de la banda y la lista de temas que tocarán durante 
el recital. 
 Un evento ocasional es un recital que además tiene el motivo (a beneficio, show de TV 
o show privado), el nombre del contratante del recital y el día del evento.
 Una gira es un recital que además tiene un nombre y las “fechas” donde se repetirá la 
actuación. De cada “fecha” se conoce la ciudad y el día. Además la gira guarda el 
número de la fecha en la que se tocará próximamente (actual).
a) Genere las clases necesarias. Implemente métodos getters/setters adecuados.
b) Implemente los constructores. El constructor de recitales recibe el nombre de la banda 
y la cantidad de temas que tendrá el recital. El constructor de eventos ocasionales además 
recibe el motivo, el nombre del contratante y día del evento. El constructor de giras 
además recibe el nombre de la gira y la cantidad de fechas que tendrá.
c) Implemente los métodos listados a continuación: 
i. Cualquier recital debe saber responder a los mensajes:
 agregarTema que recibe el nombre de un tema y lo agrega a la lista de temas. 
 actuar que imprime (por consola) para cada tema la leyenda “y ahora 
tocaremos…” seguido por el nombre del tema.
ii. La gira debe saber responder a los mensajes:
 agregarFecha que recibe una “fecha” y la agrega adecuadamente.
 La gira debe responder al mensaje actuar de manera distinta. Imprime la leyenda 
“Buenas noches …” seguido del nombre de la ciudad de la fecha “actual”. Luego 
debe imprimir el listado de temas como lo hace cualquier recital. Además debe 
establecer la siguiente fecha de la gira como la nueva “actual”.
iii. El evento ocasional debe saber responder al mensaje actuar de manera distinta:
 Si es un show de beneficencia se imprime la leyenda “Recuerden colaborar con…“ 
seguido del nombre del contratante. 
 Si es un show de TV se imprime “Saludos amigos televidentes” 
 Si es un show privado se imprime “Un feliz cumpleaños para…” seguido del 
nombre del contratante. 
Independientemente del motivo del evento, luego se imprime el listado de temas como 
lo hace cualquier recital.
iv. Todo recital debe saber responder al mensaje calcularCosto teniendo en cuenta lo 
siguiente. Si es un evento ocasional devuelve 0 si es a beneficio, 50000 si es un show de TV 
y 150000 si es privado. Las giras deben devolver 30000 por cada fecha de la misma.
d) Realice un programa que instancie un evento ocasional y una gira, cargando la 
información necesaria. Luego, para ambos, imprima el costo e invoque al mensaje actuar
 */
package repasopractica;


public class Ejer03 {

    public static void main(String[] args) {
      Eventos e= new Eventos("Show a beneficio", "Rocio", "3/05/2023", "Evanescence", 2);
      Giras g= new Giras("Black", 3, "LP", 2);
     //Fechas f;
      Fechas f1=new Fechas("La Plata","25/05/2023");
      Fechas f2=new Fechas("Buenos Aires","26/05/2023");
      Fechas f3=new Fechas("Tandil","27/05/2023");
      g.agregarFecha(f1);
      g.agregarFecha(f2);
      g.agregarFecha(f3);
      g.agregarTema("In the end");
      g.agregarTema("Numb");
      e.agregarTema("Going under");
      e.agregarTema("Lithium");
      
      
      System.out.println("DATOS DEL RECITAL----------------------");
      System.out.println("//////Eventos/////");
      e.calcularCosto();
      e.actuar();
      System.out.println("//////GIRAs////");
      g.actuar();
      System.out.println("Costo de la gira");
      System.out.println(g.calcularCosto());
      System.out.println("Costo del evento");
      System.out.println(e.calcularCosto());
    }
    
}
