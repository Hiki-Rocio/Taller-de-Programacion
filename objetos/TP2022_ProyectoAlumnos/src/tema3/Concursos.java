
package tema3;

public class Concursos {
   private Generos[]genero;
   private int DF=5;

    public Concursos() {
       genero= new Generos[DF];
       for(int i=0; i<DF; i++){
         genero[i]=new Generos(20);
       }
       
    }  

    public int getDF() {
        return DF;
    }
    
    public Alumnos mayorPuntaje(){
     double max=0;
     Alumnos maxI=null;
     for(int i = 0; i <this.getDF(); i++){
       Generos g = genero[i];
            Alumnos maxGenero = g.puntajeMax(i);//llamo el alumno con mayor puntaje por genero 
            if((maxGenero != null) && (maxGenero.getPuntaje() >= max)){
                max = maxGenero.getPuntaje();
                maxI = maxGenero;
       }
     }
    return maxI;        
    }
    
    
    public void inscribirAlumno(Alumnos A, int g){
        if((g >=1) && (g <= 5)){
            genero[g-1].ingresarAlumno(A);
        }else{
            System.out.println("No hay ese numero de genero");
        }
    }    
     
    public void actualizarPuntaje(int g, String nom, int punt){
        if((g >=1) && (g <= 5)){
            Alumnos alum = genero[g-1].buscarAlumno(nom);
            if(alum != null){
                alum.setPuntaje(punt);
                System.out.println("Alumno actualizado!");
            }else{
                System.out.println("No se encontro al alumno de nombre: "+ nom);
            }
        }else{
            System.out.println("El genero no se encuentra dentro del rango");
        }
    }     
    @Override
    public String toString(){
        String aux = "";
        for(int i = 0; i < this.DF; i++){
            aux = aux + "Genero "+ (i+1)+" - Total Inscriptos: "+genero[i].getDL()+" - "+genero[i].toString() ;
        }
        
        aux = aux + "\n" + "Alumno de mayor puntaje es: "+ mayorPuntaje().toString();
        
        return aux;
    }    
}