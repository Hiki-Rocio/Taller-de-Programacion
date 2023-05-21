
package tema4;

public class Zona {
    private String Localidad;
    private String Partido;
    private String Provincia;

    public Zona(String unaLocalidad, String unPartido, String unaProvincia) {
        this.Localidad = unaLocalidad;
        this.Partido = unPartido;
        this.Provincia = unaProvincia;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public String getPartido() {
        return Partido;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public void setPartido(String Partido) {
        this.Partido = Partido;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    @Override
    public String toString() {
        return "Localidad: " + Localidad + "\nPartido=" + Partido + "\nProvincia:" + Provincia ;
    }
   
    
    
    
}
