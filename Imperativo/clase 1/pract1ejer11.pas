{1.- Implementar un programa que procese la información de las ventas de productos de un comercio (como máximo 20). 
De cada venta se conoce código del producto (entre 1 y 15) y cantidad vendida (como máximo 99 unidades).  El ingreso de las ventas finaliza con el código 0 (no se procesa).
a. Almacenar la información de las ventas en un vector. El código debe generarse automáticamente (random) y la cantidad se debe leer. 
b. Mostrar el contenido del vector resultante.
c. Ordenar el vector de ventas por código.
d. Mostrar el contenido del vector resultante.
e. Eliminar del vector ordenado las ventas con código de producto entre dos valores que se ingresan como parámetros. 
f. Mostrar el contenido del vector resultante.
g. Generar una lista ordenada por código de producto de menor a mayor a partir del vector resultante del inciso e., sólo para los códigos pares.
h. Mostrar la lista resultante.}

program ejer1Pract1;
const
  dimF=8;
type
  rango= 0..dimF;
  rango1=0..15;
  rango2=1..99;
  venta= record
    cod:rango1;
    cantVendida:rango2;
  end;
  vectorVentas= array[1..dimF] of venta; 
  
  	 lista=^nodo;
	 nodo=record
	    dato:venta;
	    sig:lista;
	 end;
{----------------------------------------------INSISO A--------------------------------------}
procedure LeerVenta(var v:venta);
begin
  Randomize;
  write('Codigo del producto: ');
  v.cod:=random(16);
  writeln(v.cod);
  if(v.cod <> 0)then begin
     write ('Ingrese cantidad (entre 1 y 99): ');
           readln (v.cantVendida);
  end;
end;

procedure AlmacenarVentas(var vv:vectorVentas; var diml:rango );
var
 v:venta;
begin
  diml:= 0;
    LeerVenta(v);
    while (v.cod <> 0)  and ( diml < dimF ) do 
    begin
       diml := diml + 1;
       vv[diml]:= v;
       LeerVenta (v);
    end;
end;
{-----------------------------------------------INSISO B---------------------------------------}
procedure imprimirVector(vv:vectorVentas; diml:rango);
var
 i:integer;
begin
 writeln('Vector de ventas: 1era linea codigo, 2da linea cantidad');
     for i:= 1 to diml do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to diml do begin
        if(vv[i].cod <= 9)then
            write ('0');
        write(vv[i].cod, ' | ');
     end;
     writeln;
     writeln;
     write (' ');
     for i:= 1 to diml do begin
        if (vv[i].cantVendida <= 9)then
            write ('0');
        write(vv[i].cantVendida, ' | ');
     end;
     writeln;
     for i:= 1 to diml do
         write ('-----');
     writeln;
     writeln;
End;
 {'-----------------------inciso c----------------------------------------'}
 
procedure ordenar(var vv:vectorVentas; diml:rango);
var
i,j,p:rango; v:venta;
begin
  for i:= 1 to diml-1 do begin
      p:=i;
      for j:= i+1 to diml do
        if(vv[j].cod<vv[p].cod) then
        p:=j;
   v:= vv[p];   
   vv[p] := vv[i];   
   vv[i] := v;
  end;
end;

{-----------------------INCISO E-------------------------------------------}

procedure EliminarVector (var vv: vectorVentas; var diml: rango; valorInferior, valorSuperior: rango1);
var
  ini,i,fin: integer;
  aBorrar: integer;
begin

  {Buscar en el vector la posicion donde debo empezar a borrar: ini} 
  ini:=1;
  while (ini <= diml) and (vv[ini].cod < valorInferior) do 
                ini:=ini+1;

  {Buscar en el vector la posicion donde debo terminar de borrar: fin}
  {Comenzar a partir de ini porque el vector esta ordenado} 
 fin:= ini;
  while (fin <= diml) and (vv[fin].cod<=valorSuperior) do 
                fin:=fin+1;
  
  {Cantidad de elementos a borrar: aBorrar}
  aBorrar:= fin - ini;  
  if (aBorrar>0)then begin
         {COMPLETAR}
{Eliminar todos las ventas entre las posiciones ini y fin-1 }	
	for i := fin to diml do
		begin
			vv[ini] := vv[i];
			ini := ini + 1;
		end;
          
		 {Actualizar dimL}
	diml := diml - aBorrar;
  end;
end;
  {--------------------------INCISO G-----------------------------------}
 procedure agregarAtras( var l,ult:lista; ven:venta);
var
 nue:lista;
begin
    new (nue);
    nue^.dato:= ven;
    nue^.sig := NIL;
    if l <> Nil then
       ult^.sig := nue
    else
       l := nue;
    ult := nue;
end;
 
 function codPares(cod:rango1):boolean;
 begin
    codPares:= ((cod mod 2) = 0);
 end;
 
 procedure GenerarLista(var l:lista; vv:vectorVentas; diml:rango);
 var
   i:rango; ult:lista;
 begin
    l:=nil;
   for i := 1 to diml do begin
     if codPares(vv[i].cod)then
        agregarAtras(l,ult,vv[i]);      
 end;
end;

procedure ImprimirLista(l:lista);
begin
   while(l<>nil)do begin
   write('----');
   writeln;
   write('');
   writeln('Codigo: ',l^.dato.cod);
   writeln('Cantidad: ',l^.dato.cantVendida);
   l:=l^.sig;
   end;
   
end;


var
 vv:vectorVentas;  diml:rango; num1,num2:integer; l:lista;
begin
  AlmacenarVentas(vv,diml);
  imprimirVector(vv,diml);
  ordenar(vv,diml);
  imprimirVector(vv,diml);{insiso d-----------}
  writeln('Ingrese un valor minimo de parametro:');
  readln(num1);
  writeln('Ingrese un valor maximo de parametro:');
  readln(num2);
  EliminarVector(vv,diml,num1, num2);
  writeln('----------Vector Nuevo-----------------');
  imprimirVector(vv,diml);
  writeln('--------------LISTA--------------');
  GenerarLista( l,vv,diml);
  ImprimirLista(l);
end.
