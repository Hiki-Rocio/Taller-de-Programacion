/*
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que hay almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
 */
package tema3;

public class Estantes {
    private int DF= 20;
    private int DL=0;
    private Libro[] libro;

    public Estantes() {
        this.libro = new Libro[DF];
    }
    
    public int getAlmacenados(){//dimension logica
       return DL;
    }
    
    public boolean estaLleno(){
       return DL == DF;
    }
    
    public void  Agregar(Libro libros){
       
      if(DL<DF){
          libro[DL]=libros;
          DL++;
      }
    }
    
    public Libro buscarLibro(String unTitulo){
        int i;
        Libro aux=null;
        for(i=0;i<DL; i++){
            if(this.libro[i].getTitulo().equals(unTitulo))
                aux=this.libro[i];
        }
        return aux;
    }
    
    
}
