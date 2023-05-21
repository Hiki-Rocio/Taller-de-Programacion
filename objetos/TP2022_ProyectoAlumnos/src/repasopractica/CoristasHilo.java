
package repasopractica;

public class CoristasHilo extends Coros{
    private int fila;
    private int columna;
    private int actualFila=0, actualColumna=0;
    private Coristas[][]hilera;
    int DL=0;

    public  CoristasHilo(int X ,String nombre, Director director ){
        super(nombre,director);
        this.fila=X;
        this.columna=X;
        hilera= new Coristas[X][X];
                
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
    public boolean estaLleno() {
        return DL == (fila * columna);
    }
    public void agregarCorista(Coristas c){
            if (!this.estaLleno()) {
            if (actualColumna < columna) {
                hilera[actualFila][actualColumna] = c;
                actualColumna++;
                DL++;
            } else {
                actualFila++;
                actualColumna = 0;
                hilera[actualFila][actualColumna] = c;
                DL++;
            }
        } else {
            System.out.println("Matriz de Coristas lleno");
        }
    }
    
     public  boolean bienFormado(){
     int tonoPrimero;
        boolean mismoTono = true;
        boolean mayorToMenor = false;
        int j = 0;
        int i = 1;

        while ((j < getColumna()) && (mismoTono)) {
            tonoPrimero = hilera[i - 1][j].getTono();
            while ((i < getFila()) && (mismoTono)) {
                mismoTono = hilera[i][j].getTono() == tonoPrimero;
            }
        }

        for (j = 0; j < (getColumna() - 1); j++) {
            mayorToMenor = hilera[0][j].getTono() > hilera[0][j + 1].getTono();
        }

        boolean aux = mismoTono && mayorToMenor;
        return aux;
    }
     
}
