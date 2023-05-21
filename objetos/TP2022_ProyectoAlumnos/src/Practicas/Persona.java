
package Practicas;


public class Persona {
    private String nombre;
    private int Dni;
    private int edad;

    public Persona(String unNombre, int unDni, int unaEdad) {
       setNombre(unNombre);
       setDni(unDni);
       setEdad(unaEdad);
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return Dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int Dni) {
        this.Dni = Dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + "\nDni=" + Dni + "\n Edad=" + edad ;
    }
    
    
    
}
