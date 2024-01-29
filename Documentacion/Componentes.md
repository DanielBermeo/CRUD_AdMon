## GASTOS
Seccion del sistema que guardara las salidas de dinero

### Tabla
<ul>
  <li>Clasificacion</li>
  <li>Monto</li>
  <li>Concepto</li>
  <li>Fecha</li>
</ul>

### Consideraciones
<ul>
  <li>Los gastos se clasifican en Buenos, Malos y Justificados</li>
  <li>Cuando un gasto sea un abono a una deuda se debe actualizar automaticamente el saldo activo de la deuda</li>
  <li>Los gastos tomaran capital de rubros</li>
</ul>


## INGRESOS
Seccion del sistema que registrara toda adquisicion monetaria

### Tabla
<ul>
  <li>Monto</li>
  <li>Concepto</li>
  <li>Fecha</li>
</ul>

### Consideraciones
<ul>
  <li>Los ingresos deberan aumentar el capital de los rubros</li>
  <li>Cada ingreso ademas de concepto debera tener el rubro al que fue aportado</li>
</ul>


## DEUDAS
Registro de creditos obtenidos

### Tabla
<ul>
  <li>Estado</li>
  <li>Monto</li>
  <li>Concepto</li>
  <li>Fecha</li>
</ul>

### Consideraciones
<ul>
  <li>Las deudas seran desactivadas cuando su ultimo saldo activo de como resultado 0</li>
  <li>Se deben de mostrar solo los actuales con estado activos</li>
  <li>Se podran consultar las deudas historicas, con un task desmarcado por defecto</li>
</ul>

## SALDOS
Tabla intermedia que permite una dinamica de comunicacion con historial entre la tabla gastos y deudas
### Tabla
<ul>
  <li>Ids de cada tabla conectada</li>
  <li>Saldo<>
</ul>

### Consideraciones
<ul>
  <li>Se debera crear un nuevo registro en saldos por cada que el usuario haga un abono desde gastos a deudas</li>
  <li>Dentro de la consulta de deudas se debe hacer una consulta cruzada que nos de el saldo ultimo de la deuda consultada</li>
  <li>Se considerara saldo activo al mas reciente registro que contiene el id de esa deuda</li>
</ul>

## RUBROS
Tabla catalogo que ademas contara con un valor variable (capital) para dinamica de tener o no 
### Tabla
<ul>
  <li>Monto meta</li>
  <li>Concepto</li>
  <li>Capital</li>
</ul>

### Consideraciones
<ul>
  <li>Un rubro funge como division de los ingresos</li>
  <li>Un rubro nunca podra ser negativo</li>
  <li>Un rubro sera la fuente de alimentacion de los gastos</li>
  <li>Por medio de los id de rubros y consultas cruzadas a gastos e ingresos obtenemos historicos</li>
  <li>Se debera desarrollar graficos que permitan ver la pagina de rubros como metas a cumplir y su cumplimiento actual</li>
</ul>


## GRAFICOS
Seccion del sistema que perminta al usuario una visualizacion estadistica y sencilla de la informacion para la evaluacion de la misma

### Filtro
<ul>
  <li>Periodo</li>
  <li>Rubro de revision</li>
</ul>

### Consideraciones
<ul>
  <li>Los rubros que podran ser revisados en histogramas seran: Gastos e Ingresos</li>
  <li>El histograma mostrara tiempo en las absisas y dinero en las ordenadas</li>
  <li>Las consultas podran comparar los dias de las semanas (l a d actual), o los meses del año (ene a dic actual)</li>
</ul>

## NOTAS EXTRA
<ul>
  <li>La interfaz inicial tentativa sera basada en la disponibilidad</li>
  <li>La disponibilidad sera siempre la diferencia neta total de Gastos contra Ingresos</li>
</ul>

