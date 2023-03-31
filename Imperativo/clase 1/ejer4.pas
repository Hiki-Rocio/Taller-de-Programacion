{
4.- Una librería requiere el procesamiento de la información de sus productos. De cada producto se conoce el código del producto, código de rubro 
* (del 1 al 8) y precio. 
Implementar un programa modularizado que:
a. Lea los datos de los productos y los almacene ordenados por código de producto y agrupados por rubro, en una estructura de datos adecuada.
*  El ingreso de los productos finaliza cuando se lee el precio 0.
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que puede haber más o menos de 30 productos del rubro 3. 
* Si la cantidad de productos del rubro 3 es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto. 
d. Ordene, por precio, los elementos del vector generado en b) utilizando alguno de los dos métodos vistos en la teoría. 
e. Muestre los precios del vector ordenado.
}
program ejer4Pract1;
const
  dimF=8;
type
  rango= 1..dimF;
  producto=record
    cod:integer;
    codRubro:rango;
    precio:real;
  end;
  
  lista=^nodo;
  nodo=record
    dato:producto;
    sig:lista;
  end;
  
  vector=array[1..dimF]of lista;
  
  procedure LeerProducto(var p:producto);
  begin
    write('Ingrese el precio: ');
    readln(p.precio);
    if(p.precio<>0)then begin
      write('CODIGO: ');
      randomize;
      p.cod:=random(100);
      writeln(p.cod);
    end;
  end;
  
  procedure InicializarVector(var v:vector);
  var
    i:integer;
  begin
    for i:= 1 to dimF do
      v[i]:=nil;
  end;
  
 procedure InsertarOrdenado(var v:vector; p:producto);
 var aux, ant, act:lista;
 begin 
	new(aux); 
	aux^.dato:=p;
    aux^.sig:=nil;
	act:=v[p.codRubro];
	ant:=act;
	while (act <> nil) and (act^.dato.cod< aux^.dato.cod) do begin
		ant:=act;
		act:=act^.sig;
	end;
			
	if (act = v[p.codRubro]) then begin
	  aux^.sig:=v[p.codRubro];
		v[p.codRubro]:=aux;
		{writeln(aux^.dato)implementar debugging}
	end
		else begin
		ant^.sig:=aux;
		aux^.sig:=act;
	    end;	
 end;
	
procedure AlmacenarLista(var v:vector);
var
 p:producto;
begin
   inicializarVector(v);
   LeerProducto(p);
   while(p.precio<>0)do begin
     InsertarOrdenado(v,p);
     LeerProducto(p);   
   end;
end;
   
 procedure ImprimirVector(v:vector);
 var i:integer;
 begin
   for i:= 1 to dimF do begin
     
     if (v[i]=nil) then 
       writeln('para este rubro no hay elementos')
     else begin
       while(v[i] <> nil)do begin
         writeln('------------------CODIGO DE RUBRO:',i);
         write('Codigo de producto: ',v[i]^.dato.cod,'|');
         writeln('');
         v[i]:=v[i]^.sig;  
      end;
     end;
   end;
 end;

var
  v:vector;
begin
  AlmacenarLista(v);
  ImprimirVector(v);                                                         
end.
