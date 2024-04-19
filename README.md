# Manual de Usuario

## Introducción
El proyecto **proyecto_II** es un sistema de gestión de vehículos que utiliza una matriz ortogonal para almacenar la información de los vehículos. 
Este manual proporciona las instrucciones para utilizar las funciones principales del sistema.
## Requisitos del Sistema
- Java Development Kit (JDK).
## Instalación
1. Clonar o descargar el proyecto desde el repositorio.
2. Importar el proyecto en el entorno de desarrollo Java.
3. Compilar y ejecutar el proyecto.
## Uso Básico
1. **Insertar un vehículo:**
   - Selecciona la opción "Insertar vehículo" en el menú.
   - Ingresa los datos del vehículo cuando se soliciten (placa, color, línea, modelo, propietario).
2. **Buscar un vehículo:**
   - Selecciona la opción "Buscar vehículo" en el menú.
   - Selecciona el criterio de búsqueda ingresando la palabra (placa, color, línea, modelo, propietario).
   - Ingresa el valor a buscar.
3. **Eliminar un vehículo:**
   - Selecciona la opción "Eliminar vehículo" en el menú.
   - Selecciona el criterio de eliminación ingresando la palabra (placa, color, línea, modelo, propietario).
   - Ingresa el valor del vehículo a eliminar.
4. **Mostrar vehículos:**
   - Selecciona la opción "Mostrar Vehículos" en el menú.
   - Se mostrará una lista con todos los vehículos ingresados en la matriz ortogonal.
5. **Salir:**
   - Selecciona la opción "Salir" en el menú para cerrar la aplicación.
## Notas Adicionales
- La aplicación distingue entre mayúsculas y minúsculas en los criterios de búsqueda.
- Al eliminar un vehículo, se eliminará la primera coincidencia encontrada.


# Manual Técnico

## Estructura del Proyecto
- **proyecto_ii:** Paquete principal que contiene la clase `Main`.
- **Nodo:** Clase que representa un nodo en la matriz ortogonal.
- **MatrizOrtogonal:** Clase que representa la matriz ortogonal y contiene los métodos para insertar, buscar y eliminar vehículos.

## Flujo de la Aplicación
1. La clase `Main` controla el flujo principal de la aplicación, mostrando un menú de opciones y llamando a los métodos correspondientes de la clase `MatrizOrtogonal`.
2. La clase `MatrizOrtogonal` contiene la lógica para manipular la matriz y realizar las operaciones de inserción, búsqueda y eliminación de vehículos.
3. Cada vehículo se representa como un nodo en la matriz, con referencias a los nodos adyacentes (arriba, abajo, izquierda, derecha).

