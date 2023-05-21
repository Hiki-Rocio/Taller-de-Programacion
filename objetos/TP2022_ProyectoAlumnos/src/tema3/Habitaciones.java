/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author admin
 */
public class Habitaciones {
    private double costoNoche;
    private boolean ocupada;
    private Cliente cliente;

    //inicializo 
    public Habitaciones(double c) {
        this.costoNoche=c;
        this.ocupada=false;
    }

    public double getCostoNoche() {
        return costoNoche;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void aumentarPrecio(double x){
       costoNoche= costoNoche+x;
    }
    @Override
   public String toString(){
       String aux;
       if(isOcupada()){
          aux="Costo por noche es: "+costoNoche+"|| Esta ocupada por  "+cliente.toString();
       }
       else{
          aux="Bienvenido al hotel la habitacion se encuentra libre y su costo por noche es: "+costoNoche;
       }
       return aux;
   }

    
}
