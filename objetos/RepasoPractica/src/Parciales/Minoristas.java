
package Parciales;

public class Minoristas extends Compras {
    private boolean jubilado;

    public Minoristas(boolean jubilado, int numero, int N) {
        super(numero, N);
        this.jubilado = jubilado;
    }

    public boolean isJubilado() {
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }
    
    public double sumaTotal(){
       double suma=0;
       for(int i=0; i<super.getDL();i++){
          suma=suma+super.getProducto()[i].getPrecioMinorista();
       }
       return suma;
    }
    
    public double obtenerPrecio(){
        double precioTotal;
        double suma = this.sumaTotal();
        double adicion = suma * 0.21;
        double descuentoJubilado = suma * 0.1;
        double total = suma + adicion;
        if(this.isJubilado()){
          precioTotal=total-descuentoJubilado;
        }else
          precioTotal=total;
      return precioTotal;
    }

    @Override
    public String toString() {
        return super.toString()+"\nPrecio a pagar: "+this.obtenerPrecio();
    }
    
    
}
