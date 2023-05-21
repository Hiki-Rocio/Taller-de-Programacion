
package Parciales;

public class Parejas {
    private Participante p1;
    private Participante p2;
    private String estilo;

    public Parejas(Participante p1, Participante p2, String estilo) {
        this.p1 = p1;
        this.p2 = p2;
        this.estilo = estilo;
    }

    public Participante getP1() {
        return p1;
    }

    public void setP1(Participante p1) {
        this.p1 = p1;
    }

    public Participante getP2() {
        return p2;
    }

    public void setP2(Participante p2) {
        this.p2 = p2;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    
    public int diferenciaEdad(){
      int diferencia;
       if(p1.getEdad()>p2.getEdad()){
           diferencia = p1.getEdad()-p2.getEdad();
       }else
           diferencia= p2.getEdad()-p1.getEdad();
      return diferencia;
   }
    

}
