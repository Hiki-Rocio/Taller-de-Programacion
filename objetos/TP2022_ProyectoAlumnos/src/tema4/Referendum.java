
package tema4;


public class Referendum extends Urnas {
    private int votosAfavor;
    private int votosEncontra;

    public Referendum( int U, Zona Z) {
        super(U, Z);
        this.votosAfavor=0;
        this.votosEncontra=0;
    }

    public int getVotosAfavor() {
        return votosAfavor;
    }

    public int getVotosEncontra() {
        return votosEncontra;
    }

    public void setVotosAfavor(int votosAfavor) {
        this.votosAfavor = votosAfavor;
    }

    public void setVotosEncontra(int votosEncontra) {
        this.votosEncontra = votosEncontra;
    }
    
    public void  votarAFavor(){
        this.setVotosAfavor(getVotosAfavor()+1);
    }
    
    public void votarEnContra(){ //como la cantidad de votos esta en cero debo cambiar esos votos por a cntidad que sume por eso uso el set
       this.setVotosEncontra(this.getVotosEncontra()+1);
    }
    
    @Override
    public int calcularGanador(){
        int aux=0;
        if(getVotosAfavor()>getVotosEncontra()){
           aux=1;
        }else
           if(getVotosAfavor()<getVotosEncontra()){
               aux=-1;
           }      
      return aux;
    }
    
    public int  calcularTotalVotos(){
     return super.getVotosB()+getVotosAfavor()+getVotosEncontra();
    }

}

