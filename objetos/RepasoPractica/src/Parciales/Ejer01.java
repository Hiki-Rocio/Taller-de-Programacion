/*
1.Representar un concurso de baile.El concurso tiene a lo sumo N 
parejas. Cada pareja tiene 2 participantes y un estilo de baile. De los participantes 
se tiene dni, nombre, edad.
a) Genere las clases necesarias. Provea constructores para iniciar : el concurso para un maximo de N parejas
(iniicialemente sin parejas cargadas):las parejas y los participantes a partir
de toda su informacion.
b) Implemente metodos en las clases adecuadas para permitir:
-Agregar una pareja al concurso.Asuma que hay lugar.
-Obtener la diferencia de edad de la pareja.
Obtener la pareja con mas diferencia de edad del concurso.
2. Realice un programa que intancie un concurso, cargue 2 parejas y apartir
del concurso muestre: los nombres de los participantes de la pareja con mas diferencia de edad.
 */
package Parciales;

public class Ejer01 {

    public static void main(String[] args) {
       Concursos c=new Concursos(2);//2 parejas
       Parejas p;   
       Participante part1= new Participante("Dulce", 35,3399252 );
       Participante part2= new Participante("Dante", 42,3499252 );
       Participante part3= new Participante("Rocio", 34,3599252 );
       Participante part4= new Participante("Emma", 35,3199252 );
       
       Parejas p1= new Parejas(part1, part2, "Pop");
       Parejas p2= new Parejas(part3,part4, "lirico");
       
       c.agregarPareja(p2);
       c.agregarPareja(p1);
       System.out.println("Parejas agregadas al concurso");
       
        p= c.max();
        System.out.println(p.getP1().getNombre()+"\n"+p.getP2().getNombre());
    }
    
}
