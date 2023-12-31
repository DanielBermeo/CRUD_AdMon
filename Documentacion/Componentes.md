## GASTO
Seccion del sistema que guardara las fugas o salidas de dinero

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
  <li>Cuando un gasto sea un abono a un ahorro o deuda se debe actualizar automaticamente ese rubro</li>
  <li>Deben poderse registrar gastos que sean aplicados a los ahorros</li>
</ul>


## INGRESOS
Seccion del sistema que guardara activos y pasivos que ingresen dinero

### Tabla
<ul>
  <li>Monto</li>
  <li>Concepto</li>
  <li>Fecha</li>
</ul>

### Consideraciones
<ul>
  <li>Se podra contar con una meta mensual y debe de indicarse la diferencia de la meta con lo obtenido</li>
  <ul>
    <li>La meta debera indicar cual es su estado en el mes actual</li>
    <li>La meta se debe guardar como historico, podiendo consultar su alcance en el futuro</li>
  </ul>
</ul>


## DEUDAS y AHORROS
Seccion del sistema que albergara gastos que aun no son realizados (ahorros) o ya realizados pero no costeados (deudas)

### Tabla
<ul>
  <li>Clasificacion</li>
  <li>Monto</li>
  <li>Concepto</li>
  <li>Fecha</li>
</ul>

### Consideraciones
<ul>
  <li>La clasificacion sera Ahorro o Deuda</li>
  <li>Los ahorros deben poderse modificar desde gastos</li>
  <li>Los ahorros y deudas deben de mostrar solo los actuales activos</li>
  <li>Se podran consultar los ahorros y deudas historicos, con un task desmarcado por defecto</li>
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

