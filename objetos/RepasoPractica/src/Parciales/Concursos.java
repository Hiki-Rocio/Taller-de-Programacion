
package Parciales;

public class Concursos {
    private int N;
    private int DL;
    private Parejas []pareja;

    public Concursos(int N) {
        this.N = N;
        this.DL=0;
        pareja= new Parejas[N];
    }
    
    public void agregarPareja(Parejas p){
       if(DL<N){
           pareja[DL]= p;
           DL++;
       }
    }
   
    public Parejas max(){
     int maxDif=-1;
     Parejas aux =null;
     for(int i=0; i<DL; i++){
         if(pareja[i].diferenciaEdad()>maxDif){
              maxDif=pareja[i].diferenciaEdad();
              aux =pareja[i];
         }         
     }
     return aux;
    }
  }
