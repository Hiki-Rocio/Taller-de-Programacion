
package repasopractica;

public class Investigadores {
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidios []vectorS;
    private int DF = 5;
    private int DL = 0;
    
    
    public Investigadores(String unNombre, int unaCategoria, String unaEspecialidad) {
        this.nombre = unNombre;
        this.especialidad = unaEspecialidad;
        this.categoria=unaCategoria;
        vectorS= new Subsidios[DF];
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getCategoria() {
        return categoria;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public void agregarSubsidio(Subsidios unSubsidio){///////////
       if(DL<DF){
         vectorS[DL]=unSubsidio;
         DL++;
       }else
            System.out.println("El vector subsidios esta lleno");
    }
    
    public double totalDinero(){//aca suumo solo los subcidios una sola vez 
     double Total=0;
     for(int i=0; i<DL;i++){
         if(vectorS[i].isOtorgado()){
             System.out.println(getNombre() + " | "+ (i+1)+" | otorgado?: "+ vectorS[i].isOtorgado() );
        Total=Total+vectorS[i].getMontoPedido();
         }
     }
     return Total;
    }
    
    public void otorgarSubsidios(){
        for(int i = 0; i < DL; i++){
            System.out.println(vectorS[i].getMotivo());
            vectorS[i].setOtorgado(true);
        }
    }
    
}
