# Generador y Buscador de Tablas Rainbow

Este proyecto contiene dos componentes principales: un Generador de Tablas Rainbow y un Buscador de Tablas Rainbow. El generador crea una tabla rainbow a partir de una lista de contraseñas, y el buscador te permite buscar hashes en la tabla rainbow generada.

## Componentes

### Generador de Tablas Rainbow

La clase `RainbowTableGenerator` lee una lista de contraseñas desde un archivo, genera sus hashes usando SHA-256 y escribe los pares hash-contraseña en un archivo de tabla rainbow.

#### Uso

1. Coloca tu lista de contraseñas en `src/RainbowExercise/passwords.txt`.
2. Ejecuta la clase `RainbowTableGenerator` para generar la tabla rainbow en `src/RainbowExercise/rainbowTable.txt`.

### Buscador de Tablas Rainbow

La clase `RainbowTableSearcher` carga la tabla rainbow y te permite buscar hashes para encontrar las contraseñas correspondientes.

#### Uso

1. Asegúrate de que el archivo de tabla rainbow `src/RainbowExercise/rainbowTable.txt` esté generado.
2. Ejecuta la clase `RainbowTableSearcher` e ingresa el hash que deseas buscar.

### Ejemplo de Cifrado Simétrico

La clase `CifradoSimetricoEjemplo` demuestra el cifrado simétrico usando AES. Solicita al usuario una contraseña y el texto a cifrar, luego muestra el texto cifrado y descifrado.

#### Uso

1. Ejecuta la clase `CifradoSimetricoEjemplo`.
2. Ingresa la contraseña y el texto a cifrar cuando se te solicite.

## Archivos

- `src/RainbowExercise/RainbowTableGenerator.java`: Genera la tabla rainbow.
- `src/RainbowExercise/RainbowTableSearcher.java`: Busca en la tabla rainbow.
- `src/CifradoSimetricoExercise/CifradoSimetricoEjemplo.java`: Demuestra el cifrado simétrico.

## Requisitos

- Java Development Kit (JDK) 8 o superior.

## Cómo Ejecutar

1. Compila los archivos Java:
   ```sh
   javac src/RainbowExercise/*.java src/CifradoSimetricoExercise/*.java
