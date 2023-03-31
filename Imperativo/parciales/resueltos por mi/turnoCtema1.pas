{Una empresa desea procesar la informacion de lashoras trabajadas por sus empleados durante 2021
* Para ello,a empresa posee registros de las horas trabajadas por cada empleado.Cada registro consta del 
* codigo de empleado,dia,mes y la cantidad de horas trabajadas (alo sumop 8
* 
* a)Realizar un modulo que lea informacion de los empleados y retorne una
* estrucura de datos con dicha informacion agrupada por mes. Para cada mes,
* los registros deben quedar ordenaos por dia.La lectura finaliza al ingresar
* un regristro con 0 horas trabajadas. Se sugiere utilizr el modulo leer Registro()
* 
* 
* b)Realizar un modulo que reciba la estructura generada en a), y retorne una estructura
* eficiente para la busqueda por codigo de empleado, que contenga para cada empleado la suma de 
* todas las horas trabajadas.
* 
* 
* c)Realice un modulo que reciba la estructura generada en el inciso b), y retorne la 
* cantidad de horas que trabaja el empleado con menor codigo de toda la empresa.}


program turnoCtema1;
type
   rango1=1..31;
   rango2=1..12;
   rango3=0..8;
   
   empleados=record
     codEmpleado:integer;
     dia:rango1;
     mes:rango2;
     cantHoras:rango3;
   end;
   
   empleadosGuardar=record
        codEmpleado:integer;
        dia:rango1;
        cantHoras:integer;
   end;
   
   lista=^nodo;
   nodo=record
     dato:empleadosGuardar;
     sig:lista;
   end;
   
   empleadoArbol=record
     cantTotal:integer;
     cod:integer;
   end;
   arbol=^nodoA;
   nodoA=record
     dato:empleadoArbol;
     HI:arbol;
     HD:arbol;
   end;
   
   vector=array[rango2]of lista;
   
   
   
   procedure generarVectorListas(var v:vector);
      procedure LeerEmpleados(var e:empleados);
      begin
         write('Cantidad de Horas: ');
         readln(e.cantHoras);
         if(e.cantHoras<>0)then begin
            write('Dia: ');
            e.dia:=random(31)+1;
            writeln(e.dia);
            write('Mes: ');
            e.mes:=random(12)+1;
            writeln(e.mes);
            write('Codigo empleado: ');
           { e.codEmpleado:=random(100)+1;
            writeln(e.codEmpleado);}
            readln(e.codEmpleado);
            writeln;
            writeln('');
         end;
      end;
      
      procedure InicializarVector(var v:vector);
      var
        i:integer;
      begin
        for i:= 1 to 12 do
          v[i]:=nil;
      end;
      procedure armarVector(e:empleados; var eg:empleadosGuardar);
      begin
          eg.codEmpleado:=e.codEmpleado;
          eg.dia:=e.dia;
          eg.cantHoras:=e.cantHoras;
      end;
      procedure insertarElemento(var l:lista; eg:empleadosGuardar);
      var
        ant,act,nue:lista;
      begin
        new(nue);
        nue^.dato:=eg;
        nue^.sig:=nil;
        ant:=l;
        act:=l;
        while(act<>nil)and(l^.dato.dia<eg.dia)do begin
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
    e:empleados; eg:empleadosGuardar;
   begin
      InicializarVector(v);
      LeerEmpleados(e);
      while(e.cantHoras<>0)do begin
           armarVector(e,eg);
           insertarElemento(v[e.mes],eg);//ordanado por dia agrupado por mes
           LeerEmpleados(e);
      end;
   end;
   procedure imprimirVectorLista(v:vector);
     procedure imprimirLista(l:lista);
     begin
       if(l<>nil)then begin
          writeln('Codigo empleado: ',l^.dato.codEmpleado);
          writeln('Dia: ',l^.dato.dia);
          writeln('Cantidad horas trabajadas: ',l^.dato.cantHoras);
          writeln;
          writeln('');
          imprimirLista(l^.sig);
        end;  
     end;
   var
     i:integer;
   begin
      for i:= 1 to 12 do begin
        writeln('------------------Mes ',i,'---------------');
        if(v[i]=nil)then
          writeln('No hay elementos')
          else
           imprimirLista(v[i]);
      end;
   end;
{* b)Realizar un modulo que reciba la estructura generada en a), y retorne una estructura
* eficiente para la busqueda por codigo de empleado, que contenga para cada empleado la suma de 
* todas las horas trabajadas.}
    procedure crearNodo(e:empleadosGuardar; var aux:empleadoArbol);
    begin
       aux.cod:=e.codEmpleado;
       aux.cantTotal:=e.cantHoras
    end;
    
    procedure generarArbol(var a:arbol; v:vector);//por cod de empleado//sumahoras trabajadas
        procedure armarArbol(var a:arbol; e:empleadosGuardar);
        var
          aux:empleadoArbol;
        begin
          if(a=nil)then begin
            new(a);
            crearNodo(e,aux);
            a^.dato:=aux;
            a^.HD:=nil;
            a^.HI:=nil;
         end
         else
           if(e.codEmpleado<a^.dato.cod)then
             armarArbol(a^.HI,e)
             else
               if(e.codEmpleado>a^.dato.cod)then
                 armarArbol(a^.HD,e)
                 else
                   a^.dato.cantTotal:=a^.dato.cantTotal+e.cantHoras;
        end;
   var
     i:integer;
   begin
    for i:= 1 to 12 do 
      while(v[i]<>nil)do begin  
          armarArbol(a,v[i]^.dato);
          v[i]:=v[i]^.sig;
      end;
   end;
    procedure ImprimirArbol(a:arbol);
    begin                    

       if(a<>nil)then begin
          ImprimirArbol(a^.HI);
          write('Codigo: ',a^.dato.cod);
          writeln;
          write('Cantidad total: ',a^.dato.cantTotal);
          writeln;
          ImprimirArbol(a^.HD);
       end;    
    end;
    {* c)Realice un modulo que reciba la estructura generada en el inciso b), y retorne la 
* cantidad de horas que trabaja el empleado con menor codigo de toda la empresa.}
    
    procedure InformarHoras(a:arbol);
      function MenorCodigo(a:arbol):arbol;
      begin
        if((a=nil)or (a^.HI=nil))then
          MenorCodigo:=a
          else
            MenorCodigo:=MenorCodigo(a^.HI);
      end;
    var
      minCod:arbol;
    begin
       minCod:= MenorCodigo(a);
       if (minCod = nil) then
            writeln ('Arbol sin elementos')
       else begin
         writeln;
         writeln ('Codigo mas chico: ',minCod^.dato.cod,' Cantidad total de horas: ',minCod^.dato.cantTotal); 
         writeln;
       end;
    end;

var
  v:vector; a:arbol;
begin
  Randomize;
  a:=nil;
  generarVectorListas(v);
  writeln('--------------------VECTOR LISTA-------------');
  imprimirVectorLista(v);
  generarArbol(a,v);
  writeln('--------------------arbol-------------');
  ImprimirArbol(a);
  writeln;
  writeln ('----- Informar Cantidad de horas del empleado con codigo mas chico ----->');
  writeln;
  InformarHoras(a);
end.
