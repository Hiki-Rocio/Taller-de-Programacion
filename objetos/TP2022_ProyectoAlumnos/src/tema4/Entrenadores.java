
package tema4;

public class Entrenadores extends Empleados {
    private double cantCampeonatos;
    
    public Entrenadores(double uncantCampeonatos,String unNombre, double unSueldoBasico, int unaAntiguedad){
        super(unNombre, unSueldoBasico, unaAntiguedad);
        setCantCampeonatos(uncantCampeonatos); 
    }

    public double getCantCampeonatos() {
        return cantCampeonatos;
    }

    public void setCantCampeonatos(double cantCampeonatos) {
        this.cantCampeonatos = cantCampeonatos;
    }

    
   public double calcularEfectividad(){
      double promedio;
      promedio= getCantCampeonatos()/super.getAntiguedad();
      return promedio;
    }
    
    public double calcularSueldoAcobrarEntrenadores(){
        double sueldos;
        if((getCantCampeonatos()>=1) && (getCantCampeonatos()<=4)){
            sueldos=super.calcularSueldoAcobrar()+5000;
        }else
           if((getCantCampeonatos()>=5) && (getCantCampeonatos()<=10)){
              sueldos=super.calcularSueldoAcobrar()+30000;
           }else
             sueldos=super.calcularSueldoAcobrar()+50000;
        return sueldos;
    }

    @Override
    public String toString() {
        return super.toString()+" \nCampeonatos ganados:" + cantCampeonatos ;
    }
    
    
    
    
}
