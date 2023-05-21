//
package Parciales;

public class Torneo {
    private String nombre;
    private int N;
    private int M;
    private int DL=0;
    private int actualN=0, actualM=0;
    private int cantGoleadores;
    private Goleadores [][]tabla;//contiene para cada fecha goleadores M-1
    private int [] fecha ;//aca tengo que guardar la cantidad de goleadores que se anoten en cada fecha

    public Torneo(String nombre, int N, int M) {
        this.nombre = nombre;
        this.N = N;
  ;
        this.M = M;
        this.cantGoleadores=0;
        tabla=new Goleadores [N][M];
        fecha=new int[N];
        for(int i=0; i<N; i++){
             fecha[i]=cantGoleadores;
        }
        for(int i=0; i<N; i++){
          for(int j=0; j<M; j++){
              tabla[i][j]=null;
          }
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

 

    public int getCantGoleadores() {
        return cantGoleadores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setN(int N) {
        this.N = N;
    }

    public void setM(int M) {
        this.M = M;
    }


    public void setCantGoleadores(int cantGoleadores) {
        this.cantGoleadores = cantGoleadores;
    }

      public boolean estaLleno() {
        return DL == (N * M);
    }
  
      
    public void agregarGoleador(Goleadores g){
            if (!this.estaLleno()) {
            if ((actualM < M) && (DL<M)) {
                tabla[actualN][actualM] = g;
                actualM++;
                DL++;
            } else {
                actualN++;
                actualM = 0;
                tabla[actualN][actualM] = g;
                DL++;
            }
        } else {
            System.out.println("Matriz de goleador lleno");
        }
    }
   public void agregarUNGoleador(int X, Goleadores g){  
       if(!this.estaLleno()){
        if(actualM<M){
         tabla[X][actualM]= g;
         actualM++;
         fecha[X]++;
       }
      }
   }
   public void obtenerGoleador(int X){
      int minGoles=0;
      tabla[N][M]=null;
      for(int i=0; i<M+1;i++){
         if(tabla[X][i].getCantGoles()<minGoles){
               minGoles=tabla[X][i].getCantGoles();
               tabla[X][M]=tabla[X][i];
         }
      }
   }
   
    public int otenerCantGoleadores(){
        int suma=0;
        for(int i=0; i<N; i++){
          for(int j=0; j<M; j++){
              suma= suma+ this.getCantGoleadores();
          }
        }
        return suma;
    }
    
        public void obtenerCantGolPorFecha(){
        int suma;
        for(int i=0; i<N; i++){
            suma=0;
          for(int j=0; j<M; j++){
              suma= suma+ this.getCantGoleadores();
          }
            
        }
    }

    @Override
    public String toString() {
        String aux="Torneo 2022: "+nombre;

        for(int i=0; i<N; i++){
            aux= aux+"\nFecha: #"+(i+1)+"\nCantidad de goleadores de la fecha: ";
            this.obtenerCantGolPorFecha();
            aux= aux+"\n//////////Goleadores/////////";
          for(int j=0; j<M+1; j++){
             aux=aux+tabla[i][j].toString();            
          }
        }
        
      return aux;
    }
}
