/*
Una escuela de música necesita un sistema para realizar un concurso entre sus alumnos. El 
concurso está dividido en cinco géneros musicales y en cada género se pueden inscribir hasta N 
alumnos como máximo. De cada alumno registra su nombre, edad, el instrumento que toca y 
puntaje obtenido. 
1- Genere las clases necesarias. Implemente constructores para iniciar el concurso sin alumnos 
inscriptos, recibiendo N (el máximo de alumnos por género musical). Los alumnos deben 
instanciarse dando valor a todos sus atributos.
2- Implemente métodos en las clases que corresponda para permitir: 
a. Dado un alumno y un género musical válido, inscriba al alumno en dicho género. Asuma que 
hay lugar. 
b. Dado un género musical válido G, un nombre de alumno N y un puntaje P, asignarle el puntaje 
P al alumno N del género G. Considere que el alumno puede no existir. 
c. Devolver al alumno que haya obtenido el mayor puntaje en todo el concurso. 
d. Devolver un String que contenga la representación del concurso, siguiendo el formato: 
 “Genero 1 – Total inscriptos: X – representación del alumno 1 - … - representación del alumno X 
 … 
 Genero 5 – Total inscriptos: Y – representación del alumno 1 - … representación del alumno Y 
 Alumno de mayor puntaje es: representación del alumno de mayor puntaje” 
3- Realice un programa que instancie un concurso con un máximo de 20 alumnos por género. 
Instancie 5 alumnos e inscriba a cada uno en algún género musical. Asigne puntajes. Imprima la 
representación del concurso. 

 */
package tema3;

import PaqueteLectura.Lector;

public class Adicional {

    public static void main(String[] args) {
        Concursos C = new Concursos();
        String n, inst;
        int e,p;
        for (int i = 0; i < 5; i++) {
            System.out.println("---");
            System.out.println("Alumno: " + (i + 1));


        System.out.println(" ");
        System.out.print(" -> Ingrese Nombre del alumno: ");
        n = Lector.leerString();
        System.out.print(" -> Ingrese Instrumento del alumno: ");
        inst = Lector.leerString();
        System.out.print(" -> Ingrese Edad del alumno: ");
        e = Lector.leerInt();       
 
        Alumnos alum =new Alumnos(n,e,inst);            
            System.out.println(" ");
            System.out.println("----------------------inscripcion----------- ");
            System.out.print(" -> Genero que desea inscribirse el alumno: ");
            int g = Lector.leerInt();
            C.inscribirAlumno(alum, g);
            System.out.println("---");
        }       
         
        for (int i = 0; i < 5; i++) {
            int punt;
            String nom;
            int g;
            System.out.println("--ASIGNACION DE PUNTAJES------");
            System.out.print(" -> Ingrese Nombre del alumno: ");
            nom = Lector.leerString();
            System.out.print(" -> Ingrese Genero: ");
            g = Lector.leerInt();            
            System.out.print(" -> Ingrese Puntaje actual: ");
            punt = Lector.leerInt();

            C.actualizarPuntaje(g, nom, punt);
            System.out.println("---");
        }

        System.out.println(C.toString());
    }
    
}
