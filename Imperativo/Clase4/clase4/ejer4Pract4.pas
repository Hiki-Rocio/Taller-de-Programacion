{4.	Un teatro tiene funciones los 7 días de la semana. Para cada día se tiene una lista con las entradas vendidas. 
* Se desea procesar la información de una semana. Implementar un programa que:
a.	Genere 7 listas con las entradas vendidas para cada día. De cada entrada se lee día (de 1 a 7), código de la obra, asiento y monto.
*  La lectura finaliza con el código de obra igual a 0. Las listas deben estar ordenadas por código de obra de forma ascendente. 
b.	Genere una nueva lista que totalice la cantidad de entradas vendidas por obra. Esta lista debe estar ordenada por código de obra de forma ascendente.
}


program ejer4Pract4;
const
   finDia=7;
   valorGrande=999;
type
    rango=1..finDia;
    entrada=record
      dia:rango;
      codObra:integer;
      asiento:integer;
      monto:real;
    end;
    
    entradaGuardar=record
      codObra:integer;
      asiento:integer;
      monto:real;
    end;
    
    lista=^nodo;
    nodo=record
      dato:entradaGuardar;
      sig:lista;
    end;
    
    acumulador=record
       codObra:integer;
       cantTotal:integer;
    end;
    
    listaA=^nodoA;
    nodoA=record
       dato:acumulador;
       sig:listaA;
    end;
    
    
    vector=array[1..finDia]of lista;

    procedure GenerarVectorListas(var v:vector);
          
          procedure leerEntrada (var e:entrada);
          begin
             write('Codigo de Obra: ');
             readln(e.codObra);
             if(e.codObra <> 0)then begin
                 write('Dia: ');
                 e.dia:=random (7) + 1;
                 write(e.dia);
                 writeln;
                 writeln('');                 
                 write('Asiento: ');
                 e.asiento:=Random (100) +1;
                 write(e.asiento);
                 writeln;
                 write('');
                 write('Monto: ');
                 e.monto:=random (1000)+1;
                 write(e.monto:4:2);
                 writeln;
                 writeln('');
                 writeln;
              end;   
          end;
          
          procedure InicializarVector(var v:vector);
          var
            i:integer;
          begin
            for i:=1 to finDia do 
              v[i]:=nil;
          end;
          
            
          procedure InsertarEntrada(var l:lista;eg:entradaGuardar);
          var
             nue,act,ant:lista;
          begin
             new(nue);
             nue^.dato:=eg;
             ant:=l;
             act:=l;
             while(act <> nil)and(act^.dato.codObra <eg.codObra)do begin
                    ant:=act;
                    act:=act^.sig;
             end;
             if(act=ant)then
                 l:=nue
               else
                  ant^.sig:=nue;
              nue^.sig:=act;
                 
                    
          end;
          
        procedure armarVector(e:entrada; var eg:entradaGuardar);
          begin
             eg.codObra:=e.codObra;
             eg.asiento:=e.asiento;
             eg.monto:=e.monto;
          end;  
    var
       e:entrada; eg:entradaGuardar;
    begin
        InicializarVector(v);
        leerEntrada(e);
        while(e.codObra <> 0)do begin
               armarVector(e,eg);
               InsertarEntrada(v[e.dia],eg);
               leerEntrada(e);
        end;
    end;
    
    procedure ImprimirVectorListas(v:vector);
          
          procedure ImprimirLista(l:lista);
          begin
              if(l<> nil)then begin
                  writeln('Codigo de Obra: ',l^.dato.codObra);
                  writeln('Numero de asiento: ',l^.dato.asiento);
                  writeln('Monto: ',l^.dato.monto:4:2);                
                  writeln;
                  writeln('');
                  ImprimirLista(l^.sig);
              end;
          end;
    
    var
      i:integer;
    begin
       for i:=1 to finDia do begin
               writeln;
              writeln('-----Dia ',i,'------');
              if(v[i]=nil)then
                     writeln('No hay elementos')
                     else
                       ImprimirLista(v[i]);
       end;
    end;
    
 {   b.	Genere una nueva lista que totalice la cantidad de entradas vendidas por obra. Esta lista debe estar ordenada por código de obra de forma ascendente.
}

    procedure merge(v:vector; var lA:listaA);//´paso el vector para armas una nueva etsructura enlista
                  
          procedure minimo(var v:vector; var entradaMin:entradaGuardar);
          var
            i,indiceMin:integer;
          begin
             entradaMin.codObra:=valorGrande;
             for i:= 1 to finDia do begin
                if(v[i]<>nil)then 
                   if(v[i]^.dato.codObra<=entradaMin.codObra)then begin
                       indiceMin:=i;
                       entradaMin:=v[i]^.dato
                   end;          
             end;
               if(entradaMin.codObra<>valorGrande)then
                 v[indiceMin]:=v[indiceMin]^.sig;
          end;
         
         procedure agregarAtras(var l,ult:listaA; actual:acumulador);
         var
           nue:listaA;
         begin
           new(nue);
           nue^.dato:=actual;
           nue^.sig:=nil;
           if(l=nil)then 
                l:=nue
                else
                   ult^.sig:=nue;
           ult:=nue;
                
         end;
    
    var
     act:acumulador; entradaMin:entradaGuardar; ult:listaA;
      
    begin
       lA:=nil;
       minimo(v,entradaMIn);
       while(entradaMin.codObra<>valorGrande)do begin
          act.codObra:=entradaMin.codObra;
          act.cantTotal:=0;
          while(act.codObra=entradaMin.codObra)do begin
                 act.cantTotal:=act.cantTotal+ 1; 
                 minimo(v,entradaMin);             
          end;
          agregarAtras(lA,ult,act);
       end;
    end;
    
    procedure ImprimirListaAcumulador(lA:listaA);
         procedure ImprimirListaA(lA:listaA);
         begin
           if(lA<>nil)then begin
              writeln('Codigo de Obra: ',lA^.dato.codObra);
              writeln('Cantidad de entradas vendidas: ',lA^.dato.cantTotal);
              writeln('');
              writeln;
              ImprimirListaA(lA^.sig);
            end;
         end;
    
    begin
       if(lA=nil)then 
           writeln('No hay elementos')
         else
              ImprimirListaA(lA);            
    end;
var
  v:vector; lA:listaA;
begin
   Randomize;
  GenerarVectorListas(v);
  writeln;
  writeln('-------------------------Informe de entradas VENDIDAS---------------------');
  ImprimirVectorListas(v);
  writeln;
  writeln('-------------------------Informe de cantidad de entradas vendidas por codigo---------------------');
  merge(v,lA);
  ImprimirListaAcumulador(lA);
end.
