
package Parciales;

public class Butacas {
    private String descriptor;
    private double precio;
    private boolean estado;

    public Butacas(int f, int b) {
        this.estado=false;
        this.precio=800*100*f;
        this.descriptor="Butaca "+f+"."+b;
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

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    @Override
    public String toString(){
       return"Descripcion: "+descriptor+"\nPrecio: "+precio+"\nEstado: "+estado;
    }
}
