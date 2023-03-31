{4.- Escribir un programa que:
a. Implemente un módulo recursivo que genere un vector de 20 números enteros “random” mayores a 0 y menores a 100. 
b. Implemente un módulo recursivo que devuelva el máximo valor del vector. 
c. Implementar un módulo recursivo que devuelva la suma de los valores contenidos en el vector.

}

program ejer4Clase2;
const
  dimF=20;
{a. Implemente un módulo recursivo que genere un vector de 20 números enteros “random” mayores a 0 y menores a 100. }
type
   vector=array[1..dimF] of integer;
   
   procedure GenerarVector(var v:vector ; var diml:integer);
   var
    n:integer;
   begin
         
         if (diml<dimF)then begin
             n:=Random(100)+1;
             writeln(n);
             diml:=diml +1;
             v[diml]:=n;
             GenerarVector(v, diml);
         end;
   end; 
   
   procedure imprimirVector(v:vector; diml:integer);
     procedure recorrerVector(v:vector; i,diml:integer);
     begin
       if(i<=diml)then begin
        write(v[i], '|');
        recorrerVector(v,i+1,diml);
       end;
     end;
   begin
     writeln('-------------------------------Numeros del vector------------------------------');
     recorrerVector(v,1,dimL);
     writeln;
     writeln;
   end;
   
{b. Implemente un módulo recursivo que devuelva el máximo valor del vector. }
    function maximo(v:vector;diml:integer; max:integer):integer;

    begin
       if(diml=0)then
         maximo:=max
         else begin
            if(v[diml]>max)then
              max:=v[diml];
            maximo:=maximo(v,diml-1,max);//el vector empieza con diml=20 y para ir recorriendo debe disminuir 1un lugar
        end;
    end;

{c. Implementar un módulo recursivo que devuelva la suma de los valores contenidos en el vector.}
   function Suma(v:vector; diml:integer):integer;
  begin
     if (diml=0)then
       Suma:=0
       else 
           suma:=v[diml]+suma(v,diml-1);
  end;
           

var
  diml:integer; v:vector; max:integer; 
begin
   diml:=0;
   max:=0;
   Randomize;
   GenerarVector(v,diml);
   imprimirVector(v,diml);
   write('');
   writeln('El valor maximo del vecto es: ',maximo(v,diml,max));
   writeln('La suma total de los numeros es: ',suma(v,diml));
end.
