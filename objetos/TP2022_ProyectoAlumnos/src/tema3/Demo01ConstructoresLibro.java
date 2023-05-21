  /*
Demo que crea objetos Libro invocando a los constructores definidos. 
 */
package tema3;

import PaqueteLectura.Lector;

/**
 *
 * @author vsanz
 */
public class Demo01ConstructoresLibro {

    public static void main(String[] args) {
        Autor a1= new Autor();
        a1.setNombre("Herbert Schildt");
        a1.setBiografia("...");
        a1.setOrigen("...");
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                "Mcgraw-Hill", 2014,   
                                 a1, "978-0071809252", 21.72);
        Autor a2= new Autor();
        a2.setNombre("John Horton");
        a2.setBiografia("...");
        a2.setOrigen("...");        
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               a2, "978-1512108347");
        System.out.println("  ");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        //Libro libro3= new Libro(); 
        System.out.println("--------------------Datos del autor---------------------------");
        System.out.println(libro1.getPrimerAutor().toString());
    }
    
}
