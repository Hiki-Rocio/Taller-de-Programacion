/*5-A- Modifique la clase VisorFiguras: ahora debe permitir guardar las figuras a mostrar (a 
lo sumo 5) y también mostrar todas las figuras guardadas. Use la siguiente estructura*/
package tema4;

public class VisorFiguras2 {
    private int mostradas;
    private int guardadas;
    private int capacidadMaxima=5;
    private Figura [] vector;
    int DL=0;
  
 public VisorFiguras2(){   
     vector= new Figura[ capacidadMaxima];
     guardadas=0;

 }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getDL() {
        return DL;
    }

    public void setDL(int DL) {
        this.DL = DL;
    }
 
 public void guardar(Figura f){     
  if(guardadas<  capacidadMaxima){
         vector[DL]=f;
         guardadas++;
}
 }
 
     
 public boolean quedaEspacio(){
     boolean Espacio;
    if(DL< capacidadMaxima){
       Espacio=true;
    }else{
       Espacio=false;
    }
     return Espacio;
 }
 
 public void mostrar(Figura f){
    System.out.println(f.toString()); 
    mostradas++;
 }
  /*public void mostrarVector(){//vector que me imprime el vector figuras
     for (int i=0; i<getDL();i++){
         System.out.println(" ");
         System.out.println("Figura numero "+(i+1));
             System.out.println(vector[i].toString()); 
     }
 }**/
 
  
 public int getGuardadas() {
 return guardadas;
 }
  public int getMostradas() {
 return mostradas;
 }
}
