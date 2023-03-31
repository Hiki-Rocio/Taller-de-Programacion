{2.	Escribir un programa que:
a. Implemente un módulo que lea información de ventas de un comercio.
*  De cada venta se lee código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de producto 0. 
* Un producto puede estar en más de una venta. Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de producto.
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por código de producto. Cada nodo del árbol debe contener el código
*  de producto y la cantidad total vendida.
               Nota: El módulo debe retornar los dos árboles.
b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.
c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.
}
program ejer2pract3;
type
    Fechas=record
      dia:integer;
      mes:integer;
      anio:integer;
    end;
    
   ventas=record
     cod:integer;
     fecha:Fechas;
     cantidad:integer;
   end;
   arbol=^nodo;
   nodo=record
     dato:ventas;
     HI:arbol;
     HD:arbol;
   end;
   
   venta2=record
     cod:integer;
     cantTotal:integer;
   end;
   
   arbol2=^nodo2;
   nodo2=record
     dato2:venta2;
     HI:arbol2;
     HD:arbol2;
   end;
   
   {a. Implemente un módulo que lea información de ventas de un comercio.
*  De cada venta se lee código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de producto 0. 
* Un producto puede estar en más de una venta.}//aca se refiere que puede haber 3 codigos iguales con distintas cantidades por ejemplo en una venta 
//se vendieron 3 auriculares, despues se vendieron otros 3 mas, entonces en e segundo arbolse debe poner la cantidad total vendida.
   procedure leerVenta(var v:ventas);
      	procedure leerFecha(var f: Fechas);
	    begin
		f.dia:= random(31) + 1;
		writeln(' -> Dia: ', f.dia);
		f.mes:= random(12) + 1;
		writeln(' -> Mes: ', f.mes);
		f.anio:= 2023;
		writeln(' -> Anio: ', f.anio);
	end;

   begin
     write('Ingrese el codigo del producto: ');
     readln(v.cod);
     if(v.cod <> 0)then begin
       writeln('Ingrese la fecha: ');
        leerFecha(v.fecha);
        write('Cantidad productos: ');
        v.cantidad:=random (100)+1;
        write(v.cantidad);
        writeln;
        write(' ');
        writeln;
     end;
   end;
   {i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de producto.}
   
   procedure GenerarArbol(var a:arbol; var a2:arbol2);
     procedure InsertarVentas(var a:arbol;v:ventas);
     begin
       if(a=nil)then begin
         new(a);
         a^.dato:=v;
         a^.HI:=nil;
         a^.HD:=nil;
       end
       else begin
         if(v.cod<a^.dato.cod)then
           InsertarVentas(a^.HI,v)
         else
           InsertarVentas(a^.HD,v);
       end;
     end;    
     
     procedure InsertarProductos(var a2:arbol2; v:ventas);
     var
      aux:venta2;
     begin
      if(a2=nil)then begin
        new(a2);
        aux.cod:=v.cod;
        aux.cantTotal:=v.cantidad;
        a2^.dato2:=aux;
        a2^.HI:=nil;
        a2^.HD:=nil;
      end
       else begin
          if(v.cod= a2^.dato2.cod)then
            a2^.dato2.cantTotal:=a2^.dato2.cantTotal+v.cantidad
          else
            if(v.cod > a2^.dato2.cod)then
              InsertarProductos(a2^.HD,v)
            else
              InsertarProductos(a2^.HI,v);
       end;         
     end;
   var
     v:ventas;
   begin
     leerVenta(v);
     while(v.cod<>0)do begin
       InsertarVentas(a,v);
       InsertarProductos(a2,v);
       leerVenta(v);
     end;   
   end;
    procedure ImprimirArbol1(a:arbol);
    begin                    

       if(a<>nil)then begin
          ImprimirArbol1(a^.HI);
          write('Codigo: ',a^.dato.cod);
          writeln;
          write('Fecha: ',a^.dato.fecha.dia,'/',a^.dato.fecha.mes,'/',a^.dato.fecha.anio);
          writeln;
          write('Cantidad: ',a^.dato.cantidad);
          writeln;
          ImprimirArbol1(a^.HD);
       end;    
    end;
    procedure ImprimirArbol2(a2:arbol2);
    begin

      if(a2<>nil)then begin
      ImprimirArbol2(a2^.HI);
      write('Codigo: ',a2^.dato2.cod);
      writeln;
      write('Cantidad total vendida: ',a2^.dato2.cantTotal);
      writeln;
      ImprimirArbol2(a2^.HD);
      end;
    end;
    {b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.}
  function buscarcodigo (a:arbol;cod:integer):integer;
   begin
      if(a=nil)then 
        buscarcodigo:=0
      else
        if(cod=a^.dato.cod)then 
          buscarcodigo:=buscarcodigo(a^.HD,cod)+buscarcodigo(a^.HI,cod)+a^.dato.cantidad//si el dato es igual recorro sus ramas sumando us cantidades
         else
           if(cod<a^.dato.cod)then
             buscarcodigo:=buscarcodigo(a^.HI,cod)
           else
             buscarcodigo:=buscarcodigo(a^.HD,cod) 
   end;
   {c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.}
   function buscarcodigo2 (a2:arbol2; cod:integer):integer;
   begin
      if(a2=nil)then
        buscarcodigo2:=0
      else
       if(cod<a2^.dato2.cod)then
         buscarcodigo2:=buscarcodigo2(a2^.HD,cod)
       else
         if(cod>a2^.dato2.cod)then
           buscarcodigo2:=buscarcodigo2(a2^.HD,cod)
          else
            if (a2^.dato2.cod=cod)then
                   buscarcodigo2:=a2^.dato2.cantTotal;        
   end;
   
var
  a:arbol;a2:arbol2; cod:integer;
begin
 Randomize;
 a:=nil;
 a2:=nil;
 writeln('-----------------------------Informe de ventas-------------------------');
 writeln;
 GenerarArbol(a,a2);
 writeln('-------------------------------Informe de VENTAS por codigo--------------------------------');
 writeln;
 ImprimirArbol1(a);
 writeln;
 writeln('---------------------------------Cantidad de ventas por CODIGO ----------------------------------');
 writeln; 
 ImprimirArbol2(a2);
  writeln;
 writeln('---------------------------------	BUSQUEDA DE CANTIDAD POR CODIGO en ARBOL 1 ----------------------------------');
 writeln; 
 write('Ingrese el codigo que desea buscar: ');
 readln(cod);
 writeln('La cantidad vendida del producto con codigo ', cod, ' es: ',buscarcodigo(a,cod));
 writeln;
  writeln('---------------------------------	BUSQUEDA DE CANTIDAD POR CODIGO en ARBOL 2----------------------------------');
 writeln; 
 write('Ingrese el codigo que desea buscar: ');
 readln(cod);
 writeln('La cantidad vendida del producto con codigo ', cod, ' es: ',buscarcodigo2(a2,cod));
end.
