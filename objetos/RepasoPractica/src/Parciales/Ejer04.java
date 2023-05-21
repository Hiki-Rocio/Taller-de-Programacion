/*
//sin resolver
Se quiere registrar la informacion de los goleadores para cada fecha del torneo
de futbol 2022.El torneo tiene un nombre y una tabla que guardapara cada una de las 
Nfechas(1..N)los goleadores de la fecha .Cada fecha tendra como maximo M goleadores(0..M-1)
Por esto, el torneo lleva otra estructura donde para cada fecha tiene la cantidad de goleadores
registrados. De cada goleador se conoce su nombre, nombre de su equipo y cantidad de goles que efectuo en esa fecha.
1.genere las clases necesarias. Provea constructores para crear:
los goleadores a partir de la informacionnecesaria; el torneo con un nombre, una cantidad N de fecha y una cantidad M 
de goleadores por fecha (nicialmente cada fecha tiene 0 goleadores registrados).
2. Implemente los metodos necesarios en las clases que corresponda, para:
a)Agregar un goleador a la fecha X del torneo, actualizando lq cantidad de goleadores registrados de esa fecha. Asuma
qie x ESTA EN RANGO 1 ..n Y QUE DICHA FECHA tiene lugaR para un goleador mas.
b)obtener eñ goleador que efectuo menos goles en la fecha X.Asuma que X esta en rango 1..N
c)Obtner la cantidad de goleadores registtrados en el torneo.
d)Obtener un String que represente el torneo siguiendo e ejemplo:
"TORNEO 2022: nombre
"Fecha #1/cantidad de goleadores de la fecha /goleadores:(nombre, equipo,cantidad de goles)
"Fecha #2/cantidad.......
..."

3.Realice un programa que iinstancie un torneo. Agregue goleadores en distintas fechas. Compruebe e correcto funcioonamiento de los metodos impementados.

 */
package Parciales;

public class Ejer04 {


    public static void main(String[] args) {
        Goleadores g=new Goleadores("Messi", "Argentina", 4);
        Goleadores g1=new Goleadores("Ronaliño", "Brasil", 2);
        Goleadores g2=new Goleadores("Kimura", "Japon", 3);
        
        
        Torneo t= new Torneo("Mundial", 3, 4);
        t.agregarGoleador(g1);
        t.agregarGoleador(g2);
        t.agregarGoleador(g);
        System.out.println("jUGADORES AGREGADOS----------");
        System.out.println(t.toString());
        System.out.println("Ingresando un goleador mas ");
        Goleadores g3=new Goleadores("Zapata", "Argentina", 4);
        t.agregarUNGoleador(4, g3);
        System.out.println("Goleador ingresado");
        System.out.println("Goleador con menos goles");
        t.obtenerGoleador(1);
        System.out.println(t.toString());
    }
    
}
