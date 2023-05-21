
package tema4;


public abstract class Urnas {
    private int num;
    private int votosB;
    private Zona zona;

    public Urnas(int U, Zona Z) {
        this.num = U;
        this.votosB =0;
        this.zona = Z;
    }

    public int getNum() {
        return num;
    }

    public int getVotosB() {
        return votosB;
    }

    public Zona getZona() {
        return zona;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setVotosB(int votosB) {
        this.votosB = votosB;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    public  void votarEnBlanco(){
       votosB++;
    }
    
    public abstract int  calcularGanador();
     public abstract int calcularTotalVotos();
     
    @Override
   public String toString(){
       return "“Urna:" + getNum()+"\nZona: " + getZona().toString()+ ". Total Votos: "+ this.calcularTotalVotos() + ". Ganador: "+this.calcularGanador();
   }
}