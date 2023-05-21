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
public class Triangulo {
    private double lado1,lado2,lado3;
    private String ColorRelleno,ColorLinea;

    public Triangulo(double lado1, double lado2,double lado3, String ColorRelleno, String ColorLinea) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado2 = lado3;
        this.ColorRelleno = ColorRelleno;
        this.ColorLinea = ColorLinea;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public String getColorRelleno() {
        return ColorRelleno;
    }

    public String getColorLinea() {
        return ColorLinea;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public void setColorRelleno(String ColorRelleno) {
        this.ColorRelleno = ColorRelleno;
    }

    public void setColorLinea(String ColorLinea) {
        this.ColorLinea = ColorLinea;
    }
    
    public double calcularPerimetro(){
        return lado1+lado2+lado3;
   }
    public double calcularArea(){
      double aux=this.calcularPerimetro()/2;
      return Math.sqrt(aux*(aux-lado1)*(aux-lado2)*(aux-lado3));
    }
    //no me da el area
@Override
    public String toString(){
        return "El perimetro es: "+calcularPerimetro()+" "+"y el area es: "+calcularArea();
    }
}