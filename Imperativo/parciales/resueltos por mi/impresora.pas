program impresora;
type
   impresiones=record
     nomDoc:string;
     paginas:integer;
     tamanio:integer;
     nomUsuario:string;
    end;
    impresionesGuardar=record
      catDoc:integer;//por cadanombre de documento cuento uno
      pagTotal:integer;
      nomUltDoc:string//es el ultimoHD
     end;
     
    arbol=^nodo;
    nodo=record
      dato:impresionesGuardar;
      HD:arbol;
      HI:arbol;
    end;
  
  procedure generarArbol(var a:arbol);
      
      procedure LeerImpresiones(var imp:impresiones);
      begin
          write('Tamanio del documento: ');
          readln(imp.tamanio);
          if(imp.tamanio<>0)then begin
             write('Nombre del documento: ');
             readln(imp.nomDoc);
             write('Paginas: ');
             imp.paginas:=random(100)+1;
             writeln(imp.paginas);
             write('Nombre Usuario: ');
             readln(imp.nomUsuario);
             writeln;
             writeln('');
             writeln;
          end;
      end;

      procedure insertarElemento(var a:arbol; imp:impresiones);
      begin
         if(a=nil)then begin
           new(a);
           a^.dato:=imp;
           a^.HD:=nil;
           a^.HI:=nil;
         end
         else
            if(imp.nomUsuario<a^.dato.nomUsuario)then
               insertarElemento(a^.HI,imp)
              else
               insertarElemento(a^.HD,imp);        
     end;    
  var
      imp:impresiones;
  begin
   a:=nil;
   LeerImpresiones(imp);
   while(imp.tamanio<>0)do begin
          insertarElemento(a,imp);
          writeln;
          LeerImpresiones(imp);
   end;
  end;
  
  procedure imprimirArbol(a:arbol);
    procedure imprimir(a:arbol);
    begin
        writeln('Nombre Documento: ',a^.dato.nomDoc);
        writeln('Paginas: ',a^.dato.paginas);
        writeln('Tamanio: ',a^.dato.tamanio);
        writeln('Nombre Usuario: ',a^.dato.nomUsuario);
        writeln;
        writeln('.....');
        writeln;
    end;
  begin
    if(a<>nil)then begin
      imprimirArbol(a^.HI);
      imprimir(a);
      imprimirArbol(a^.HD);
    end; 
  end;
  
  procedure buscarUsuario(a:arbol);
     
     function maxDoc(a:arbol;maxDoc:integer)
       
  var
    nom:string;
  begin
     maxnom:='zzzzz';
     writeln('Ingrese el nombre de usuario que desea buscar: ');
     readln(nom);
     buscar(a,nom);
  end;
var  
  a:arbol;
begin
  Randomize;
  generarArbol(a);
  writeln('---------------------------------ARBOL GENERADO POR NOMBRE DE USUARIO------------------');
  imprimirArbol(a);
  
end.
