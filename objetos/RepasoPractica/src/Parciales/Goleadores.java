
package Parciales;

public class Goleadores {
    private String nombre;
    private String nomEquipo;
    private int CantGoles;

    public Goleadores(String nombre, String nomEquipo, int CantGoles) {
        this.nombre = nombre;
        this.nomEquipo = nomEquipo;
        this.CantGoles = CantGoles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public int getCantGoles() {
        return CantGoles;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public void setCantGoles(int CantGoles) {
        this.CantGoles = CantGoles;
    }

    @Override
    public String toString() {
        return  "\nNombre:" + nombre + "\nNombre del Equipo: " + nomEquipo + "\nCantidad de goles: " + CantGoles ;
    }
    
    
}
