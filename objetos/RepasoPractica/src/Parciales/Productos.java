
package Parciales;

public class Productos {
    private int codigo;
    private double precioMayorista;
    private double precioMinorista;

    public Productos(int codigo, double precioMinorista,double precioMayorista) {
        this.codigo = codigo;
        this.precioMinorista = precioMinorista;
        this.precioMayorista = precioMayorista;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecioMayorista() {
        return precioMayorista;
    }

    public double getPrecioMinorista() {
        return precioMinorista;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecioMayorista(double precioMayorista) {
        this.precioMayorista = precioMayorista;
    }

    public void setPrecioMinorista(double precioMinorista) {
        this.precioMinorista = precioMinorista;
    }
    
    
    @Override
    public String toString(){
        String aux;
        aux="\nCodigo: "+codigo+"\nPrecio minorista: "+precioMinorista+"\nPrecio mayorista: "+precioMayorista;
    return aux;
    }
}
