{5.- Implementar un módulo que realice una búsqueda dicotómica en un vector, utilizando el siguiente encabezado:
   	Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice); 

Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra en el vector.
}
//para generar una busqueda dicotomica el vector debe estar ordenADO;
program ejer5Pract2;
const
  dimF=10;
type
   vector=array[1..dimF]of integer;
  
  procedure GenerarVector(var v:vector; var diml:integer);
  var
   n:integer;
  begin
    if(diml<dimF)then begin
      n:=Random(100)+1;
      writeln(n);
      diml:= diml +1;
      v[diml]:=n;
      GenerarVector(v,diml);
    end;
  end;
  
  procedure imprimirVector(v:vector; i,diml:integer);
  begin
     if(i<=diml)then begin
       write(v[i],'|');
       imprimirVector(v,i+1,diml);
     end;  
  end;
  
  procedure OrdenarVector(var v:vector; diml:integer);
  var
    p,i,j:integer; n:integer;
  begin
    for i:= 1 to diml-1 do begin
     p:=i;
     for j:=i+1 to diml do 
       if(v[j]<v[p])then
       p:=j;
     n:=v[p];
     v[p]:=v[i];
     v[i]:=n;
    end;
  end;
  
procedure busquedaDicotomica(v: vector; ini,fin: integer; dato:integer; var pos: integer);
var
	medio: integer;
begin
	medio:= (ini + fin) DIV 2;
	while(ini <= fin) and (dato <> v[medio]) do begin
		if(dato < v[medio]) then
			fin := medio - 1
		else
			ini:= medio + 1;
		medio := (ini + fin) DIV 2;
	end;
	if(ini <= fin) then
		pos:= medio
	else
		pos:= -1
end;
var
 v:vector; diml:integer; ini,pos,n:integer; 
begin
  Randomize;
  diml:=0;
  ini:=1;
  GenerarVector(v,diml);
  writeln('');
  writeln('-------------Vector----------------------------');
  imprimirVector(v,1,diml);
  OrdenarVector( v, diml);
  writeln('');
   writeln('');
  writeln('-------------Vector ORDENADO----------------------------');
  imprimirVector(v,1,diml);
  writeln('');
  writeln('Ingrese el numero que desea buscar: ');
  readln(n);
  busquedaDicotomica(v, ini,diml,n,pos);
  if(pos=-1)then
     writeln('No se enconro el elemento')
    else
      writeln('El elemento buscado esta en la posicio : ',pos);
end.
