{1.- El administrador de un edificio de oficinas, cuenta en papel, con la información del pago de las expensas de dichas oficinas. 
Implementar un programa que:
a)	Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina se ingresa código de identificación, 
* DNI del propietario y valor de la expensa. La lectura finaliza cuando llega el código de identificación -1.
b)	Ordene el vector, aplicando uno de los métodos vistos en la cursada, para obtener el vector ordenado por código de identificación de la oficina.
c)	Realice una búsqueda dicotómica que recibe el vector generado en b) y un código de identificación de oficina y retorne si dicho código está en el vector. 
* En el caso de encontrarlo, se debe informar el DNI del propietario y en caso contrario informar que el código buscado no existe.
d)	Tenga un módulo recursivo que retorne el monto total de las expensas.
}
program ejer1;
const
  dimF=10;
type
   oficina=record
     cod:integer;
     dni:integer;
     valor:real;
   end;
   
   vector=array[1..dimF]of oficina;
   
   procedure GenerarVector(var v:vector ; var diml:integer);
     procedure LeerOficina(var o:oficina);
     begin
        write('Codigo: ');
        readln(o.cod);
        if(o.cod<>-1)then begin
           write('Dni: ');
           o.dni:=random(100000)+1;
           writeln(o.dni);
           write('Valor: ');
           o.valor:=random (1000)+1;
           writeln(o.valor:4:2);
           writeln;
           writeln('');
      end;
      end;
   var
    o:oficina;
   begin
     diml:=0;
     LeerOficina(o);
     while(o.cod<>-1)AND (diml<dimF)do begin
         diml:=diml+1;
         v[diml]:=o;
         LeerOficina(o);
     end;   
   end;
  
  procedure ImprimirVector(v:vector; diml:integer);
  var
    i:integer;
  begin
     for i:=1 to diml do begin
         writeln('Codigo: ',v[i].cod);
         writeln('Dni; ',v[i].dni);
         writeln('Valor: ',v[i].valor:4:2);
         writeln;
         writeln('');
     end;
  end;
 { b)	Ordene el vector, aplicando uno de los métodos vistos en la cursada, para obtener el vector ordenado por código de identificación de la oficina.}
 
 procedure OrdenarVector(var v:vector; diml:integer);
 var
   j,i,pos:integer; o:oficina;
 begin 
    for i:= 1 to diml-1 do begin
     pos:=i;
     for j:=i+1 to diml do 
         if(v[j].cod<v[pos].cod)then
            pos:=j;
      o:=v[pos];
      v[pos]:=v[i];
      v[i]:=o;
   end;
 end;
 
 {d)	Tenga un módulo recursivo que retorne el monto total de las expensas.}
function Expensas(v:vector; diml:integer):real;
 begin
      if(diml=0)then 
        Expensas:=0
        else
          Expensas:=v[diml].valor+ Expensas(v,diml-1);
 end;

 
 
var
  v:vector; diml:integer;
begin
   diml:=0;
  GenerarVector(v,diml);
  writeln('------------------------Vector sin orden--------------------');
  ImprimirVector(v,diml);
  writeln('----------------------------Vector ordenado por codigo -------------------------');
  OrdenarVector(v,diml);
  ImprimirVector(v,diml);
  writeln('--------------------'); 
   writeln('Monto total de expensas: ',Expensas(v,diml):4:2);
end.

