
package tema3;

public class Circulo {
    private double radio;
    private String colorR;
    private String colorL;

    public Circulo(double radio, String colorR, String colorL) {
        this.radio = radio;
        this.colorR = colorR;
        this.colorL = colorL;
    }

    public Circulo() {
    }

    public double getRadio() {
        return radio;
    }

    public String getColorR() {
        return colorR;
    }

    public String getColorL() {
        return colorL;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColorR(String colorR) {
        this.colorR = colorR;
    }

    public void setColorL(String colorL) {
        this.colorL = colorL;
    }
    
    
    /*- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)*/
    
    public double calcularPerimetro(){
        double perimetro;
        perimetro= 2*Math.PI*radio;
        return perimetro;
    }
    
    public double calcularArea(){
      double area;
      area= Math.PI*radio*radio;
      return area;
    }
    
    @Override
    public String toString(){
     return "Perimetro: "+calcularPerimetro()+"  || Area: "+calcularArea();
    }
}
