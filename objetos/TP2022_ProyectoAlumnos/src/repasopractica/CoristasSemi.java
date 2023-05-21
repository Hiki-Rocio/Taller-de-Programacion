
package repasopractica;

public class CoristasSemi extends Coros{
    private int DM;
    private int DL;
    private Coristas[]Semicircular;

    public CoristasSemi(int DM, String nombre,Director director ) {
        super(nombre,director);
        this.DM = DM;
        this.DL=0;
        Semicircular=new Coristas[DM];
    }

    public int getDM() {
        return DM;
    }


    public int getDL() {
        return DL;
    }


    public  void agregarCorista(Coristas c){
              if(DL < DM){
           Semicircular[DL] = c;
            DL++;
        }else{
            System.out.println("Vector de Coristas lleno");
        }
    }
   public  boolean estaLleno(){
     return DL==DM;
   }
   
   public boolean bienFormado(){
              boolean aux = true;
        int i = 0;
        
        while((i<this.DL) && (aux)){
            aux = Semicircular[i].getTono() > Semicircular[i+1].getTono();
            i++;
        }
        return aux;
   }
 }