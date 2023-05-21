
package Parcial1;

public class Tema {
    private int numero;
    private String enunTeorico;
    private String enunPractico;

    public Tema(int numero, String enunTeorico, String enunPractico) {
        this.numero = numero;
        this.enunTeorico = enunTeorico;
        this.enunPractico = enunPractico;
    }



    public String getEnunPractico() {
        return enunPractico;
    }

    public void setEnunPractico(String enunPractico) {
        this.enunPractico = enunPractico;
    }

    @Override
    public String toString() {
        return "\nTema numero=" + numero + "\nEnunciado teorico=" + enunTeorico + "\nEnunciado practico" + enunPractico ;
    }
    
    
    
}
