/*4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
(ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/
2000 y 8000.
(iii) Implemente en las clases que corresponda todos los métodos necesarios para:
- Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
en el rango 1..N) y que la habitación está libre.
- Aumentar el precio de todas las habitaciones en un monto recibido.
- Obtener la representación String del hotel, siguiendo el formato:
{Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
…
{Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe
delegar la responsabilidad de la operación.

B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones, 
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe 
delegar la responsabilidad de la operación
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author HIKI
 */
public class Ejer04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      /*  int N = 5;
        int i;
        Hotel h = new Hotel(N);
        Cliente c;
        for (i = 0; i < N; i++) {
            if (GeneradorAleatorio.generarBoolean()) {//me fijo si esta ocupada o no si esta desaocupada 
                c = new Cliente(GeneradorAleatorio.generarString(10), GeneradorAleatorio.generarInt(48000000), GeneradorAleatorio.generarInt(100));
                h.checkIn(i, c);//ingreso el cliente
            }
        }

        System.out.println(h.toString());

        h.aumentarPrecio(300);

        System.out.println(h.toString());
    }
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.*/
      int N=6;
      int i;
      Cliente cliente = new Cliente();
      Hotel hotel= new Hotel(N);
      GeneradorAleatorio.iniciar();
      for(i=0; i<N; i++){
          
          if (GeneradorAleatorio.generarBoolean()){
         System.out.println("Habitacion-------------------------"+(i+1));
         cliente = new Cliente(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(100000), GeneradorAleatorio.generarInt(100));
         System.out.println(cliente.toString());
         
          hotel.ingresar(i, cliente);    
          }
       
        
      }
      System.out.println(hotel.toString());
      hotel.aumentarPrecio(100);
      System.out.println("Precio actualizado----------------------------");
      System.out.println(hotel.toString()); 
    }
}
