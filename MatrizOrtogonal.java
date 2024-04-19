package proyecto_ii;
// Clase que representa una matriz ortogonal de nodos
class MatrizOrtogonal {
    Nodo inicio; // Nodo inicial de la matriz

    // Constructor de la clase MatrizOrtogonal
    public MatrizOrtogonal() {
        this.inicio = null; // Inicialmente la matriz está vacía
    }

    // Método para insertar un nuevo nodo en la matriz
    public void insertar(String placa, String color, String linea, String modelo, String propietario) {
        Nodo nuevo = new Nodo(placa, color, linea, modelo, propietario); // Crear un nuevo nodo
        if (inicio == null) {
            inicio = nuevo; // Si la matriz está vacía, el nuevo nodo es el inicio
        } else {
            Nodo actual = inicio;
            // Recorrer hasta el final de la fila
            while (actual.derecha != null) {
                actual = actual.derecha;
            }
            // Insertar el nuevo nodo al final de la fila
            actual.derecha = nuevo;
            nuevo.izquierda = actual;
            nuevo.abajo = actual.abajo;
            if (actual.abajo != null) {
                actual.abajo.arriba = nuevo;
            }
        }
    }

// Método para buscar un nodo en la matriz
public Nodo buscar(String criterio, String tipo) {
    Nodo actual = inicio;
    // Recorrer la matriz
    while (actual != null) {
        switch (tipo.toLowerCase()) { // Convertir a minúsculas
            case "placa":
                if (actual.placa.toLowerCase().contains(criterio.toLowerCase())) { // Buscar coincidencia parcial
                    return actual;
                }
                break;
            case "color":
                if (actual.color.toLowerCase().contains(criterio.toLowerCase())) { // Buscar coincidencia parcial
                    return actual;
                }
                break;
            case "linea":
                if (actual.linea.toLowerCase().contains(criterio.toLowerCase())) { // Buscar coincidencia parcial
                    return actual;
                }
                break;
            case "modelo":
                if (actual.modelo.toLowerCase().contains(criterio.toLowerCase())) { // Buscar coincidencia parcial
                    return actual;
                }
                break;
            case "propietario":
                if (actual.propietario.toLowerCase().contains(criterio.toLowerCase())) { // Buscar coincidencia parcial
                    return actual;
                }
                break;
            default:
                System.out.println("Criterio de búsqueda no válido.");
                break;
        }
        actual = actual.derecha;
        if (actual == null) {
            actual = inicio.abajo;
        }
    }
    return null; // Si no se encuentra el nodo, retornar null
}




 // Método para eliminar un nodo de la matriz
public void eliminar(String criterio, String tipo) {
    Nodo actual = buscar(criterio, tipo); // Buscar el nodo a eliminar

    if (actual != null) {
        // Actualizar las referencias de los nodos adyacentes al nodo a eliminar
        if (actual.izquierda != null) {
            actual.izquierda.derecha = actual.derecha;
        }
        if (actual.derecha != null) {
            actual.derecha.izquierda = actual.izquierda;
        }
        if (actual.arriba != null) {
            actual.arriba.abajo = actual.abajo;
        }
        if (actual.abajo != null) {
            actual.abajo.arriba = actual.arriba;
        }

        // Verificar si se está eliminando el nodo inicio
        if (inicio == actual) {
            inicio = actual.derecha != null ? actual.derecha : actual.abajo;
        }

        // Liberar referencias del nodo a eliminar
        actual.izquierda = null;
        actual.derecha = null;
        actual.arriba = null;
        actual.abajo = null;
    }
}



// Método para mostrar todos los vehículos ingresados en la matriz ortogonal
public void mostrarVehiculos() {
    Nodo actual = inicio;
    System.out.println("\nVEHICULOS INGRESADOS");
    // Recorrer la matriz y mostrar los vehículos
    while (actual != null) {
        System.out.println("Placa: " + actual.placa + ", Color: " + actual.color + ", Línea: " + actual.linea +
                ", Modelo: " + actual.modelo + ", Propietario: " + actual.propietario);
        actual = actual.derecha;
        if (actual == null) {
            actual = inicio.abajo;
        }
    }
}

}


