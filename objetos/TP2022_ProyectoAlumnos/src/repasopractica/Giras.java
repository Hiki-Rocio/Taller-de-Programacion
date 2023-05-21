
package repasopractica;

public class Giras extends Recitales{
    private String nomGira;
    private int cantFechas;
    private Fechas [] fecha;
    private int actual;
    private int DL=0;

    public Giras(String nomGira, int cantFechas, String nomBanda, int cantTemas) {
        super(nomBanda, cantTemas);
        this.nomGira = nomGira;
        this.cantFechas = cantFechas;
        fecha= new Fechas[cantFechas];
        actual=0;
    }

    public String getNomGira() {
        return nomGira;
    }

    public int getCantFechas() {
        return cantFechas;
    }

    public int getActual() {
        return actual;
    }

    public void setNomGira(String nomGira) {
        this.nomGira = nomGira;
    }

    public void setCantFechas(int cantFechas) {
        this.cantFechas = cantFechas;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
    
    public void agregarFecha(Fechas unaFecha){
      if(DL<cantFechas){
         fecha[DL]=unaFecha;
         DL++;
      }
    }
    
    public void actuar(){
        System.out.println("Buenas noches "+ fecha[actual].getCiudad());
        System.out.println("Listado de temas----------");
        super.actuar();
        actual++;
    }
    
    public double calcularCosto(){
       return cantFechas*30000;// me dan la cantidad de fechas eso es fijo por eso no pongo DL
    }
}
