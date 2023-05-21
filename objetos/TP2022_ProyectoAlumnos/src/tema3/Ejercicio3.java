/*
3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”.
C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
almacenen como máximo N libros? ¿Cómo instanciaría el estante?
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ejercicio3 {

    public static void main(String[] args) {
      // int numLibros;
     //  int numAutores;
       Estantes e= new Estantes();
       int DL=0;
       
   /*    GeneradorAleatorio.iniciar();
       //leo todos los datos comenzando con los del autor
       System.out.println("Indique la cantidad de Autores que desee agregar: ");
       numAutores=Lector.leerInt();
       
       Autor autor[]= new Autor[numAutores];
       for(int i=0;i<numAutores;i++){
          autor[i]= new Autor("Kakca", GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarString(5));
       }
      
       System.out.println("Indique la cantidad de libros que desee agregar: ");
       numLibros=Lector.leerInt();
       Libro libro[]= new Libro [numLibros];
       for(int i=0;i<numLibros;i++){
          libro[i]=new Libro( "Mujercitas","Kapeluz",GeneradorAleatorio.generarInt(4), autor[i], GeneradorAleatorio.generarString(4), GeneradorAleatorio.generarDouble(1000));
          e.Agregar(libro[i]);
       }
       for(int i=0;i<numLibros;i++){
       e.buscarLibro("Mujercitas"); 
       System.out.println("Autor del libro Mujercitas: " + autor[i].toString());
        }
    }*/
    Autor a= new Autor();
    Libro libro= new Libro ();
    
     GeneradorAleatorio.iniciar();
       //leo todos los datos comenzando con los del autor
       Autor a1= new Autor("Kakca", GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarString(5));
       Libro libro1=new Libro( "Mujercitas",GeneradorAleatorio.generarString(5),GeneradorAleatorio.generarInt(4), a1, GeneradorAleatorio.generarString(4), GeneradorAleatorio.generarDouble(1000));
       e.Agregar(libro1);
       DL++;
       System.out.println("Libro------------"+DL);
       System.out.println(libro1.toString());
       System.out.println(a1.toString());
       Autor a2= new Autor("Eduar", GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarString(5));
       Libro libro2=new Libro( "Volcanes",GeneradorAleatorio.generarString(5),GeneradorAleatorio.generarInt(4), a2, GeneradorAleatorio.generarString(4), GeneradorAleatorio.generarDouble(1000));
       e.Agregar(libro2);   
       DL++;
       System.out.println("Libro------------"+DL);
       System.out.println(libro2.toString());
       System.out.println(a2.toString());
       
       Autor a3= new Autor("Tolkien", GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarString(5));
       Libro libro3=new Libro( "Golum",GeneradorAleatorio.generarString(5),GeneradorAleatorio.generarInt(4), a3, GeneradorAleatorio.generarString(4), GeneradorAleatorio.generarDouble(1000));
       e.Agregar(libro3);  
       DL++;
       System.out.println("Libro------------"+DL);
       System.out.println(libro3.toString());
       System.out.println(a3.toString());
       System.out.println("-------------------Informe-------------------");
       System.out.println("Datos del Autor del libro "+e.buscarLibro("Mujercitas").getTitulo() + ": "+ e.buscarLibro("Mujercitas").getPrimerAutor() );
    }
}
