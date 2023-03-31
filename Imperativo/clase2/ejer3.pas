{3.- Escribir un programa que:
a. Implemente un módulo recursivo que genere una lista de números enteros “random” mayores a 0 y menores a 100. Finalizar con el número 0.
b. Implemente un módulo recursivo que devuelva el mínimo valor de la lista. 
c. Implemente un módulo recursivo que devuelva el máximo valor de la lista. 
d. Implemente un módulo recursivo que devuelva verdadero si un valor determinado se encuentra en la lista o falso en caso contrario. 
}
program ejer3;
type
   lista=^nodo;
   nodo=record
     dato:integer;
     sig:lista;
   end;
   
 procedure generarLista(var l:lista);
	
	procedure insertarAdelante(var l:lista; n:integer);
	var nue:lista;
	begin
		new(nue);
		nue^.dato:=n;
		nue^.sig:=l;
		l:=nue;
	end;
 
 var n:integer;
 begin
		n:=random(100);
		writeln(n);
	if (n <> 0) then begin
		insertarAdelante(l,n);
		generarLista(l);
	end; 	
 end;

{procedure minimo(l:lista; var min:integer);
begin
   if(l<>nil)then begin
      if(l^.dato<min)then begin
        min:=l^.dato;
		minimo(l^.sig,min);
     end;
    end;
end;}

  function minimo (l:lista; min:integer):integer;
	begin
      if(l = nil) then
		minimo:= min
	  else begin
		 if(l^.dato < min) then
			min:= l^.dato;
		minimo:= minimo( l^.sig, min);
	end;
	end;
 function maximo(l:lista; max:integer):integer;
 begin
   if(l=nil) then 
     maximo:=max
    else begin
      if(l^.dato>max)then
        max:=l^.dato;
      maximo:=maximo(l^.sig,max);
    end;
 end;
{d. Implemente un módulo recursivo que devuelva verdadero si un valor determinado se encuentra en la lista o falso en caso contrario. }
 function encontrar(l:lista; n:integer):boolean;
 begin

   if(l=nil)then
     encontrar:=false
   else begin
     if(l^.dato=n)then 
       encontrar:=true
       else       
       encontrar:=encontrar(l^.sig,n);
 end;
 end;



var l:lista; min:integer; max:integer; n:integer;
begin
	min:=999;
	max:=0;
	randomize;
	l:=nil;
	generarLista(l);
	writeln('minimo ', minimo(l,min));
	writeln('Maximo ', maximo(l,max));    
	write('ingrese el numero a buscar: ');
    readln(n);
	writeln('Numero encontrado: ', encontrar(l,n));
end.
