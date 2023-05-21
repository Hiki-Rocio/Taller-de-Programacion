
package Parciales;

public class Mayoristas extends Compras{
    private int cuit;

    public Mayoristas(int cuit, int numero, int N) {
        super(numero, N);
        this.cuit = cuit;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    
        public double sumaTotal(){
       double suma=0;
       for(int i=0; i<super.getDL();i++){
          suma=suma+super.getProducto()[i].getPrecioMayorista();
       }
       return suma;
    }
        
     public double obtenerPrecio(){
       double descuento= this.sumaTotal()*0.21;
       double precioTotal  = this.sumaTotal()- descuento;
       return precioTotal ;
     }

    @Override
    public String toString() {
        return super.toString()+"\nPrecio a pagar: "+this.obtenerPrecio();
    }
     
     
}
