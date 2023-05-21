
package Parciales;

public class Funciones {
    private String titulo;
    private String fecha;
    private String hora;
    private int N;
    private int M;
    private Butacas[][] sala;

    public Funciones(String titulo, String fecha, String hora, int unN, int unM) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.N = unN;
        this.M = unM;
        this.sala = new Butacas[N][M];
        for(int i=0;i<N; i++){
          for(int j=0;j<M; j++){
              sala[i][j] = new Butacas(i,j);        
          }
        }
    }
    
    public double OcuparButaca(int f, int b){
        if(!sala[f][b].isEstado())
            sala[f][b].setEstado(true);
        return sala[f][b].getPrecio();
    }
    
    public void DesocuparButacas(int f){
        for(int i=0; i<M; i++)
            sala[f][i].setEstado(false);
    }
    
    public String ObtenerButacasNroB(int b){
        String aux = "";
        for(int i=0; i<N; i++)
            aux = aux + "\nREPERESENTACION ---"+"\n" + sala[i][b].toString()+"\n ";
        return aux;
    }
    
    public String toString(){
        String aux = "\n " + this.titulo + " " + this.fecha + " " + this.hora;
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                aux = aux + "\n" + sala[i][j].toString();
        return aux;
    }
}