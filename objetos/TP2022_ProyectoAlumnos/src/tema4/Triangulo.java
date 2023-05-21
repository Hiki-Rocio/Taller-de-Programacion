package tema4;

public class  Triangulo extends Figura{
    private double lado1,lado2,lado3;
    
    public Triangulo(double unlado1,double unlado2, double unlado3, String unColorR, String unColorL){
         super(unColorR,unColorL);
         setLado1(unlado1);
         setLado2(unlado2);
         setLado3(unlado3);
    }

    public double getLado1(){
        return lado1;
    }

    public double getLado2(){
        return lado2;
    }

    public double getLado3(){
        return lado3;
    }

    public void setLado1(double lado1){
        this.lado1 = lado1;
    }

    public void setLado2(double lado2){
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
   
    @Override
    public String toString(){
        String aux;
     aux= " Triangulo: "+super.toString()+" "+"Lado 1: "+getLado1()+" "+"Lado 2: "+getLado2()+" "+"Lado 3 : "+getLado3();
     return aux;
    }
    public double calcularPerimetro(){
       return getLado1()+getLado2()+getLado3();
    } 
    public double calcularArea(){
        double p=(getLado1()+getLado2()+getLado3())/2;
       return Math.sqrt(p*(p-getLado1())*(p-getLado2())*(p-getLado3()));
    }    
}
