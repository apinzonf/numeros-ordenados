# numeros-ordenados

Esta es una aplicación para participar en el Programming Challenge PSL

##Números “ordenados”

Cierto matemático se ha interesado en lo que él ha denominado números “ordenados”

Un número “ordenado” es un entero en base 10, sin cero a la izquierda, tiene todos sus dígitos ordenados en orden no-descendente. Ejemplos: 9, 234, 888, 1578  y 113399. Algunos números que no cumplen esta propiedad: 30, 432, 596 and 88881.

Se requiere un algoritmo que, dado un número N, encuentre el mayor número “Ordenado” presente.

### Ejemplo: 

N=20, Último número “ordenado”: 19.

N=132, Último número “ordenado”: 129.

N=1000, Último número “ordenado”: 999.

N=8, Último número “ordenado”: 8.

N=11111110, Último número “ordenado”: 9999999.

## Límites:

1 ≤ N ≤ 1018

## Entrada.

Archivo de texto plano entrada.txt. La primera línea contendrá el número de casos de prueba, luego cada línea será un valor de N.

## Salida esperada:

En un archivo llamado salida.txt, por cada línea el mayor número “ordenado” encontrado.

## Ejemplo: 

entrada.txt

3

20

132

1000

salida.txt

Caso 1: N=20, O=19

Caso 2: N=132, O=129

Caso 3: N=1000, O=999

## Restricciones técnicas.

La solución puede ser remitida en Python, Java, .Net,  node.js, C++

## Criterios de evaluación:

1. La solución debe incluir un comentario indicando el Orden. Ejemplo: Log(N), N, N2

2. Mejor desempeño: solución que se ejecute más rápido. (Todas serán ejecutadas en el mismo Hardware, puede o no tener múltiples procesadores)

3. Desempate: Si dos soluciones se ejecutan el mismo tiempo en minutos, quien haya entregado primero.

4. La solución deberá ser legible, siguiendo las prácticas recomendadas en Clean Code. https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882 

## Clonar el proyecto 

$ git clone https://github.com/apinzonf/numeros-ordenados.git

## Compilar el proyecto

Ubicarse dentro de la carpeta numeros-ordenados

$ mvn clean compile package


## Ejecutar la aplicación

Ubicarse dentro de la carpeta numeros-ordenados

Ejemplo:

$java -jar target/numeros-ordenados-0.0.1-jar-with-dependencies.jar resources/entrada.txt resources/salida.txt

En el ejemplo anterior el archivo entrada.txt esta en la carpeta resources, y el de salida se pondra en el mismo lugar

## Medir el tiempo de ejecución

Yo use el comando time de Windows para medir el tiempo de ejecucion

Ejemplo: 

$ time java -jar target/numeros-ordenados-0.0.1-jar-with-dependencies.jar resources/entrada-large.txt resources/salida-large.txt

real    0m1.067s

user    0m0.000s

sys     0m0.016s



## Análisis de complejidad 
El método obtenerNumeroOrdenadoMenorQue dentro de la clase NumeroOrdenado contiene un ciclo que verifica digito x digito si el siguiente desde la posición 0 es mayor o igual, de forma que para cuando encuentra un digito menor.

En el mejor caso el algoritmo se detendrá en la primera comparación siendo el número en la posición 1 menor que en la posición 0 de izquierda a derecha.

Mejor caso O(1)

En el caso promedio el algoritmo realizara 1 o 2 o 3 o n-1 comparaciones hasta que llegue al final.

Caso promedio O(n/2)

En el peor caso realizara n-1 comparaciones que corresponde al caso cuando el número de entrada es un número ordenados

Peor Caso O(n)

El método cambiarDigitosPorMaximoPosible realiza copia con base en arreglos y usando estructuras fijas que le permiten tener una complejidad constante que es despreciable junto a O(n/2) o  O(n).

En conclusión la complejidad de este algoritmo es 

Mejor caso O(1)

Caso promedio O(n/2)

Peor Caso O(n)
