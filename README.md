# Solar System

## Stack utilizado

* Java 11
* Spring Boot 2.0
* Spring Data JPA
* JUnit
* Maven
* MySQL

## Diagrama de clases

Debajo se puede ver el diagrama de clases del package <strong>core</strong> que contiene las clases que resuelven el desafío principal.
Para simplificar su lectura, el modelo solo contiene los métodos públicos y protegidos.

<a href='https://postimg.cc/XZbKxPK1' target='_blank'><img src='https://i.postimg.cc/fb3HWnVs/Solar-system-class-diagram.png' border='0' alt='Solar-system-class-diagram'/></a>

## API Weather

La solución se encuentra deployada en Google Cloud Platform.

* Endpoint para reporte:

<a href='https://meli-weather-316918.rj.r.appspot.com/api/v1/weather/report?years=10'>https://meli-weather-316918.rj.r.appspot.com/api/v1/weather/report?years=10</a>

Ejemplo de respuesta JSON:

```
{
  "year": 10,
  "reportDescription": "Weather's periods for next 10 years",
  "droughtPeriods": 0,
  "rainPeriods": 1127,
  "optimalPressureAndTemperaturePeriods": 0,
  "topRainyDays": [72,108,252,288,432,468,612,648,792,828,972,1008,1152,1188,1332,1368,1512,1548,1692,1728,1872,1908,2052,2088,2232,2268,2412,2448]
}
```

* Endpoint para condición climática del día:

<a href='https://meli-weather-316918.rj.r.appspot.com/api/v1/weather?day=80'>https://meli-weather-316918.rj.r.appspot.com/api/v1/weather?day=80</a></br>

Ejemplo de respuesta JSON:

```
{
    "day": 80,
    "weather": "RAINY"
}
```

## Sobre la resolución del desafío

1. Para conocer si los planetas y el sol están alineados obtengo la posición en la órbita de cada planeta y evaluo si están a una distancia de 180º o 360º
2. Para calcular las distancias entre 2 planetas utilizo el teorema del coseno. Para esto previamente calculo el ángulo que existe entre ellos.
3. Para conocer si el sol se encuentra dentro del perímetro que forman los triangulos, calculo el área que forman los planetas y la comparo contra las áreas que forman cada combinación de dos planetas distintos y el sol.
4. El cálculo del área de un triángulo se realiza con la Fórmula de Herón.
5. Para saber si sólo los planetas están alineados (sin el sol) sumo las distancias intermedias entre los planetas y la comparo contra la distancia entre el primer y último planeta.
6. La condición climática para cada día se calcula al momento que la aplicación inicia solo si el parámetro **weather.data.init** del archivo **application.yml** está configurado en **true**. En este momento también se calcula el perímetro que forman los planetas almacenándolo en la base de datos. Esto permitirá consultar directamente a la base cuál es el máximo perímetro y para que días.
7. Si la condición climática no es DROUGHT, RAINY o OPTIMAL_PRESURE_AND_TEMPERATURE entonces se considera que está soleado (SUNNY).


## Consideraciones para el reporte climático

1. El término período se refiere a días consecutivos con el mismo clima.
2. Un año cuenta con 365 días.

