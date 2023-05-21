
package Parciales;

public class Participante {
    private String nombre;
    private int Edad;
    private int DNI;

    public Participante(String nombre, int Edad, int DNI) {
        this.nombre = nombre;
        this.Edad = Edad;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public int getDNI() {
        return DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    

}
