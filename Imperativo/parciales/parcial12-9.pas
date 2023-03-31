{ Un comercio necesita el procesamiento de las compras realizadas
 por sus clientes durante el mes de 2022. De cada compra se conoce
 el codigo del cliente, dia, cantidad de productos y monto pagado.
 a) Implementar un modulo que lea compras,genere y retorne una 
estructura adecuada para la busqueda por codigo del cliente, donde
para cada codigo de cliente se almacenan juntas todas las compras
(dia, cantidad de productos y monto) que realizo. La lectura 
finaliza con cantidad de productos 0. Se sugiere utilizar el molulo
leer_registro
b_ Implementar un modulo que reciba la estructura generada en a) y 
 un codigo de cliente y retorne todas las compras de dicho cliente.
c_Realizar un modulo recursivo que reciba la estructura que 
retorna el inciso b) y retorne el monto de lacompra con mayor 
cantidad de productos
}

program parcial12;
uses crt;
type
   compra = record
     cod_cliente:integer;
     dia:integer;
     cantidad: integer;
     monto: integer;
   end;
   compras = record
     dia1:integer;
     cantidad1:integer;
     monto1:integer;
   end;
   lista = ^nodo;
   nodo = record
     dato: compras;
     sig: lista;
   end;
   compraA = record
     codigo:integer;
     compris: lista;
   end;
   
   arbol = ^nodo2;
   nodo2 = record
     dato1: compraA;
     hi: arbol;
     hd: arbol;
   end;

procedure Leer (var com:compra);
begin
  writeln('Ingrese cantidad de productos comprados por el cliente');
  readln(com.cantidad);
  if (com.cantidad <> 0) then
    begin
      writeln('Ingrese codigo de cliente que hizo la compra');
      readln(com.cod_cliente);
      writeln('Ingrese dia de la compra');
      readln(com.dia);
      writeln('Ingrese monto total gastado por el cliente');
      readln(com.monto);
    end;
end;   

procedure Crear_Nodo(var aux:lista; com:compra);
begin
  new(aux);
  aux^.dato.dia1:= com.dia;
  aux^.dato.cantidad1:= com.cantidad;
  aux^.dato.monto1:= com.monto;
  aux^.sig:= nil;
end;

procedure Agregar_Ordenado (var l:lista; com:compra);
var
  ant,act,aux:lista;
begin
   Crear_Nodo(aux,com);
   act:= l;
   ant:= l;
   while ((act <> nil) and (aux^.dato.cantidad1 > com.cantidad)) do
     begin
       ant:= act;
       act:= act^.sig;
     end;
   if (ant = act) then
     l:= aux
   else
     ant:= aux;
   aux^.sig:= act;
end;

procedure Insertar_Arbol (var a:arbol; com:compra);
begin
   if (a = nil) then
     begin
       writeln('ENTRO A INSERTAR');
       new(a);
       a^.dato1.codigo:= com.cod_cliente;
       a^.hi:= nil;
       a^.hd:= nil;
       Agregar_Ordenado(a^.dato1.compris,com);
     end
   else
     begin
       if (com.cod_cliente < a^.dato1.codigo) then
         Insertar_Arbol(a^.hi,com)
       else if (com.cod_cliente > a^.dato1.codigo) then
         Insertar_Arbol(a^.hd,com);
       if (com.cod_cliente = a^.dato1.codigo) then
         Agregar_Ordenado(a^.dato1.compris,com);
     end;
end;
procedure Cargar_Arbol (var a:arbol);
var
  com:compra;
begin
  Leer(com);
  while (com.cantidad <> 0) do
    begin
      Insertar_Arbol(a,com);
      Leer(com);
    end;
end;

procedure Imprimir_Lista(l:lista);
begin
  while (l <> nil) do
    begin
      writeln('El monto de la compra fue ' , l^.dato.monto1); 
      writeln('La cantidad de productos comprados fue ' , l^.dato.cantidad1);
      writeln('El dia de la compra fue ' , l^.dato.dia1);
      writeln('---------------------------------------------');
      l:= l^.sig;
    end;
end;

procedure Imprimir_Arbol(a:arbol);
begin
  if (a <> nil) then
    begin
      Imprimir_Arbol(a^.hi);
      writeln('---------------------------------------------');
      writeln('---------------------------------------------');
      writeln('El codigo del cliente es ' , a^.dato1.codigo);
      Imprimir_Lista(a^.dato1.compris);
      Imprimir_Arbol(a^.hd);
    end;
end;

procedure Busqueda (a:arbol; cod:integer ; var l2:lista);
begin
  if (a <> nil) then
    begin
      if (cod = a^.dato1.codigo) then begin
         writeln('supuestamente carga la lista');
         l2:= a^.dato1.compris;
      end;
      if (cod < a^.dato1.codigo) then
         Busqueda(a^.hi,cod,l2)
      else if (cod > a^.dato1.codigo) then
         Busqueda(a^.hd,cod,l2);
    end;
end;

procedure Inciso_B (a:arbol; var l2:lista);
var
  cod:integer;
begin
  writeln('Ingrese codigo de cliente a buscar');
  readln(cod);
  Busqueda(a,cod,l2);
end;

procedure Inciso_C (l2:lista);
begin
   writeln('La compra con mayores productos fue ' , l2^.dato.cantidad1);
end;
VAR
  a:arbol;
  l2:lista;
BEGIN
  a:= nil;
  l2:= nil;
  Cargar_Arbol(a);
  Imprimir_Arbol(a);
  Inciso_B(a,l2);
  Imprimir_Lista(l2);
  Inciso_C(l2);
END.

