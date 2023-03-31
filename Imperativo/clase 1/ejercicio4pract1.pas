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
  vector2=array[1..30]of producto;
  
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
  

	Procedure  InsertarOrdenado(var pri:lista; p:producto);
    var ant, nue, act: lista;
    begin
      new (nue);
      nue^.dato := p;
      act := pri;
      while (act<>NIL) and (act^.dato.cod < p.cod) do begin
        ant := act;
        act := act^.sig ;
      end;
      if (act = pri) then
         pri := nue
      else 
        ant^.sig := nue;
        nue^.sig := act ;
    end;
    
procedure AlmacenarLista(var v:vector);
var
 p:producto;
begin
   inicializarVector(v);
   LeerProducto(p);
         randomize;
      p.codRubro:=random(8)+1;
      write('Codigo de Rubro: ');
      writeln(p.codRubro);
   while(p.precio<>0)do begin
     writeln('-------------------------------');
     InsertarOrdenado(v[p.codRubro],p);
     LeerProducto(p);   
      randomize;
      p.codRubro:=random(8)+1;
      write('Codigo de Rubro: ');
      writeln(p.codRubro);
   end;
end;
{------------------b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.--------------------------------------------}
 procedure ImprimirVector(v:vector);
 var i:integer;
 begin
   for i:= 1 to dimF do begin  
     if(v[i]=nil) then begin
       writeln('------------------CODIGO DE RUBRO:',i);
       writeln('para este rubro no hay elementos');
     end
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
{c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que puede haber más o menos de 30 productos del rubro 3. 
* Si la cantidad de productos del rubro 3 es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto. ----------------------------------}
  procedure GenerarVector(var v2:vector2; v:vector; var diml:integer);
  begin
     diml:=0;
     while(v[3] <>nil)and(diml<=30)do begin{recorro la lista de productos del rubro 3 y me fijo que su diml sea menos de 30 para almacenar solo esos primeros}       
         diml:=diml+1;
         v2[diml]:=v[3]^.dato;
         v[3]:=v[3]^.sig;
       end;
  end;
  
  {d. Ordene, por precio, los elementos del vector generado en b) utilizando alguno de los dos métodos vistos en la teoría. ---------------------------------}
  procedure OrdenarVector(var v2:vector2; diml:integer);
  var
    pos,i,j:integer; p:producto;
  begin
    for i:= 1 to diml-1 do begin
      pos:=i;
      for j:=i+1 to diml do
        if(v2[j].precio < v2[pos].precio)then
          pos:=j;
        p:=v2[pos];
        v2[pos]:=v2[i];
        v2[i]:=p;
    end;
  end;
{e. Muestre los precios del vector ordenado.----------------------------------------------------------------------}
  procedure ImprimirVector2(v2:vector2 ; diml:integer);
  var
    i:integer;
  begin
     for i:= 1 to diml do begin
      writeln('');
      write('Codigo: ',v2[i].cod);
      writeln('');
      write('Precio: ',v2[i].precio:4:2);
      writeln('');
      writeln('-----------------------------------------');
     end;
  end;


var
     v:vector;   v2:vector2; diml:integer;
begin
  AlmacenarLista(v);
  ImprimirVector(v); 
  GenerarVector(v2,v,diml);  
  writeln('-------------------VECTOR DE PRODUCTOS DEL RUBRO 3 -------------------------------');
  ImprimirVector2(v2,diml);
  OrdenarVector(v2,diml);        
  writeln('-------------------VECTOR DE PRODUCTOS DEL RUBRO 3 ORDENADO-----------------------');
  ImprimirVector2(v2,diml);                                              
end.
