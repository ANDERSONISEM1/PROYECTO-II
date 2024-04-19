package proyecto_ii;


// Clase que representa un nodo en la matriz ortogonal
class Nodo {
    // Atributos del nodo
    String placa;
    String color;
    String linea;
    String modelo;
    String propietario;
    // Referencias a nodos adyacentes
    Nodo arriba;
    Nodo abajo;
    Nodo izquierda;
    Nodo derecha;

    // Constructor de la clase Nodo
    public Nodo(String placa, String color, String linea, String modelo, String propietario) {
        // Inicialización de atributos
        this.placa = placa;
        this.color = color;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
        // Inicialización de referencias a nodos adyacentes
        this.arriba = null;
        this.abajo = null;
        this.izquierda = null;
        this.derecha = null;
    }
}













