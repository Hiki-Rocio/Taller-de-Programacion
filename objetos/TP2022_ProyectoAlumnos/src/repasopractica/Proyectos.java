
package repasopractica;

public class Proyectos {
     private String nombre;
     private int cod;
     private String nomDirector;
     private Investigadores[] vector;
     int DF=50;
     int DL=0;

    public Proyectos(String unNombre, int unCod, String unNomDirector) {
        this.nombre = unNombre;
        this.cod = unCod;
        this.nomDirector = unNomDirector;
        
        vector = new Investigadores[DF]; 
    }

    public String getNombre() {
        return nombre;
    }

    public int getCod() {
        return cod;
    }

    public String getNomDirector() {
        return nomDirector;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setNomDirector(String nomDirector) {
        this.nomDirector = nomDirector;
    }
     
    
   public void agregarInvestigador(Investigadores unInvestigador){
     if(DL<DF){
          vector[DL]=unInvestigador;
          DL++;
      }else
           System.out.println("Vector lleno");
   }
   
   public double dineroTotalOtorgado() {
        double total = 0;
        for (int i = 0; i < DL; i++) {
            Investigadores iActual = vector[i];
            total = total + iActual.totalDinero();//sumo todos los subcidios de todos los investigadores
        }

        return total;
    }
   
    private Investigadores buscarInvestigadorPorNombre(String nom) {
        int i = 0;
        boolean esta = false;
        Investigadores I = null;

        while ((i < DL) && (!esta)) {
            if (vector[i].getNombre().equals(nom)) {
                esta = true;
                I = vector[i];
            } else {
                i++;
            }
        }

        return I;
    }
       public void otorgarTodos(String nombre_completo){
        Investigadores I = buscarInvestigadorPorNombre(nombre_completo);
        if (I != null) {
            System.out.println(I.getNombre());

            I.otorgarSubsidios();
        }
       }

  
    public String toString() {
        String aux="Proyecto: " + nombre + "\nCodigo: " + cod + "Nombre Director: " + getNomDirector()+ "Total de dinero otrogado: "+dineroTotalOtorgado();
        for (int i = 0; i < DL; i++) {  
        Investigadores IActual = vector[i];
            aux = aux + " -> Nombre Investigador: " + IActual.getNombre() + " | Categoria: " + IActual.getCategoria() + " | Especialidad: " + IActual.getEspecialidad() + " | Todal dinero de subsidios otorgados: " + IActual.totalDinero() + "" + " \n";
        }

        return aux;
    }    
}
