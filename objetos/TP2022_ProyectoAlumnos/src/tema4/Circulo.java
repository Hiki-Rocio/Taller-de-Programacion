
package tema4;

public class Circulo extends Figura {
    private double radio;
    
    public Circulo(double unRadio, String unColorR, String unColorL){    
        super(unColorR,unColorL);
        setRadio(unRadio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo--->" + "radio: " + radio + super.toString();
    }
    
    public double calcularPerimetro(){
        double p;
        p= 2*Math.PI*radio;
        return p;
    }
    
    public double calcularArea(){
      double area;
      area= Math.PI*radio*radio;
      return area;
    }
    
}
