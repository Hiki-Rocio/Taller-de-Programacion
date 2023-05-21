
package repasopractica;

public abstract class Coros {
    private String  nombre;
    private Director director;

    public Coros(String nombre, Director director) {
        this.nombre = nombre;
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    public abstract void agregarCorista(Coristas c);
    
    public abstract boolean estaLleno();
    public abstract boolean bienFormado();

}
