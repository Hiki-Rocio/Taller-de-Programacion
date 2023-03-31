{2.- Una agencia dedicada a la venta de autos ha organizado su stock y, dispone en papel de la información de los autos en venta.
Implementar un programa que:
a)	Genere un árbol binario de búsqueda ordenado por patente identificatoria del auto en venta. Cada nodo del árbol debe contener patente,
*  año de fabricación (2010..2018), la marca y el modelo.
b)	Invoque a un módulo que reciba el árbol generado en a) y una marca y retorne la cantidad de autos de dicha marca que posee la agencia. Mostrar el resultado. 
c)	Invoque a un módulo que reciba el árbol generado en a) y retorne una estructura con la información de los autos agrupados por año de fabricación.
d)	Contenga un módulo que reciba el árbol generado en a) y una patente y devuelva el año de fabricación del auto con dicha patente. Mostrar el resultado. 
}
program ejer2;
type
    rango=2010..2018;
   venta=record
     patente:integer;
     anio:rango;
     marca:string;
     modelo:integer;
   end;
   
   arbol=^nodo;
   nodo=record
     dato:venta;
     HI:arbol;
     HD:arbol;
   end;
   
   ventaGuardar=record
     patente:integer;
     marca:string;
     modelo:integer;
   end;
   
   lista=^nodog;
   nodog=record
     dato:ventaGuardar;
     sig:lista;
    end;
    
   vector=array[rango]of lista;
   
   procedure GenerarArbol(var a:arbol);
	procedure leerVenta(var ven:venta);
	begin
		writeln;
		writeln('---');
		writeln('Ingrese nro de patente: ');
		readln(ven.patente);
		if(ven.patente <> 0) then begin
			ven.anio := random(8) + 2011;
			writeln('Ingrese anio de fabricacion: ', ven.anio);
			write('Ingrese marca: ');
			readln(ven.marca);
			ven.modelo:= random(10) + 1;
			writeln('Ingrese modelo: ', ven.modelo);
		end;
		writeln('---');
		writeln;
	end;
	  procedure insertarElemento(var a:arbol;ven:venta );
	  begin
	     if(a=nil)then begin
	       new(a);
	       a^.dato:=ven;
	       a^.HI:=nil;
	       a^.HD:=nil;
	      end
	      else
	        if(ven.patente<a^.dato.patente)then
	          insertarElemento(a^.HI,ven)
	          else
	            insertarElemento(a^.HD,ven);
	  end;
  var
  ven:venta;
   begin
     a:=nil;
     leerVenta(ven);
     while(ven.patente<>0)do begin
          insertarElemento(a,ven);
          leerVenta(ven);
     end
   end;
   
   procedure ImprimirARBOL(A:ARBOL);
   begin
      if(a<>nil)then begin
        ImprimirARBOL(a^.HI);
        writeln('patente',a^.dato.patente);
        ImprimirARBOL(a^.HD);
      end;
   end;
   {b)	Invoque a un módulo que reciba el árbol generado en a) y una marca y retorne la cantidad de autos de dicha marca que posee la agencia. Mostrar el resultado. }
   
   procedure AutosMarca(a:arbol);
      function buscarMarca(a:arbol; marca:string):integer;
      begin
        if(a=nil)then
           buscarMarca:=0
           else begin
             if(a^.dato.marca=marca)then
                buscarMarca:=1+buscarMarca(a^.HI,marca)+buscarMarca(a^.HD,marca)
                else
                  buscarMarca:=buscarMarca(a^.HI,marca)+buscarMarca(a^.HD,marca);
           end;        
      end;
   var
     marca:string;
   begin
     writeln('ingrese una marca: ');
     readln(marca);
     writeln('La cantida de autos que tiene la marca ',marca, ' es: ',buscarMarca(a,marca));
     
   end;
   {c)	Invoque a un módulo que reciba el árbol generado en a) y retorne una estructura con la información de los autos agrupados por año de fabricación.}
         procedure InicializarVector (var vec:vector);
      var
        i:integer;
      begin
        for i:= 2010 to 2018 do
           vec[i]:=nil;
      end;
   
   procedure GenerarVectorLista (a:arbol; var vec:vector);

      
      procedure armarVector(v:venta;var vg:ventaGuardar);
      begin
         vg.patente:=v.patente;
         vg.marca:=v.marca;
         vg.modelo:=v.modelo;
      end;
      
      procedure AgregarAdelante(var l:lista; vg:ventaGuardar);
      var
        nue:lista;
      begin
        new(nue);
        nue^.dato:=vg;
        nue^.sig:=l;
        l:=nue;
      end;
   var
     vg:ventaGuardar;
   begin

      if(a<>nil)then begin
         armarVector(a^.dato,vg);
         agregarAdelante(vec[a^.dato.anio],vg);
         GenerarVectorLista(a^.HI,vec);
         GenerarVectorLista(a^.HD,vec);
     end;
   end;
   procedure imprimirVectorLista(v:vector);
     procedure imprimirLista(l:lista);
     begin
       	if(L <> nil) then begin
	  	writeln('/\/\/\/\');
	   writeln(' -> Patente: ', l^.dato.patente);
	   writeln(' -> Marca: ', l^.dato.marca);
	   writeln(' -> Modelo: ', l^.dato.modelo);
	   writeln('\/\/\/\/');
		imprimirLista(l^.sig);
	end;
     end;
   var
    i:integer;
   begin
     for i:= 2010 to 2018 do begin
         writeln('AÑO: ',i);
         if(v[i]=nil)then
           writeln('No hay elementos')
           else
             imprimirLista(v[i]);
     end;
   end;
var
   a:arbol; v:vector;
begin
   GenerarArbol(a);
   ImprimirARBOL(A);
   writeln('------------CANTIDAD DE AUTOS POR MARCA------------------');
   AutosMarca(a);
   writeln('...........VECTOR.........................');
   InicializarVector(v);
   GenerarVectorLista (a,v);
   imprimirVectorLista(v);
end.

