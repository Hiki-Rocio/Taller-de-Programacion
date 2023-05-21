
package repasopractica;

public abstract class Recitales {
    private String nomBanda;
    private int cantTemas;
    private String [] tema;
    private int DL=0;

    public Recitales(String nomBanda, int cantTemas) {
        this.nomBanda = nomBanda;
        this.cantTemas = cantTemas;
        tema=new String[cantTemas];
    }

    public String getNomBanda() {
        return nomBanda;
    }

    public int getCantTemas() {
        return cantTemas;
    }

    public void setNomBanda(String nomBanda) {
        this.nomBanda = nomBanda;
    }

    public void setCantTemas(int cantTemas) {
        this.cantTemas = cantTemas;
    }

    
    public void agregarTema(String unTema){
       if(DL<cantTemas){
          tema[DL]=unTema;
          DL++;
       }
    }
    
    public void actuar(){//imprime porconsola todos los temas
     for(int i=0;i<DL;i++){
         System.out.println("y ahora tocaremos "+tema[i]);
     }
     
    }
    
    public abstract double calcularCosto();
    
}
