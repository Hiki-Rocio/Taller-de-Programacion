{3.	Implementar un programa que procese la información de las ventas de productos de una librería que tiene 4 sucursales. 
* De cada venta se lee fecha de venta, código del producto vendido, código de sucursal y cantidad vendida. 
* El ingreso de las ventas finaliza cuando se lee el código de sucursal 0. Implementar un programa que:
a.	Almacene las ventas ordenadas por código de producto y agrupados por sucursal, en una estructura de datos adecuada.
b.	Contenga un módulo que reciba la estructura generada en el punto a y retorne una estructura donde esté acumulada la cantidad total vendida 
* para cada código de producto.
}

program ejer3Pract4;
const
  dimF=4; valorGrande=999;
type
    Fechas=record
      dia:integer;
      mes:integer;
      anio:integer;
    end;
   venta=record
     fecha:Fechas;
     cod:integer;
     codSucursal:0..4;
     cant:integer;
   end;
   ventaGuardar=record
     fecha:Fechas;
     cod:integer;
     cant:integer;
   end;
   
    lista=^nodo;
    nodo=record
      dato:ventaGuardar;
      sig:lista;
    end;
   vector=array[1..dimF] of lista;
   
   acumulador=record
      cod:integer;
      cantTotal:integer;
   end;
   
   listaA=^nodoA;
   nodoA=record
     dato:acumulador;
     sig:listaA;
   end;
   
   
   procedure generarVector(var v:vector);
     procedure leerVenta(var ven:venta);
       procedure leerFecha(var f: Fechas);
	   begin
		f.dia:= random(31) + 1;
		writeln(' -> Dia: ', f.dia);
		f.mes:= random(12) + 1;
		writeln(' -> Mes: ', f.mes);
		f.anio:= 2023;
		writeln(' -> Anio: ', f.anio);
	   end;
     begin
       write('Codigo Sucursal: ');
       readln(ven.codSucursal);
       if(ven.codSucursal<>0)then begin
         write('Codigo: ');
         {ven.cod:=Random (100)+1;}
         readln(ven.cod);
         writeln;
         writeln('Ingrese fecha:');
         leerFecha(ven.fecha);
         write('Cantidad: ');
         ven.cant:=Random (100)+1;
         write(ven.cant);
         writeln;
         write('');
         writeln;
      end; 
     end;
     
     procedure InicializarVector(var v:vector);
     var
      i:integer;
     begin
       for i:= 1 to dimF do 
         v[i]:=nil;
     end;
     
     procedure armarVector (ven:venta;var vg:ventaGuardar );
     begin
        vg.fecha.dia:=ven.fecha.dia;
        vg.fecha.mes:=ven.fecha.mes;
        vg.fecha.anio:=ven.fecha.anio;
        vg.cod:=ven.cod;
        vg.cant:=ven.cant;
     end;
     
     procedure InsertarVentas(var l:lista;vg:ventaGuardar);
     var
       ant,act,nue:lista;
     begin
       new(nue);
       nue^.dato:=vg;
       ant:=l;
       act:=l;
       while(act<>nil)and(act^.dato.cod < vg.cod)do begin
          ant:=act;
          act:=act^.sig;
       end;
         if(act=ant)then
            l:=nue
         else
           ant^.sig:=nue;
        nue^.sig:=act;
     end;
     
   var
     vg:ventaGuardar; ven:venta;
   begin
      InicializarVector(v);
      leerVenta(ven);
      while(ven.codSucursal<>0)do begin
        armarVector(ven,vg);
        InsertarVentas(v[ven.codSucursal],vg);
        leerVenta(ven);
      end;
   end;
   
   procedure ImprimirVectorListas(v:vector);
     procedure ImprimirLista(l:lista);
     begin
        if(l<>nil)then begin
          writeln('Codigo: ',l^.dato.cod);
          writeln('Fecha: ',l^.dato.fecha.dia, '/',l^.dato.fecha.mes,'/',l^.dato.fecha.anio);
          writeln('Cantidad: ',l^.dato.cant);
          writeln;
          writeln('');
          writeln;
          ImprimirLista(l^.sig);
        end;
     end;
   var
     i:integer;
   begin
     for i:= 1 to dimF do begin
       writeln('----Sucursal ',i ,'---------------');
       if(v[i]=nil)then
             writeln('No hay elementos')
        else
               ImprimirLista(v[i]);
     end;  
   end;
   {b.	Contenga un módulo que reciba la estructura generada en el punto a y retorne una estructura donde esté acumulada 
   * la cantidad total vendida para cada código de producto.}
   procedure MergeAcumulador(v:vector; var lA:listaA);
     procedure minimo(var v:vector; var ventaMin:ventaGuardar);
     var
       i,indiceMin:integer;
     begin
       ventaMin.cod:=valorGrande;
       for i:= 1 to dimF do begin
         if(v[i]<>nil)then
            if(v[i]^.dato.cod<=ventaMin.cod)then begin
               indiceMin:=i;
               ventaMin:=v[i]^.dato;               
            end;
       end;
       if(ventaMin.cod<>valorGrande)then
          v[indiceMin]:=v[indiceMin]^.sig;
     end;
     
     procedure agregarAtras(var lA,ult:listaA; a:acumulador);
     var
       nue:listaA;
     begin
       new(nue);
       nue^.dato:=a;
       nue^.sig:=nil;
       if(lA=nil)then
         lA:=nue
         else
           ult^.sig:=nue;
       ult:=nue;
     end;
   var
      actual:acumulador;
      ult:listaA;
      ventaMin:ventaGuardar;
      
      
   begin
     lA:=nil;
     minimo(v,ventaMin);
     while(ventaMin.cod<>valorGrande)do begin
        actual.cod:=ventaMin.cod;
        actual.cantTotal:=0;
        while(ventaMin.cod=actual.cod)do begin
           actual.cantTotal:=actual.cantTotal+ventaMin.cant;
            minimo(v,ventaMin);
        end;
        agregarAtras(lA,ult,actual);
     end;
   end;
   
   procedure ImprimirEstructuraMergeAcumulador(lA:listaA);
     procedure imprimirListaAcumulador(lA:listaA);
     begin
       if(lA<>nil)then begin
         writeln('CODIGO: ',lA^.dato.cod);
         writeln('Cantidad Total: ',lA^.dato.cantTotal);
         writeln('');
         writeln;
         imprimirListaAcumulador(lA^.sig);
       end;
     end;
     
   begin
     writeln;
     writeln ('----- Estructura merge acumulador ----->');
     writeln;
     if (lA = nil ) then 
          writeln ('      Sin elementos')
     else 
         imprimirListaAcumulador (lA);
   end;
var
  v:vector; lA:listaA;
begin
  generarVector(v);
  write ('----------------Informe de ventas por sucursal-------------------');
  writeln;
  ImprimirVectorListas(v);
  MergeAcumulador(v,lA);
  ImprimirEstructuraMergeAcumulador(lA);
end.
