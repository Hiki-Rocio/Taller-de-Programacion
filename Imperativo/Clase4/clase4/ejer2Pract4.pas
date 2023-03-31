{2.	Un cine posee la lista de películas que proyectará durante el mes de octubre. De cada película se conoce: código de película, código de género (1: acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélica, 7: documental y 8: terror) y puntaje promedio otorgado por las críticas. Implementar un programa que contenga:
a.	Un módulo que lea los datos de películas y los almacene ordenados por código de película y agrupados por código de género, 
* en una estructura de datos adecuada. La lectura finaliza cuando se lee el código de película -1. 
b.	Un módulo que reciba la estructura generada en el punto a y retorne una estructura de datos donde estén todas las películas almacenadas ordenadas por código de película.
}

program ejer2Pract4;
const
  dimF=8;
  valorGrande=999;
type
   rango=1..8;
   pelicula=record
     cod:integer;
     codGenero:rango;
     puntaje:real;
     end;
      
      PeliculaGuardar=record
       cod:integer;
        puntaje:real;
      end;
     
     lista=^nodo;
     nodo=record
       dato:PeliculaGuardar;
       sig:lista;
     end;
     
     vector=array[1..dimF]of lista;
    
      
      procedure guardarPelicula(var v:vector);
        procedure leerPelicula(var p:pelicula);
        begin
          writeln('Cod: ');
          readln(p.cod);
          if(p.cod<>-1)then begin
            writeln('Codigo de Genero: ');
            readln(p.codGenero);
            writeln('Puntaje: ');
            readln(p.puntaje);
          end;
        end;
        
        procedure InicializarVector(var v:vector);
        var
          i:integer;
         begin
            for i:= 1 to dimF do 
              v[i]:=nil;
         end;
         
         procedure GenerarPelicula(p:pelicula;var gp:PeliculaGuardar);
         begin
            gp.cod:=p.cod;
            gp.puntaje:=p.puntaje;
         end;
         
         procedure insertarOrdenado(var l:lista; gp:peliculaGuardar);
         var ant,act,nue:lista;
         begin
			new(nue);
			nue^.dato:=gp;
			ant:=l;
			act:=l;
			while (act <> nil) and (act^.dato.cod < gp.cod) do begin 
				ant:=act;
				act:=act^.sig;
			end;
			if (ant = act) then 
				l:=nue
			else
				ant^.sig:=nue;
			nue^.sig:=act;
         end;
      var 
        p:pelicula; gp:PeliculaGuardar; 
      begin
           InicializarVector(v);
          leerPelicula(p);
          while(p.cod<>-1)do begin
            GenerarPelicula(p,gp);
            insertarOrdenado(v[p.codGenero],gp);
            leerPelicula(p);
           end;
      end;
      
      procedure ImprimirVectorListas(v:vector);
        procedure ImprimirLista(l:lista);
        begin
          if(l<>nil)then begin
            writeln('Cod: ',l^.dato.cod);
            ImprimirLista(l^.sig);
          end;
        end;
      var i:integer;
      begin
        for i:= 1 to dimF do begin
          writeln('Codigo de genero: ',i);
           if(v[i]=nil)then
             writeln('No hay elementos')
             else
               ImprimirLista(v[i]);
         end;
      end;
      
      procedure Merge (v:vector; var l:lista);
        procedure minimo(var v:vector; var codmin:PeliculaGuardar);
        var
         i,indiceMin:integer; 
         begin
			codmin.cod := valorGrande;
			for i:=1 to dimf do begin 
				if (v[i] <> nil) then
					if(v[i]^.dato.cod <= codmin.cod) then begin
						indiceMin:=i;
						codmin:=v[i]^.dato;
					end;
			end;
			if (codmin.cod <> valorGrande) then 
				v[indiceMin]:=v[indiceMin]^.sig;
         end;
         
         procedure insertarAtras(var l,ult:lista; codmin:peliculaGuardar);
         var nue:lista;
         begin
			new(nue);
			nue^.dato:=codmin;
			nue^.sig:=nil;
			if (l=nil) then 
				l:=nue
			else
				ult^.sig:=nue;
			ult:=nue;
         end;
         
       var codmin:peliculaGuardar; ult:lista;
      begin
        l:=nil;
        minimo(v,codmin);
        while(codmin.cod<>valorGrande)do begin
           insertarAtras(l,ult,codmin);
           minimo(v,codmin);
          end;
      end;
        procedure ImprimirLista(l:lista);
        begin
          if(l<>nil)then begin
            writeln('Cod: ',l^.dato.cod);
            ImprimirLista(l^.sig);
          end;
        end;
var
  v:vector; l:lista;
begin
  GuardarPelicula(v);
  ImprimirVectorListas(v);
  merge(v,l);
  writeln('lista merge');
  imprimirLista(l);
end.
