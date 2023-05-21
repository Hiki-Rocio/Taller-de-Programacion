
package repasopractica;

public class Autos {
    private String nomDueño;
    private String patente;

    public Autos(String nomDueño, String patente) {
        this.nomDueño = nomDueño;
        this.patente = patente;
    }

    public String getNomDueño() {
        return nomDueño;
    }

    public String getPatente() {
        return patente;
    }

    public void setNomDueño(String nomDueño) {
        this.nomDueño = nomDueño;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "\nNombre del dueño del Auto: " + nomDueño + "\nPatente: " + patente ;
    }
    

}
