
package Parcial1;

public class Alumnos {
    private String nombre;
    private int legajo;
    private int nota1;
    private int nota2;
    private int nota3;
    private Tema tema;

    public Alumnos(String nombre, int legajo, int nota1, int nota2, int nota3, Tema tema) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.tema = tema;
    }



    public int getNota1() {
        return nota1;
    }

    public int getNota2() {
        return nota2;
    }


    public int getNota3() {
        return nota3;
    }


    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    
    public double Promedio(){
      int suma=nota1+nota2+nota3;
      int promedio;
      promedio=suma/3;
      return promedio;
    }
    
    public boolean supera(){
     boolean superior=false;
     if((nota1>7)&&(nota2>7)&&(nota3>7)){
        superior=true;
     }
     return superior;
    }

    @Override
    public String toString() {
        return "\nNombre=" + nombre + "\nLegajo=" + legajo + "\nNota  1=" + nota1 + "\nNota  2="+ nota2 + "\nNota  3=" + nota3 + "\nTema=" + tema;
    }
    
    
}
