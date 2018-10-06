# Estructura-de-Datos-y-Algoritmos-2
Examen parcial para la materia de Estructura de Datos y Algoritmos 2

**Mark Octavio Rivera Acosta**
**Enrique Anaya Bovio**

### Ejercicio 1 -¿Más grande implica más inteligente?-

**Enunciado:** Algunas personas creen que mientras ma ́s grande sea un elefante, ma ́s inteligente es. Para refu- tar esto, usted quiere tomar los datos en una coleccio ́n de elefantes y organizar un subconjunto de estos datos, tan grande como sea posible, en una secuencia donde el taman ̃o sea creciente, pero el CI (Coeficiente Intelectual) sea decreciente.

**Entrada:** La entrada consiste en los datos de una colección de elefantes, un elefante por línea, terminado por el fin-de-archivo. Los datos para un elefante particular consistirán en un par de enteros: el primero representa su tamaño en kilogramos y el segundo representa su CI en centécimas de punto de CI. Ambos enteros están entre 0 y 10000. Los datos contendrán información de a lo sumo 1000 elefantes. Dos elefantes pueden tener el mismo peso, el mismo CI o el mismo peso y el mismo CI.

**Salida:** Digamos que los números en la i-ésima línea de datos son W[i] y S[i]. Su programa debe producir una secuencia de líneas de datos; la primera línea debe contener un número n; las siguientes n líneas debe contener cada una un sólo entero positivo (cada uno representando a un elefante). Si esos enteros son a[1], a[2], · · · , a[n], entonces debe cumplirse que W [a[1]] < W[a[2]] < ··· < W[a[n]] y S[a[1]] > S[a[2]] > ··· > S[a[n]]
Para que la respuesta sea correcta, n debe ser lo más grande posible. Todas las desigualdades son estrictas; los pesos deben ser estrictamente crecientes y los CI deben ser estrictamente decrecientes.
Pueden haber múltiples soluciones correctas pasa cada entrada, su programa sólo necesita encontrar una.

**Breakdown:** Lo primero que nos dimos cuenta al analizar el problema es que esre problema implicaba revisar una serie de objetos y realizar múltiples comparaciones. En primera instancia se planteó realizar comparaciones para cada elefante con todos los demás elefantes, obteniendo así la **n** posible de obtener para este elefante, al final sólo se escogería el más grande. Sin embargo, para esto hay que comparar cada elefante con los demás (máximo 1000) e ir guardando el resultado de usar este y así para todos. Con esto sólo se lograría una tarea muy pesada en tiempo y espacio al tardarse por las múltiples miles de operaciones y lo múltiples miles de arreglos donde se guardaría la información.

Para solucionar esto se llegó a la conclusión de que se debía resolver utilizando un algoritmo de programación dinámica.

La solución encontrada es algo simple:

1. Se reciben los datos de los elefantes mediante un reader con las especificaciones que se pidieron y se crea un objeto con cada dato.
2. Se guardan todos los elefantes en un array.
3. Este array se ordena en el orden de peso del elefante, debido a que en el enunciado dice que por más grande más inteligente.
4. Creamos un array donde vamos a guardar todo lo que se haya analizado (aquí está la parte de programación dinámica). En este array guardaremos el número máximo de elefantes que conformarán la secuencia resultante de la siguiente manera:
    1. Establecemos el valor de 1 como caso base (un elefante, un resultado).
    2. El arreglo lo tendremos que recorrer n^2 veces debido a que se debe comparar un elefante actual con los ya evaluados.
    3. Para cada elefante actual a evaluar se compara con los ya evaluados de la siguiente forma: Si el iq del elefante ya evaluado es menor que el actual y el peso del ya evaluado es mayor que el actual, para el elefante actual incrementa en 1 su cantidad máxima de elefantes posibles en la secuencia y se guarda este valor en el array.
5. Al Final se escoge el valor máximo guardado en este array indicando la cantidad máxima de elefantes.
6. Ahora para imprimir los elefantes elegidos se realiza lo siguiente:
    1. Se crea un array del mismo tamaño que el máximo valor de elefantes obtenido anteriormente.
    2. Se recorre el array donde se guardaron las cantidad máximas de elefantes para cada elefante, y si en la posición i se encuentra el valor máximo ya establecido (se repite el valor máximo porque los elefantes comparten sus cantidades máximas) se recupera este y se dice que él es un elefante. 
    3. Basado en el IQ se van ordenando
7. Se imprimen los elefantes.

### Ejercicio 2 -Pesos y Medidas-

**Enunciado:** Una tortuga llamada Mack, para evitar ser aplastada, ha solicitado su consejo para definir el orden en que se deben apilar las tortugas para formar el trono de tortugas de Yertle. Cada una de las 5,607 tortugas ordenadas por Yertle tiene un peso y una fuerza diferentes. Su tarea es construir el mayor monto ́n de tortugas posible.

**Entrada:** La entrada esta ́ndar consta de varias l ́ıneas, cada una de las cuales contiene un par de enteros separados por uno o ma ́s espacios, que especifican el peso y la fuerza de una tortuga. El peso de la tortuga es en gramos. La fuerza, tambie ́n en gramos, es la capacidad de carga total de la tortuga, incluido su propio peso. Es decir, una tortuga que pesa 300 g con una fuerza de 1,000 g puede cargar 700 g de tortugas en su espalda. Hay como ma ́ximo 5,607 tortugas.

**Salida:** La salida es un so ́lo nu ́mero entero que indica el nu ́mero ma ́ximo de tortugas que se pueden apilar sin exceder la fuerza de ninguna.

**Breakdown:** Lo primero que nos dimos cuenta al analizar el problema es que esre problema implicaba revisar una serie de objetos y realizar múltiples comparaciones. En primera instancia se planteó realizar comparaciones para cada tortuga con todos los demás elefantes, obteniendo así la **n** posible para esta tortuga, al final sólo se escogería la n más grande. Sin embargo, para esto hay que comparar cada tortuga con los demás (máximo 5607) e ir guardando el resultado de usar este y así para todos. Con esto sólo se lograría una tarea muy pesada en tiempo y espacio al tardarse por las múltiples miles de operaciones y lo múltiples miles de arreglos donde se guardaría la información. Es muy similar al ejercicio anterior.

Para solucionar esto se llegó a la conclusión de que se debía resolver utilizando un algoritmo de programación dinámica.

La solución encontrada es algo simple:

1. Se reciben los datos de los elefantes mediante un reader con las especificaciones que se pidieron y se crea un objeto con cada dato.
2. Se guardan las tortugas en un array.
3. Se ordenan las tortugas basado en su fuerza.
4. Se crea otro array donde se guardarán las tortugas que se pueden apilar dependiendo de cada tortuga con la que se trabaje.
5. Este también implica una evaluación de orden O(n^2) ya que se debe comparar cada tortuga con las ya evaluadas anteriormente.
6. Se empieza comparando la tortuga más fuerte con la menos fuerte y si la primera puede cargar a la segunda se le agrega en el array de soluciones una suma de 1 indicando que incrementa la cantidad de tortugas que se pueden cargar con esta que se eligió.
7. Se guardan todos los valores en el array y se escoje el más grande de este indicando que es la mayor cantidad de tortugas que se pueden acomodar.