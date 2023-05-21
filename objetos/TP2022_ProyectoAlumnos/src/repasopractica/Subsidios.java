
package repasopractica;

public class Subsidios {
    private double montoPedido;
    private String motivo;
    private boolean otorgado;

    public Subsidios(double unMontoPedido, String unMotivo) {
        this.montoPedido = unMontoPedido;
        this.motivo = unMotivo;
        this.otorgado=false;
        
    }   

    public double getMontoPedido() {
        return montoPedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean b) {
        this.otorgado = b;
    }
    
        public void setMontoPedido(double montoPedido) {
        this.montoPedido = montoPedido;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
