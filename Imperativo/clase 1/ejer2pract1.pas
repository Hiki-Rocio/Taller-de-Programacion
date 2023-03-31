{2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de las expensas de dichas oficinas. 
Implementar un programa modularizado que:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina se ingresa el código de identificación, DNI del propietario y
*  valor de la expensa. La lectura finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la oficina.
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina
}

program ejer2Pract1;
const
  dimF=5;
type
 rango=0..dimF;
   oficina=record
     cod:integer;
     dni:integer;
     valor:real;
   end;
   vectorOficce=array[1..dimF] of oficina;
   
procedure LeerOficina(var O:oficina);
begin
  Randomize;
  write('Codigo de oficina: ');
  O.cod:=random(6);
  writeln(o.cod);
  if(O.cod <> -1)then begin
       write('Ingrese el dni: ');
       readln(O.dni);
       write('Ingrese el valor de la expensa');
       readln(O.valor);
  end;
end; 

procedure GenerarVector(var v:vectorOficce; var diml:rango);
var
  o:oficina;
begin
  diml:=0;
  LeerOficina(O);
  while (O.cod <> -1)  and ( diml < dimF ) do 
    begin
    diml:= diml+1;
    v[diml]:=O;
    LeerOficina(O);
  end;
end;

Procedure Ordenar ( var v: vectorOficce; diml: rango );
var i, j: rango; actual:oficina;	
		
begin
 for i:=2 to diml do begin 
     actual:= v[i];
     j:= i-1; 
     while (j > 0) and (v[j].cod > actual.cod) do      
       begin
         v[j+1]:= v[j];
         j:= j-1;                  
       end;  
     v[j+1]:= actual; 
 end;
end;

procedure ImprimirVector (v: vectorOficce; dimL: rango);
var
   i: integer;
begin
     writeln('Vector de ventas: 1era linea codigo, 2da linea dni, 3era linea valor de la expensa');
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        if(v[i].cod <= 9)then
            write ('0');
        write(v[i].cod, ' | ');
     end;
     writeln;
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        write(v[i].dni, ' | ');
     end;
     writeln;
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        write(v[i].valor:4:2, ' | ');
     end;
     writeln;
End;


Procedure Ordenar2( var v:vectorOficce; dimLog: rango );

var i, j, p: rango; item : oficina;	
		
begin
 for i:=1 to dimLog-1 do begin {busca el mínimo y guarda en p la posición}
          p := i;
          for j := i+1 to dimLog do
             if v[ j ].cod < v[ p ].cod then p:=j;

         {intercambia v[i] y v[p]}
         item := v[ p ];   
         v[ p ] := v[ i ];   
         v[ i ] := item;
      end;
end;

var
 v:vectorOficce; diml:rango;
begin
  GenerarVector(v,diml);
  Ordenar (v,diml);
  ImprimirVector (v,diml);
  Ordenar2(v, diml );
  ImprimirVector (v,diml);
  
end.
