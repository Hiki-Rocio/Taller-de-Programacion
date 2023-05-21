/* EJERCICIO DONDE SE USA EL GET DE UN VECTOR 
1.Queremos representar compras minoristas y mayoristas.
De cualquier compra se conoce: numero ylos productos comprados
(como maximo N). De vcada producto registra:codigo,precio mayoristay precio minorista
Ademas las compras mayoristas tienen el CUIT del comprador:y las minoristas si el comprador es jubilado.
a.Genere las clases necesarias . Provea constructores para iniciarlas compras
a partir de toda su informacion para una cantidad maxima de N productos comprados
y sin productos cargados.
b. Implemente metodos en las clases que correposda para permitir:
i. Agregar a la compra un producto que se recibe.Asuma que hay espacio.
ii.Obtener el precio a pagar por la compra sabiendo que: para las compras minorista es la suma 
del precio minorista de los productos y se adiciona el 21% de IVA y se descuenta el 10%
si es jubilado; para las compras mayorista es la suma del precio mayorista de los productos y descuenta el 21% de iva.
iii.Obtener la representacion String de la compra siguiendo el ejemplo:
NRO... Productos(codigo y precios mayorista y minorista):  precio a pagar..."

2. Realice un programa que instancie una compra mayorista y una minorista .Cargue 3 productos a cada compra. Para
finalizar, muestre la representaacio String de cada compra 
 */
package Parciales;

public class Ejer02 {

    public static void main(String[] args) {
      
       Productos p1 =new Productos(2, 100,50);
       Productos p2 =new Productos(3, 200,150);
       Productos p3 =new Productos(5, 520,250);
       
       Minoristas m= new Minoristas(true, 2, 3);
       Mayoristas M= new Mayoristas(1520-4, 5, 3);
         
       m.agregarProducto(p1);
       m.agregarProducto(p2);
       m.agregarProducto(p3);
       
       M.agregarProducto(p1);
       M.agregarProducto(p2);
       M.agregarProducto(p3);
       
       System.out.println("Compra minorista//////////");
       System.out.println(m.toString());
       
       System.out.println("Compra Mayorista//////////");
       System.out.println(M.toString());
    }
    
}
