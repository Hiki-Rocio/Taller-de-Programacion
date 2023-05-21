
package tema4;

public class Trabajadores extends Persona {
    private String tarea;
    
    public Trabajadores (String unaTarea,String unNombre, int unDNI, int unaEdad){
       super(unNombre,unDNI, unaEdad);
       setTarea(unaTarea);
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return super.toString()+" Soy "  + tarea ;
    }
    
    
}
