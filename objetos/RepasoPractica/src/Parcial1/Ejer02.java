/*
Para el que quiera saber como fue el parcial de las 9:30
Teníamos una mesa de final, que poseía una fecha, y una N cantidad máxima de alumnos.
Los alumnos poseían nombre, legajo, 3 notas de parcial, y un Tema. El Trma tenía un nro, 
un enunciado Teórico y uno Practico. 
Después habían varios método, como agregar alumno (asumiendo que había espacio),asignar tema, 
que recibía por oarametro 2 temas, y asignaba el t1 a aquellos alumnos con promedio superior a 6, y t2 al resto

También otro método de obtener estadísticas, que devolvía el nro de alumnos que sus 3 parciales tenían nota superior a 7.
Y un método verMesa, que devolvía un string con la representación de la mesa y sus alumnos
 */
package Parcial1;

public class Ejer02 {


    public static void main(String[] args) {
       Mesa m=new Mesa("25/04/23",3);
       Tema t1=new Tema(1,"teoria1..","Plantear1");
       Tema t2=new Tema(2,"teoria2..","Plantear2");
       Tema t3=new Tema(3,"teoria3..","Plantear3");
       Alumnos a1=new Alumnos("Dante", 1234, 8, 9, 8,t1);
       Alumnos a2=new Alumnos("Rocio", 4567, 5, 4, 6, t1);
       Alumnos a3=new Alumnos("Dulce", 7894, 9,10, 10, t1);
       
       m.AgregarAlumno(a1);
       m.AgregarAlumno(a2);
       m.AgregarAlumno(a3);
       
        System.out.println("Alumnos agregados");
        m.AsignarTema(t1, t2);
        System.out.println("Se asignaron temas");
        System.out.println(a1.getTema());
        System.out.println(a2.getTema());
        System.out.println( a3.getTema());
        
       
        System.out.println("La cantidad de alumnos donde sus 3 notas superan 7 es: "+m.obtenerEstadistica());
        System.out.println(m.toString());
    }
    
}
