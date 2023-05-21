
package tema4;

public class Electorales extends Urnas{
    private int cantL;
    private Lista[]votos;//vector contador
    
   public Electorales(int L,int U, Zona Z){
      super(U, Z);
      cantL=L;
      votos = new Lista[L];
      for(int i=0; i<L;i++){
         votos[i]=new Lista();//lista vacia
      }
   }

    public int getCantL() {
        return cantL;
    }
   
    public boolean validarNumeroDeLista(int N){//si esta dentro del rango de lacantidad de listas como empieza de 0 a L PERTENECERIA  a un numero de urna
       return (N >= 0) && (N < getCantL());
    }
    
    public void votarPorLista(int I){//buscamos I dentro del rango con  meteodo anterior
       if (validarNumeroDeLista(I)) {
            votos[I].setCantVotos(votos[I].getCantVotos() + 1);
            System.out.println("Votaste la lista: " + I);
        } else {
            super.votarEnBlanco();
            System.out.println("Votaste en blanco");

        }
    }
    
    public int devolverVotosPorLista(int I){
      int aux=0;
      if(validarNumeroDeLista(I)){
          aux=votos[I].getCantVotos();
      }
       return aux; 
    }
    
    @Override
    public int calcularGanador(){
        int aux=0;
        int maxVotos = -1;
        for (int i = 0; i < getCantL(); i++) {
            if (votos[i].getCantVotos() > maxVotos) {
                maxVotos = votos[i].getCantVotos();
                aux = i;
            }
        }
        return aux;  
    }
    
     public int calcularTotalVotos (){
         int aux = super.getVotosB();
         for (int i = 0; i < getCantL(); i++){
             aux = aux + votos[i].getCantVotos();
         }
         return aux;
     }
}
