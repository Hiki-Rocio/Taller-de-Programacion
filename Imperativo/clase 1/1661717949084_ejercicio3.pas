
{3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de diciembre de 2022. De cada película se conoce: 
* código de película, código de género (1: acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélica, 7: documental y 8: terror) y puntaje 
* promedio otorgado por las críticas. 
Implementar un programa modularizado que:
a. Lea los datos de películas y los almacene por orden de llegada y agrupados por código de género, en una estructura de datos adecuada
* . La lectura finaliza cuando se lee el código de la película -1. 
b. Una vez almacenada la información, genere un vector que guarde, para cada género, el código de película con mayor puntaje obtenido entre 
* todas las críticas.
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos métodos vistos en la teoría. 
d. Luego de ordenar el vector, muestre el código de película con mayor puntaje y el código de película con menor puntaje.}program ejercicio3;
const dimf = 8;
type
    rango=1..dimf;
	pelicula = record
				cod_peli: integer;
				puntaje: real;
    end;
    lista = ^nodo;
    nodo = record
		     dato: pelicula;
		     sig: lista;
		    end;
	vector = array [rango] of lista;
	vector2=array[rango] of integer;//guardo el codigo de la pelicula con mayor puntaje de cada genero
	
procedure leer_pelicula(var p: pelicula);
begin
	 write ('Codigo de pelicula: ');
	 readln(p.cod_peli);
	 if (p.cod_peli <> -1)then
	 begin
		write('Puntaje: ');
		readln(p.puntaje);
	 end;
end;


Procedure agregar_adelante(var l:lista; p:pelicula);
Var nue:lista;
Begin
    l:=nil;
     New(nue);
     nue^.dato:=p;
     nue^.sig:=l;
     l:=nue;   
End;


procedure cargar_vector(var v: vector);
var 
	p:pelicula;
	genero:rango;
	
begin 

    leer_pelicula(p);
    write('Ingrese el tipo de genero del 1 al 8: ');
	readln(genero);	
	while(p.cod_peli <> -1)do begin
		  agregar_adelante(v[genero],p);	
		  leer_pelicula(p);   
		  write('Ingrese el tipo de genero del 1 al 8: ');
	      readln(genero);
    end;
end;

procedure maximo_puntaje(puntaje:real ; cod:integer; var maxpuntaje:real; var maxcod:integer);
begin
   if(puntaje>maxpuntaje)then begin
       maxpuntaje:=puntaje;
       maxcod:=cod;
   end;
end;  
   
{ este modulo es innecesario
procedure cargar_vector2(var v2: vector2;maxcod:integer; i:rango);
begin
       
       v2[i]:= maxcod;
end;
}
procedure vectorCodigo(v:vector; var v2:vector2; var maxcod:integer;  var maxpuntaje:real);
var
 i:rango;
begin    
     for i:= 1 to dimf do begin
       maxpuntaje:=-1;
       while(v[i] <> nil) do begin
                maximo_puntaje(v[i]^.dato.puntaje, v[i]^.dato.cod_peli,maxpuntaje,maxcod);  
                v2[i]:=maxcod;    
                 v[i]:=v[i]^.sig;                                                                                         
       end;         
     end;
end;

procedure ImprimirVector2 (v2: vector2);
var
   i: rango;
begin
     writeln('Vector de codigos: 1era linea codigo de genero, 2da linea codigo de la pelicula con mayor puntaje ');
     for i:= 1 to dimf do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimf do begin
        write('0',i, ' | '); 
     end;
     writeln;
     writeln;
     write (' ');
     for i:= 1 to dimf do begin
      if(v2[i] <= 9)then
            write ('0');
        write(v2[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimf do
         write ('-----');
     writeln;
     writeln;
End;


Procedure Ordenar ( var v2: vector2);
var i, j: integer; actual: integer;	
		
begin
 for i:=2 to dimf do begin 
     actual:= v2[i];
     j:= i-1; 
     while (j>0)and(v2[j] > actual) do      
       begin
         v2[j+1]:= v2[j];
         j:= j-1;                  
       end;  
     v2[j+1]:= actual; 
 end;
end;

procedure imprimirPuntaje(v2:vector2);
begin
  writeln('El codigo con menor puntaje es: ',v2[1]);
  writeln('El codigo con mayor puntaje es: ',v2[dimf]);
end;

var
	v:vector;
	v2:vector2;
	maxcod:integer;
	maxpuntaje:real;
begin
    cargar_vector(v);
    vectorCodigo(v,v2,maxcod,maxpuntaje);
    ImprimirVector2(v2);
    Ordenar(v2);
    imprimirPuntaje(v2);
end.
