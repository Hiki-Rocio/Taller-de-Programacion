
package repasopractica;

public class Coristas {
    private String nomCorista;
    private int DNI;
    private int edad;
    private int tono;

    public Coristas(String nomCorista, int DNI, int edad, int tono) {
        this.nomCorista = nomCorista;
        this.DNI = DNI;
        this.edad = edad;
        this.tono = tono;
    }

    public String getNomCorista() {
        return nomCorista;
    }

    public void setNomCorista(String nomCorista) {
        this.nomCorista = nomCorista;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }

   

    
}
