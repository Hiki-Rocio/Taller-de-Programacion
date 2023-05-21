/*
5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:
getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
- Calcular e informar la cantidad de partidos que ganó River.
- Calcular e informar el total de goles que realizó Boca jugando de local.
 */
package tema2;

import PaqueteLectura.Lector;

public class Ejercicio5 {

    public static void main(String[] args) {
        int DF = 20;
        int DL = 0;
        Partido[] vector = new Partido[DF];
        System.out.println("nombre visitante ");
        String nombreVisitante = Lector.leerString();
      
        while((!"zzz".equals(nombreVisitante))&&(DL<DF)){
                System.out.println("goles visitante ");
                int golesVisitante= Lector.leerInt();
                System.out.println("nombre local ");
                String nombreLocal = Lector.leerString();
                System.out.println("goles local ");
                int golesLocal= Lector.leerInt();

                vector[DL] = new Partido(nombreLocal,nombreVisitante,golesLocal,golesVisitante);
                DL++;
                
                System.out.println("nombre visitante ");
                nombreVisitante = Lector.leerString();
        }
         System.out.println("imprimimos vector");
        for (int i=0; i <DL; i++) {
            System.out.println(vector[i].toString());
        }
        
        int ganoRiver=0;
        int totalGoles= 0;
        for (int i=0; i <DL; i++) {
        if (vector[i].getGanador().equals("river")){
            ganoRiver++;
        
        }
        if(vector[i].getLocal().equals("boca")){
            totalGoles=totalGoles + vector[i].getGolesLocal();
        }

    }
       System.out.println("Gano river: " + ganoRiver);
        System.out.println("Goles boca: " + totalGoles);
    }
    
    
}