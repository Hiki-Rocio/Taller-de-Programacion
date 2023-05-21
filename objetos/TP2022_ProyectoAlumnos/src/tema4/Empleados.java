
package tema4;

public abstract class Empleados {
    private String nombre;
    private double sueldoBasico;
    private int antiguedad;

    public Empleados(String nombre, double sueldoBasico, int antiguedad) {
        setNombre(nombre);
        setSueldoBasico(sueldoBasico);
        setAntiguedad(antiguedad);
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "\nEmpleado: " + "\nnombre=" + nombre + "\nSueldo a cobrar: "+this.calcularSueldoAcobrar() + "\nEfectividad: "+this.calcularEfectividad()+"\n Antiguedad: "+this.getAntiguedad() ;
    }
    
    public abstract double calcularEfectividad();
       
    public  double calcularSueldoAcobrar(){
       double sueldo=(getSueldoBasico()+(getSueldoBasico()*0.1))/getAntiguedad();         
       return sueldo;
    }
    
    
 }
