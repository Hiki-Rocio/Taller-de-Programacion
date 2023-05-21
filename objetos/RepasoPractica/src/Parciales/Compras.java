
package Parciales;

public abstract class Compras {
    private int numero;
    private int cantProductos;
    private int DL;
    private Productos[] producto;

    public Compras(int numero, int N) {
        this.numero = numero;
        this.cantProductos = N;
        this.DL=0;
        producto= new Productos[N];
        for(int i=0; i<N; i++){
           producto[i]=null;
        }
    }

    public int getDL() {
        return DL;
    }

    public Productos[] getProducto() {
        return producto;
    }

    public void setProducto(Productos[] producto) {
        this.producto = producto;
    }

    public void setDL(int DL) {
        this.DL = DL;
    }

    public int getNumero() {
        return numero;
    }

    public int getCantProductos() {
        return cantProductos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCantProductos(int cantProductos) {
        this.cantProductos = cantProductos;
    }
    
    public void agregarProducto(Productos prod){
          producto[DL]=prod;
          DL++;
       
    }
    public abstract double obtenerPrecio();

    @Override
    public String toString() {
        String aux="Numero--------->"+numero;
        for(int i=0; i<DL; i++){
                aux= aux+ "\n Productos: "+producto[i].toString();           
        }     
        return aux;
    }
    
    
    
}
