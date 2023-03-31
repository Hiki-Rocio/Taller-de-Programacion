{Una escuela secundaria organiza un concurso de fotografia entre todos sus alumnos.
* Cada alumno presenta una fotografia, la cual es valorada por un jurado experto el cual le asigna  puntaje(numero real)
* enre 0 y 100. Delos alumnos se desea registrar su nombre, dni y puntaje
* otorgado a su fotografia
* 
* implemente en pascal:
* 
* a)Un modulo que realice la inscripcion de los alumnos almacenando toda la informacion
* en una estructura que permita la busqueda eficiente de alumnos por puntaje
* otorgado. La carga finaliza hasta leerr el alumno con dni igual a cero.
* 
* b) Un modulo que reciba la estructura generada en a), un rango de puntajes
* (dos numeros reales, por ejemplo 60,5 y 80,2)y devuelva una lista ordenada por puntaje;
* donde en esta lista se encuentren todos las alumnos cuyo puntaje este incluido
* en el rango recibido.NOTA este modulo debe ser lo mas eficinte posible
* en cuanto a tiempo de ejecucion.
* 
* c)Un modulo que reciba la estructura generada en a) y devuela el puntaje
* del alumno con dni mas chico. }
program fotograia;
type
   alumno=record
     nom:string;
     dni:integer;
     puntaje:real;
   end;
   
   arbol=^nodo;
   nodo=record
     dato:alumno;
     HI:arbol;
     HD:arbol;
   end;
   
   lista=^nodoL;
   nodoL=record
      dato:alumno;
      sig:lista;
   end;
   
   procedure GenerarArbol(var a:arbol);
      procedure leerAlumno(var al:alumno);
      begin
         writeln('DNI: ');
         readln(al.dni);
         if(al.dni<>0)then begin
            writeln('Nombre del Alumno: ');
            readln(al.nom);
            writeln('Puntaje: ');
            readln(al.puntaje);
            writeln;
            writeln('');
         end;
      end;
      
      procedure insertarElemento(var a:arbol; al:alumno);
      begin
        if(a=nil)then begin
         new(a);
         a^.dato:=al;
         a^.HI:=nil;
         a^.HD:=nil;
        end
        else
          if(al.puntaje<a^.dato.puntaje)then
             insertarElemento(a^.HI,al)
             else
              insertarElemento(a^.HD,al);
      end;
      
   var
    al:alumno;
   begin
     leerAlumno(al);
     while(al.dni <> 0 )do begin
          insertarElemento(a,al);
          leerAlumno(al);
     end;
   end;
   
   procedure ImprimirARBOL(a:arbol);
   begin
      if(a<>nil)then begin
        ImprimirARBOL(a^.HI);
        writeln('Puntaje: ',a^.dato.puntaje:4:2);
        writeln('Dni: ',a^.dato.dni);
        writeln('Nombre: ',a^.dato.nom);
        ImprimirARBOL(a^.HD);
        writeln;
        writeln('');
      end;
   end;
   { b) Un modulo que reciba la estructura generada en a), un rango de puntajes
* (dos numeros reales, por ejemplo 60,5 y 80,2)y devuelva una lista ordenada por puntaje;
* donde en esta lista se encuentren todos las alumnos cuyo puntaje este incluido
* en el rango recibido.NOTA este modulo debe ser lo mas eficinte posible
* en cuanto a tiempo de ejecucion.}
   procedure entrePuntajes(a:arbol; var l:lista);
       
	      procedure insertarOrdenado(var l: lista; a: alumno);
        	var
		  nue, act, ant: lista;
	   begin
		new(nue);
		nue^.dato:= a;
		nue^.sig:= nil;
		act:= L;
		ant:= L;
		while (act <> nil) and (act^.dato.puntaje < a.puntaje) do begin
			ant:= act;
			act:= act^.sig;
		end;
		if(act = ant) then
			L:= nue
		else
			ant^.sig:= nue;
		nue^.sig:= act;
	   end;
       
       
       procedure hacerListado(a:arbol;var l:lista;puntaje1,puntaje2:real);
       begin
         if(a<>nil)then          
           if(puntaje1<=a^.dato.puntaje)and(puntaje2>=a^.dato.puntaje)then begin
              insertarOrdenado(l, a^.dato);
              hacerListado(a^.HI,l,puntaje1,puntaje2);
              hacerListado(a^.HD,l,puntaje1,puntaje2);
            end
            else
            hacerListado(a^.HI,l,puntaje1,puntaje2)
         else
            hacerListado(a^.HD,l,puntaje1,puntaje2); 
       end;
      
     
     
     procedure ImprimirLista(l:lista);
     begin
       if(l<>nil)then begin
          writeln('Puntaje: ',l^.dato.puntaje:4:2);
          writeln('DNI: ',l^.dato.dni);
          writeln('Nombre: ',l^.dato.nom);
          writeln('');
          writeln;
          ImprimirLista(l^.sig);
       end;
     end;
   var
     puntaje1,puntaje2:real; 
   begin
        writeln('------INGRESO DE VALORES------');
      write('Ingrese el Puntaje 1: ');
      readln(puntaje1);
      write('Ingrese el Puntaje2: ');
      readln(puntaje2);
      hacerListado(a,l,puntaje1,puntaje2);
      if(l=nil)then
         writeln('NNO HAY ELEMENTOS')
         else
            ImprimirLista(l);//como  armar la lista
      
   end;
   {c)Un modulo que reciba la estructura generada en a) y devuela el puntaje
* del alumno con dni mas chico. }
    procedure puntajeMin(a:arbol);
     procedure minimo(a:arbol;var min:integer);
      begin
          if(a<>nil)then begin
              if(a^.dato.dni<min)then 
                 min:=a^.dato.dni;
          minimo(a^.HI,min);
          minimo(a^.HD,min);
         end;         
      end;
      var
        min:integer;
    BEGIN
       min:=999;
       minimo(a,min);
       writeln('El Puntaje para el dni ',a^.dato.dni,' es ',a^.dato.puntaje:4:2);
           
    END;
   
var
   a:arbol; l:lista;
begin
  a:=nil;
   l:=nil;
  GenerarArbol(a);
  writeln('---------------Arbol ordenado por puntaje-------------------------');
  ImprimirARBOL(a);
  writeln('-----------------Listado entre puntajes----------------------');
  entrePuntajes(a,l);
  writeln('---------------');
  puntajeMin(a);
end.
