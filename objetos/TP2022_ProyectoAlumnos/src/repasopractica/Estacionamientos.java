
package repasopractica;

public class Estacionamientos {
    private String nombre;
    private String direccion;
    private String horaApertura;
    private String horaCierre;
    private int piso;
    private int plaza;
    private Autos[][]matriz;

    public Estacionamientos(String nombre, String direccion) {
        int piso=5;
        int plaza=10;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = "8:00";
        this.horaCierre = "21:00";
        matriz=new Autos[piso][plaza];
        for(int i=0;i<piso;i++){
          for(int j=0; j<plaza; j++){
               matriz[i][j]=null;          
          }
        }
    }

    public Estacionamientos(String nombre, String direccion, String horaApertura, String horaCierre, int N, int M) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.piso = N;
        this.plaza = M;
        matriz=new Autos[N][M];
        for(int i=0;i<N;i++){
          for(int j=0; j<M; j++){
               matriz[i][j]=null;          
          }
        }
    }


    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }
    
    public void guardarAuto(Autos A, int X, int Y ){
             matriz[X][Y]= A;
      }
      
    public String BuscarAuto(String patente){
        int i=0;
        int j=0;
        String aux;
       while(i<piso && !(matriz[i][j]!=null && matriz[i][j].getPatente().equals(patente)) ){
            while (j<plaza && !(matriz[i][j]!=null && matriz[i][j].getPatente().equals(patente))){
                if (!(matriz[i][j]!=null && matriz[i][j].getPatente().equals(patente))) 
                    j++;//voy a seguir buscando por todas las plazas
            }
           if (j==4){
                j=0;
                i++;
           }
       }
        if (i<piso && j<plaza && (matriz[i][j]!=null && matriz[i][j].getPatente().equals(patente))) 
                  aux="Piso: "+(i+1)+"  Plaza: "+(j+1);
        else aux="Auto inexistente";
        return aux;       
    }
    
    public int contarAutos(int Y){
        int cant=0;
        int i;
        for (i=0;i<piso;i++){
            if (matriz[i][Y]!=null)
                cant++;
        }
        return cant;
    }
    

    @Override
    public String toString() {
        String aux="";        
        for(int i=0;i<piso; i++){
             aux=aux+"Estacionamiento:" + getNombre() + "----Piso:" + (i+1)+"\n" ;
            for(int j=0; j<plaza; j++){
               aux=aux+"\nPlaza: "+(j+1);
               if(matriz[i][j]==null){
                  aux=aux+"Lugar libre.";
               }else
                  aux=aux+matriz[i][j].toString();
                  aux = aux + "\n"; 
            }
        }
        return aux;
    }
    
    
    
}
