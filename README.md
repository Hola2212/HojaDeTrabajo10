# Proyecto: Grafos y Algoritmo de Floyd

## Descripción

Este proyecto implementa un sistema para modelar y analizar un grafo dirigido que representa ciudades de Guatemala y las distancias entre ellas. El objetivo principal es calcular la ruta más corta entre cualquier par de ciudades utilizando el algoritmo de Floyd-Warshall, así como determinar el centro del grafo.

El proyecto incluye dos implementaciones:

- **Java**: implementación manual del grafo y del algoritmo de Floyd.
- **Python**: implementación equivalente utilizando la librería NetworkX.

---

## Estructura del Proyecto

```
HojaDeTrabajo10/
│
├── src/                    # Código Java
│   ├── Main.java
│   ├── Graph.java
│   ├── FileReaderUtil.java
│   ├── Token.java
│   └── resources/
│       └── guategrafo.txt
│
├── tests/                  # Pruebas JUnit
│   ├── GraphTest.java
│   └── FileReaderUtilTest.java
│
├── srcPython/              # Implementación en Python
│   ├── graph_floyd.py
│   └── main.py
│
├── docs/                   # Documentación
│   └── uml.png
│
└── README.md
```

---

## Formato del Archivo de Entrada

El archivo `guategrafo.txt` contiene las conexiones del grafo en el siguiente formato:

```
CiudadOrigen CiudadDestino Distancia
```

Ejemplo:

```
Guatemala Antigua 40
Antigua Escuintla 25
```

---

## Funcionalidades

- Cálculo de ruta más corta entre dos ciudades.
- Cálculo del centro del grafo.
- Agregar conexiones.
- Eliminar conexiones.
- Recalcular rutas dinámicamente.

---

## Implementación en Java

### Características

- Representación mediante matriz de adyacencia.
- Implementación manual del algoritmo de Floyd-Warshall.
- Manejo de rutas mediante matriz `next`.

### Ejecutar

1. Compilar:
```
javac src/*.java
```

2. Ejecutar:
```
java src.Main
```

---

## Implementación en Python

### Requisitos

Instalar NetworkX:
```
pip install networkx
```

### Características

- Uso de `networkx.DiGraph`.
- Uso de `floyd_warshall`.
- Código simplificado gracias a librerías.

### Ejecutar

```
cd srcPython
python main.py
```

---

## Pruebas Unitarias

Se implementaron pruebas usando JUnit para validar:

- Algoritmo de Floyd
- Rutas más cortas
- Eliminación de aristas
- Inserción de aristas

---

## Conclusiones

- La implementación en Java permite comprender el algoritmo en detalle.
- Python simplifica el desarrollo mediante librerías especializadas.
- La matriz de adyacencia es adecuada para Floyd.

---

## Autor
Juan Pablo Flores   -   25454  
Algoritmos y Estructuras de Datos.  
UVG
