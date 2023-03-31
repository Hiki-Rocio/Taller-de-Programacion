{La Organización Mundial de la Salud (OMS) necesita un sistema para obtener estadísticas
de las dosis de vacunas aplicadas contra el COVID-19 en cada país. Cada país notifica
diariamente a la OMS la cantidad de dosis aplicadas por tipo de vacuna. De cada
notificación se conoce: fecha, nombre del país, tipo de vacuna (1:Sinopharm, 2:CanSino,
3:AstraZeneca, 4:Sputnik) y cantidad de dosis aplicadas.

Se dispone una estructura que almacena las notificaciones agrupadas por tipo de vacuna.
Para cada tipo, las notificaciones realizadas se encuentran ordenadas por nombre de país.
Implemente un programa que:

a) Reciba la estructura que almacena las notificaciones y, usando la técnica de merge
     acumulador, genere un ABB (ordenado por cantidad de dosis) que contenga para
     cada país, la cantidad total de dosis aplicadas.

b) Implementar un módulo recursivo que reciba la estructura generada en a) y retorne
    el nombre del país que aplicó la mayor cantidad de dosis.

NOTA: Cada país puede aplicar más de un tipo de vacuna por día.
No es necesario implementar la carga de la estructura que se dispone. Alcanza con declarar
el encabezado del procedimiento e invocarlo para que el programa compile
satisfactoriamente.

}
program oms;
const
  ultvacuna=4;
  valorGrande=999;
type
   rango=1..ultvacuna;
   notificaciones=record
     fecha:string;
     nomPais:string;
     vacuna:rango;
     cantDosis:integer;
    end;
    
    notGuardar=record
      fecha:string;
      nomPais:string;
      cantDosis:integer;
    end;
    
    
    lista=^nodo:
    nodo=record
      dato:notiGuardar;
      sig:lista;
    end; 
    acumulador=record
       nomPais:string;
       cantTotal:integer;
    end;
    
    arbol=^nodo;
    nodo=record;
      datoA:acumulador;
      HI:arbol;
      HD:arbol;
    end;
    
    
    vector=array[rango]of lista;
    
    procedure GenerarVectorLista(var v:vector);
      procedure InicializarVector(var v:vector);
      begin
        for i:= 1 to ultvacuna do
          v[i]:=nil;
      end;
      
      procedure LeerNot(var noti:notificaciones);
      begin
         leo--
      end;
      
      procedure armarVector(noti:notificaiones; var notG:notGuardar);
      begin
        notg.fecha=noti.fecha;
        --
      end;
      procedure insertarElemento(var l:lista; notG:notGardar);//por nombre de pais
      var
        nue,ant,act:lista;
      begin
         ..
         while()and(notG.nomPais<l^.dato.nomPais)do
      end;
    var
      noti:notificaciones
    begin
       InicializarVector();
       leerNot(noti);
       while(noti.fechal distinto de 0)do begin
                                armovector()
                                insertarElemento(v[noti.vacuna],notG);
                                leo de nuevo;
            
             
    end;
    { a) Reciba la estructura que almacena las notificaciones y, usando la técnica de merge
     acumulador, genere un ABB (ordenado por cantidad de dosis) que contenga para
     cada país, la cantidad total de dosis aplicadas.}
     procedure minimo (var v: vector; var dosisMin: notGuardar);
     var indiceMin,i:integer;
     begin
       dosisMin.cantDosis:= valorGrande;
       for i:= 1 to ultvacuna do
        begin
       if (v[i] <> nil) then
            if (v[i]^.dato.cantDosis <= dosisMin.cantDosis) then begin
                   indiceMin:= i;
                   dosisMin:= v[i]^.dato;  
            end; 
      end;
      if (dosisMin.cantDosis <> valorGrande) then
        v[indiceMin]:= v[indiceMin]^.sig;
     end;


procedure MergeAcumulador (v: vector; var a: arbol);

   procedure agregarAtras2 (var l, ult: listaAcumulador; e: elemAcumulador); 
   var  nuevo: listaAcumulador;
   begin 
     new (nuevo); nuevo^.dato:= e; nuevo^.sig := nil;
     if (l = nil) then l:= nuevo
                  else ult^.sig := nuevo;
     ult := nuevo;
   end;

var prestamoMin: prestamoAGuardar; 
    ult: listaAcumulador;
    actual: elemAcumulador;
begin
  a:= nil;
  minimo (v, DosisMin);  //corte de control
  while (dosisMin.cantDosis <> valorGrande) do
  begin
    actual.cantDosis:= dosisMin.cantDosis; actual.cantTotal:= 0;
    while (actual.ISBN = prestamoMin.ISBN) do
    begin
       actual.cantPrestamos:= actual.cantPrestamos + 1;
       minimo (v, prestamoMin);
    end;
    agregarAtras2 (l, ult, actual);
  end;
end;
begin
 GenerarVectorLista();
end;
