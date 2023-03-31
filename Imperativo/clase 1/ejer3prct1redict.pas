{3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de diciembre de 2022. De cada película se conoce: 
* código de película, código de género (1: acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélica, 7: documental y 8: terror) y puntaje 
* promedio otorgado por las críticas. 
Implementar un programa modularizado que:
a. Lea los datos de películas y los almacene por orden de llegada y agrupados por código de género, en una estructura de datos adecuada
* . La lectura finaliza cuando se lee el código de la película -1. 
b. Una vez almacenada la información, genere un vector que guarde, para cada género, el código de película con mayor puntaje obtenido entre 
* todas las críticas.
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos métodos vistos en la teoría. 
d. Luego de ordenar el vector, muestre el código de película con mayor puntaje y el código de película con menor puntaje.}



program ejer3;
const
  dimF=8;
type
 rango=1..8;
   pelicula=record
     cod:integer;
     codGenero:rango;
     puntaje:real;
   end;
   
   lista=^nodo;
   nodo=record
     dato:pelicula;
     sig:lista;
   end;
   
   vector=array[1..dimF] of lista;
   vectorMayorPuntaje=array[1..dimF]of pelicula;
   
   procedure LeerPelicula(var p:pelicula);
   begin
      write('Ingrese el codigo de la pelicula: ');
      readln(p.cod);
      if(p.cod<>-1)then begin
        randomize;
        p.puntaje:=random(100);
        write('Puntaje:');
        writeln(p.puntaje:4:2);       
      end;
   end;
   
   procedure agregarAtras(var ult,l:lista; p:pelicula);
   var nue:lista;
   begin
     new(nue);
     nue^.dato:=p;
     nue^.sig:=nil;
     if(l<>nil)then 
       ult^.sig:=nue
       else
         l:=nue;
     ult:=nue;     
   end;
   procedure inicializarVector(var v:vector);
   var
     i:integer;
   begin
     for i:= 1 to dimF do 
       v[i]:=nil;
   end;
   
   procedure AlmacenarLista(var ult,v:vector);
   var
    p:pelicula; 
   begin
      inicializarVector(v);
      inicializarVector(ult);{no es necesario ya que no cambiaria en nada}
      LeerPelicula(p);
      randomize;
      p.codGenero:=random(8)+1;
      write('Codigo de Genereo: ');
      writeln(p.codGenero);
      while(p.cod<>-1)do begin
         agregarAtras(ult[p.codGenero],v[p.codGenero],p);
         LeerPelicula(p);
         randomize;
         p.codGenero:=random(8)+1;
         write('Codigo de Genereo: ');
         writeln(p.codGenero);       
     end;   
   end;
   
   procedure imprimirVector(v:vector);
   var
     i:integer;
   begin
     for i:= 1 to dimF do 
       while(v[i]<> nil)do begin
           writeln('--------------------Codigo de Genereo: ',i);
         writeln('');
           write('Codigo Pelicula: ');
           writeln(v[i]^.dato.cod);
           write('Puntaje:');
           writeln(v[i]^.dato.puntaje:4:2);
           v[i]:=v[i]^.sig;
      end;
  end;

  
  procedure GenerarVectorPuntaje(var v2:vectorMayorPuntaje; v:vector; var diml:integer);
  var
    i:integer; p:pelicula;
  begin    
     diml:=0;
     for i:= 1 to dimF do begin
       p.puntaje:=-1;
       while(v[i] <> nil) do begin             
                 if(v[i]^.dato.puntaje>p.puntaje)then 
                   p:=v[i]^.dato;               
                v[i]:=v[i]^.sig;                                                                                                       
       end;    
       v2[i]:=p;
       if (v2[i].puntaje <> -1) then
					diml:=diml+1; 
     end;
 end;
procedure ImprimirVector2 (v2: vectorMayorPuntaje);//solo me imprime el utimo posicion
var
   i: integer;
begin
     writeln('Vector de codigos: 1era linea codigo de genero, 2da linea codigo de la pelicula con mayor puntaje, 3er puntaje ');
     for i:= 1 to dimF do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimF do begin
        write('   0',i, ' | '); 
     end;
     writeln;
     writeln;
     write (' ');
     for i:= 1 to dimF do begin
      if(v2[i].cod<= 9)then
            write ('   0');
        write(v2[i].cod, ' | ');
     end;
     writeln;
     for i:=1 to dimF do begin
       if(v2[i].puntaje<=9)then
         write('   0');
         write(v2[i].puntaje:4:2,'|');
     end;
     for i:= 1 to dimF do
         write ('-----');
     writeln;
     writeln;
End;

Procedure Ordenar ( var v2:vectorMayorPuntaje; diml:integer );

var i,j,pos:integer; p:pelicula;	
		
begin
 for i:=1 to diml-1 do begin 
           pos := i;
          for j := i+1 to diml do
             if (v2[ j ].puntaje < v2[ pos ].puntaje) then pos:=j;
         p := v2[ pos ];   
         v2[ pos ] := v2[ i ];   
         v2[ i ] := p;
      end;
end;
procedure impimir(v2:vectorMayorPuntaje; diml:integer);
begin
  if diml> 0 then begin
     writeln('El codigo con mayor puntaje es: ',v2[dimF].cod);
     writeln('El cdigo con menor puntaje es: ',v2[1].cod);
   end;
end;
var
  ult,v:vector; v2:vectorMayorPuntaje; diml:integer;
begin
  inicializarVector(v);
  AlmacenarLista(ult,v);   
  imprimirVector(v);
  GenerarVectorPuntaje(v2,v,diml);
  ImprimirVector2 (v2);
  Ordenar ( v2,diml );
    ImprimirVector2 (v2);
impimir(v2,dimF);
end.
