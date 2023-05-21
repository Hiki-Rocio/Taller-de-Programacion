
package Parcial1;

public class Butacas {
    private String descripcion;
    private double precio;
    private boolean estado;
    
    public Butacas(int f,int b){
     this.estado=false;
     this.precio=800*100*f;
     this.descripcion="Butaca: "+f+"."+b;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "\nDescripcion=" + descripcion + ", precio=" + precio + ", estado=" + estado + '}';
    }

  
    
    
}
