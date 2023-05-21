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
public class Generos {
    private Alumnos[] a;
    int DF;
    int DL=0;

    public Generos(int n) {
        DF=n;
        a= new Alumnos[DF];     
    }

    public int getDF() {
        return DF;
    }

    public int getDL() {
        return DL;
    }

    public void setDF(int DF) {
        this.DF = DF;
    }

    public void setDL(int DL) {
        this.DL = DL;
    }

    public void ingresarAlumno(Alumnos alum){
         if(this.getDL()<this.getDF()){//EL ALUMNO PUEDE NO EXISTIR RECORRO TODO
            a[DL]=alum;
            DL++;
         }else{
            System.out.println("El genero se encuentra lleno");
        }
    }
    
    public Alumnos puntajeMax(int p){
        int max=0;
        Alumnos maxi=null;
        for(int i=0; i<this.getDL(); i++){
          if(a[i].getPuntaje()>max){
              max= a[i].getPuntaje();
              maxi=a[i];
           }
        }
        return maxi;
    }
    
    public Alumnos buscarAlumno(String nom){
        Alumnos alum=null;
        for(int i=0; i<DL;i++){
          if(a[i].getNombre().equals(nom)){
              alum=a[i];
          }
        }
        return alum;
    }
    
    @Override
    public String toString(){
      String aux="";
      for(int i=0; i<this.getDL();i++){
         aux=" Datos del Alumno-----"+(i+1)+a[i].toString();
      }
      return aux;
    }
    
}
