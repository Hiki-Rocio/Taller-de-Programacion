{3.	Implementar un programa que contenga:
a. Un módulo que lea información de alumnos de Taller de Programación y almacene en una estructura de datos sólo a aquellos alumnos que posean año 
de ingreso posterior al 2010. De cada alumno se lee legajo, DNI y año de ingreso. La estructura generada debe ser eficiente para la búsqueda por 
número de legajo. 
b. Un módulo que reciba la estructura generada en a. e informe el DNI y año de ingreso de aquellos alumnos cuyo legajo sea inferior a un valor
 ingresado como parámetro. 
c. Un módulo que reciba la estructura generada en a. e informe el DNI y año de ingreso de aquellos alumnos cuyo legajo esté comprendido entre dos 
valores que se reciben como parámetro. 
d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.
e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar.
}
program ejer3pract3;
type
   alumno=record
     legajo:integer;
     dni:integer;
     anio:integer;
   end;
   
   arbol=^nodo;
   nodo=record
     dato:alumno;
     HD:arbol;
     HI:arbol;
   end;
   
 procedure GenerarArbol(var ar:arbol);
   procedure leerAlumno(var a:alumno);
   begin
      write('Legajo: ');
      readln(a.legajo);
      if(a.legajo<>0)then begin
         write('Dni: ');
         a.dni:=Random (1000) + 1;
         write(a.dni);
         writeln;
         write('Anio de ingreso: ');
         a.anio:=Random (23) + 2000;
         write(a.anio);
         writeln;
         write(' ');
         writeln;
      end;     
   end;
   
   procedure InsertarOrdenado(var ar:arbol; a:alumno);
   begin
   if(ar=nil)then begin
        new(ar);
        ar^.dato:=a;
        ar^.HI:=nil;
        ar^.HD:=nil;
     end
      else
        if(ar^.dato.legajo>a.legajo)then
         InsertarOrdenado(ar^.HI,a)
        else
          InsertarOrdenado(ar^.HD,a);   
   end;   
  var
    a:alumno;
  begin
     leerAlumno(a);
     while(a.legajo<>0)do begin
       if(a.anio>2010)then
           InsertarOrdenado(ar,a);
       leerAlumno(a);
     end;
     writeln;
      
  end;
  
  procedure ImprimirArbol(ar:arbol); 
   procedure ImprimirAlumno(a:alumno);
   begin
     writeln('Numero de legajo: ',a.legajo);
     writeln('Dni: ',a.dni);
     writeln('Anio de ingreso: ',a.anio);
     writeln;
   end;
  begin
    if(ar<>nil)then begin
      ImprimirArbol(ar^.HI);
      ImprimirAlumno(ar^.dato);
      ImprimirArbol(ar^.HD);
    end;
  end;
  
  {b. Un módulo que reciba la estructura generada en a. e informe el DNI y año de ingreso de aquellos alumnos cuyo legajo sea inferior a un valor
 ingresado como parámetro. }
 procedure ImprimirInferior(ar:arbol;valor:integer);
 begin
   if(ar<>nil)then begin
     ImprimirInferior(ar^.HI,valor);
     if(ar^.dato.legajo<valor)then begin
        writeln('Dni: ',ar^.dato.dni);
        writeln('Anio de ingreso: ',ar^.dato.anio);
        writeln;;
     end;
    ImprimirInferior(ar^.HD,valor)
   end;
 end;
 {c. Un módulo que reciba la estructura generada en a. e informe el DNI y año de ingreso de aquellos alumnos cuyo legajo esté comprendido entre dos 
valores que se reciben como parámetro. }
  
  procedure ImprimirEntreValores (ar:arbol;valor1,valor2:integer);
  begin
    if(ar<>nil)then begin
      ImprimirEntreValores(ar^.HI, valor1,valor2);
      if(ar^.dato.legajo<valor2)and(ar^.dato.legajo>valor1)then begin
         writeln('Dni: ',ar^.dato.dni);
         writeln('Anio de ingreso: ',ar^.dato.anio);
      end;
     ImprimirEntreValores(ar^.HD, valor1,valor2);
    end;
  end;
  {d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.}
  
  procedure dniMasGrande(ar:arbol);
   procedure maximo(ar:arbol; var max:integer);
   begin
     if(ar<>nil)then begin
          if(ar^.dato.dni>max)then
                max:=ar^.dato.dni;
      maximo(ar^.HI,max);
      maximo(ar^.HD,max);
    end;
   end;
  var
    max:integer;
  begin
    max:=0;
    maximo(ar,max);
    writeln('DNI: ',max);
  end;
 { e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar.}
 procedure legajoImpar(a:arbol; var cant:integer);
   function impar(legajo:integer):boolean;
   begin
        impar:=(legajo mod 2)=1;
   end;

 begin
     if(a<>nil)then begin
        if(impar(a^.dato.legajo))then 
             cant:=cant+1;
        legajoImpar(a^.HI,cant);
        legajoImpar(a^.HD,cant);
     end; 
 end;

var
  ar:arbol; valor,valor2:integer; cant:integer;
begin
       Randomize;
       cant:=0;
       writeln('-----------------------------DATOS DE ALUMNOS----------------------------');
       GenerarArbol(ar);
       writeln('-----------------------------Alumnos con anio de ingreso mayor a 2010--------------------------------');
       ImprimirArbol(ar);
       writeln('-----------------------------Alumnos cuyo legajo es inferior al numero de legajo indicado--------------------------');
       write('Ingrese el valor: ');
       readln(valor);
       ImprimirInferior(ar,valor);
       writeln('----------------------------Alumnos cuyo legajo se encuentra entre los valores que se lean a continuacion------------------');
       write('Ingrese el primer valor: ');
       readln(valor);
       write('Ingrese el segundo valor: ');
       readln(valor2);
       ImprimirEntreValores (ar,valor,valor2);
       writeln('----------------------------DNI MAS GRANDE----------------------------------------------------------');
       dniMasGrande(ar);
       writeln;
       writeln('----------------------------Cantidad de ALUMNNOS con legajo IMPAR----------------------------------------------------------');
       legajoImpar(ar,cant);
       writeln('CANTIDAD: ', cant);
end.
