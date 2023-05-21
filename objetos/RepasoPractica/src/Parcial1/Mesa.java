
package Parcial1;

public class Mesa {
    private String Fecha;
    private int N;
    private int DL;
    private Alumnos [] alumno;

    public Mesa(String Fecha, int N) {
        this.Fecha = Fecha;
        this.N = N;
        this.DL=0;
        alumno= new Alumnos[N];
        for(int i=0; i<N; i++){
          alumno[i]=null;
        }
    }

    public void AgregarAlumno(Alumnos a){
         alumno[DL]=a;
         DL++;
    }
    
    public void AsignarTema(Tema tema1,Tema tema2){
       for(int i=0; i<DL; i++){
           if(alumno[i].Promedio()>6){
               alumno[i].setTema(tema1);
           }else
               alumno[i].setTema(tema2);
       }
    }
    
    public int obtenerEstadistica(){
       int cantAlumno=0;
       for(int i=0; i<DL; i++){
          if(alumno[i].supera()){
             cantAlumno=cantAlumno+1;
          }
       
       }
       return cantAlumno;
    }

    @Override
    public String toString() {
        String aux="/////////Mesa Final/////"+"\nFecha: "+Fecha;
        for(int i=0; i<DL; i++){
              aux= aux+"\nAlumno---->"+(i+1)+alumno[i].toString();
            }
        return aux;
    }
    
   
}
