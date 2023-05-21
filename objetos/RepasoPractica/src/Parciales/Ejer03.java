/*
Representar funciones de teatro. Una funcion tiene un titulo,fecha, hora y mantiene una
estructura que representa la sala(N filas y M butacas por fila) que almacenara la informacion
de cada butaca, que comprende un descriptor(String), el precio y su etsado(sie sta ocpado ono)
1- Genere las clases neesarias.Prvea los constructores necesarios. La funcion
debe iniciarse a partir de un titulo, una fecha, una hora y las dimensiones de la 
sala(Ny M)Inicialemnete cada butaca debe estar desocupada, tener un precio
que surge de la formula 800*100*nuroe de fila y un descriptor"Butaca ij"donde i es el numero de butaca dentro de su fila.
2-Implemente los metodos necesarios, en las clases que corresponda, para:
a) Ocupar la butaca numero B de la fila numero F y retornar su precio. Asuma que F
y B estan en rango 1..N y 1..M respectivamente.
b)Desocupar todas las butacas de la fila numero F y retornar su precio.Asuma que F 
esta en rango 1..N.
c)Obtener un String con todas las representaciones de las butacas numero B de la funcion.
La REPRENSENTACION DE CADA BUTACA ES DEL ESTILO("DEScriptor,precio,estado")
d)Obtener un String que represente la funcion que contenga: Titulo,fecha, hra y
la representacion de cada butaca("descriptor,precio,estado")
3-Realice un programa que instancie una funcion de teatro.Ocupe distintas butacas
Compruebe correcto funcionamiento de los metodos implementados.
 */
package Parciales;

public class Ejer03 {

    public static void main(String[] args) {
            Funciones f= new Funciones("Topa y muni","25/05/2023", "21horas", 4, 3);
            Butacas b1=new Butacas(1,1);
             Butacas b2=new Butacas(2,1);
              Butacas b3=new Butacas(3,1);
              
              f.OcuparButaca(1, 1);
              f.OcuparButaca(2, 1);
              
              System.out.println("Buaca 1-------------");
              System.out.println(f.ObtenerButacasNroB(1));
              f.DesocuparButacas(2);
              System.out.println(f.toString());
    }
}
