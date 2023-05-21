
package tema4;


public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;
   
    public Figura(String unCR, String unCL){
        setColorRelleno(unCR);
        setColorLinea(unCL);
    }
    @Override
    public String toString(){
        String aux = "\nPerimetro: " + this.calcularPerimetro() +
                     "\nArea: " + this.calcularArea() +
                     "\nCR: "  + getColorRelleno() + 
                      "\nCL: " + getColorLinea();             
             return aux;
       }

    
    public String getColorRelleno(){
        return colorRelleno;       
    }
    public void setColorRelleno(String unColor){
        colorRelleno = unColor;       
    }
    public String getColorLinea(){
        return colorLinea;       
    }
    public void setColorLinea(String unColor){
        colorLinea = unColor;       
    }
    public void  despintar(){
           setColorLinea("Negra");
           setColorRelleno("Blanco");
    }
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}
