
package tema4;

public class Jugadores extends Empleados {
    private double numPartidos;//puse double para que me de e promedio exacto
    private int numGoles;
    
    public Jugadores(double unNumPartido, int unNumGoles, String unNombre, double unSueldoBasico, int unaAntiguedad){
       super(unNombre,unSueldoBasico,unaAntiguedad);
       setNumPartidos(unNumPartido);
       setNumGoles(unNumGoles);
    }

    public double getNumPartidos() {
        return numPartidos;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumPartidos(double numPartidos) {
        this.numPartidos = numPartidos;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }
    
    
    public double calcularEfectividad(){
        double promedio;
        promedio= getNumGoles()/getNumPartidos();
        return promedio ;
    }
    
    public double calcularSueldoAcobrarJugadores(){
        double sueldo;
       //i el promedio de goles por partido es superior a 0.5 se adiciona un plus de otro sueldo basico
       if(this.calcularEfectividad()>0.5){
         sueldo=super.calcularSueldoAcobrar()+super.getSueldoBasico();
        }
       else
           sueldo=super.calcularSueldoAcobrar();
       return sueldo;
    }

    @Override
    public String toString() {
        return   super.toString()+ "\nNumero de partidos:" +getNumPartidos() + "\nNumero de goles:" + getNumGoles() ;
    }
       
}
