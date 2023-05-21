/*
1- La UNLP desea administrar sus proyectos, investigadores y subsidios. Un proyecto
tiene: nombre, código, nombre completo del director y los investigadores que participan
en el proyecto (50 como máximo). De cada investigador se tiene: nombre completo,
categoría (1 a 5) y especialidad. Además, cualquier investigador puede pedir hasta un
máximo de 5 subsidios. De cada subsidio se conoce: el monto pedido, el motivo y si fue
otorgado o no.
i) Implemente el modelo de clases teniendo en cuenta:
a. Un proyecto sólo debería poder construirse con el nombre, código, nombre del
director.
b. Un investigador sólo debería poder construirse con nombre, categoría y
especialidad.
c. Un subsidio sólo debería poder construirse con el monto pedido y el motivo.
Un subsidio siempre se crea en estado no-otorgado.
ii) Implemente los métodos necesarios (en las clases donde corresponda) que permitan:
a. void agregarInvestigador(Investigador unInvestigador);
// agregar un investigador al proyecto.
b. void agregarSubsidio(Subsidio unSubsidio);
// agregar un subsidio al investigador.
c. double dineroTotalOtorgado();
//devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
todos los subsidios otorgados de todos los investigadores)
d. void otorgarTodos(String nombre_completo);
//otorgar todos los subsidios no-otorgados del investigador llamado
nombre_completo
e. String toString();
// devolver un string con: nombre del proyecto, código, nombre del director, el
total de dinero otorgado del proyecto y la siguiente información de cada
investigador: nombre, categoría, especialidad, y el total de dinero de sus
subsidios otorgados.
iii) Escriba un programa que instancie un proyecto con tres investigadores. Agregue dos
subsidios a cada investigador y otorgue los subsidios de uno de ellos. Luego imprima
todos los datos del proyecto en pantalla.
 */
package repasopractica;

import PaqueteLectura.GeneradorAleatorio;

public class RepasoPractica {

  
    public static void main(String[] args) {
        Proyectos P= new Proyectos("La nubes",3,"Roberto");
        Subsidios s;
        Investigadores I;
        
        Subsidios s1=new Subsidios(5000, "viaticos");
        Subsidios s2=new Subsidios(10000, "Asignacion familiar");
        Subsidios s3=new Subsidios(10000, "Discapacidad");
        Subsidios S4 = new Subsidios(3000 , "Descubrimiento 2");
        Subsidios S5 = new Subsidios(3000 , "Descubrimiento 3");
        Subsidios S6 = new Subsidios(3000 , "Descubrimiento 4");
        
        for(int i=0;i<2;i++){
             I= new Investigadores(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(5)+1,GeneradorAleatorio.generarString(10));
             I.agregarSubsidio(s1);
             I.agregarSubsidio(s2);
             P.agregarInvestigador(I);
        }

        I= new Investigadores("Rocio",4,"Informatica");      
        I.agregarSubsidio(S4);
        I.agregarSubsidio(S5);
        P.agregarInvestigador(I);
        
        P.otorgarTodos("Rocio");
          
          System.out.println(P.toString());
    }
    
}
