
package repasopractica;

public class Eventos extends Recitales{
    private String motivo;
    private String contratante;
    private String dia;

    public Eventos(String motivo, String contratante, String dia, String nomBanda, int cantTemas) {
        super(nomBanda, cantTemas);
        this.motivo = motivo;
        this.contratante = contratante;
        this.dia = dia;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getContratante() {
        return contratante;
    }

    public String getDia() {
        return dia;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    public void actuar(){
      
      if("Show da beneficio".equals(motivo)){
          System.out.println("Recuerden colaborar con "+getContratante());
          
      }else
          if("Show de TV".equals(motivo)){
              System.out.println("Saludos amigos televidentes ");
          }else
              if("Privado".equals(motivo)){
                  System.out.println("Un feliz cumple para "+getContratante());
              }
      System.out.println("Listado de temas------------");
      super.actuar();
    }
    
    public double calcularCosto(){
       double Aux=0;
       if("Show a beneficio".equals(motivo)){
         Aux=0;
       }else
           if("Show de TV".equals(motivo)){
             Aux=50000;
           }else
                if("Show privado".equals(motivo)){
                  Aux= 150000;
                }
      return Aux; 
    }
}
