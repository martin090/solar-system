<h1> SOLAR SYSTEM </h1>

<h2> Stack utilizado </h2>

<ul>
  <li>Java 11</li>
  <li>Spring Boot 2.0</li>
  <li>Spring Data JPA</li>
  <li>Maven</li>
  <li>MySQL</li>
</ul>

<h2> Diagrama de clases </h2>
<p> Debajo se puede ver el diagrama de clases del package <strong>core</strong> que contiene las clases que resuelven el desafío principal. </p>
<p> Para simplificar su lectura, el modelo sólo contiene los métodos públicos y protegidos. </p>

<a href='https://postimg.cc/XZbKxPK1' target='_blank'><img src='https://i.postimg.cc/fb3HWnVs/Solar-system-class-diagram.png' border='0' alt='Solar-system-class-diagram'/></a>

<h2>API Weather</h2>

La solución se encuentra deployada en Google Cloud Platform.

<li>Endpoint para reporte: </li>

<li>Endpoint para condición climática del día: </li>

<h2>Sobre la resolución del desafío</h2>
<ol>
    <li>Para conocer si los planetas y el sol están alineados obtengo la posición en la orbita de cada planeta y evalué si están a una distancia de 180º o 360º </li>
    <li>Para calcular las distancias entre 2 planetas utilicé el teorema del coseno. Para esto previamente calculo el ángulo que existe entre ellos.</li>
    <li>Para conocer si el sol se encuentra dentro del perímetro que forman los triangulos, calculo el área que forman los planetas y la comparo contra las áreas que forman cada combinación de dos planetas distintos y el sol.</li>
    <li>El cálculo del área de un triángulo se realiza con la Fórmula de Herón.</li>
    <li>Para saber si sólo los planetas están alineados (sin el sol) sumo las distancias intermedias entre los planetas y la comparo contra la distancia entre el primer y último planeta </li>
  <li> La condición climática para cada día se calcula al momento que la aplicación inicia. En este momento también se calcula el perímetro que forman los planetas persistiendolo en la base de datos. Esto permitirá consultar directamente a la base cuál es el máximo perímetro y para que días. </li>
</ol>

<h2>Consideraciones para el reporte climático</h2>
<ol>
  <li> Un período son días consecutivos con el mismo clima. </li>
  <li> Se considera que un año tiene 365 días. </li>
</ol>
