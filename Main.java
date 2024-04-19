package proyecto_ii;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MatrizOrtogonal matriz = new MatrizOrtogonal();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMENU");
            System.out.println("1. Insertar vehículo");
            System.out.println("2. Buscar vehículo");
            System.out.println("3. Eliminar vehículo");
            System.out.println("4. Mostrar Vehiculos");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opción:");

            try {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        insertarVehiculo(matriz, scanner);
                        break;
                    case 2:
                        buscarVehiculo(matriz, scanner);
                        break;
                    case 3:
                        eliminarVehiculo(matriz, scanner);
                        break;
                    case 4:
                        matriz.mostrarVehiculos();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Criterio no válido. No existe en el menú.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }

        scanner.close();
    }
  // Método para insertar un vehículo en la matriz ortogonal
private static void insertarVehiculo(MatrizOrtogonal matriz, Scanner scanner) {
    System.out.println("\nINGRESE LOS DATOS DEL VEHICULO");
    System.out.println("Ingrese la placa del vehículo:");
    String placa = scanner.next();
    scanner.nextLine(); // Consumir el salto de línea

    System.out.println("Ingrese el color del vehículo:");
    String color = scanner.nextLine(); // Leer toda la línea, incluidos los espacios en blanco

    System.out.println("Ingrese la línea del vehículo:");
    String linea = scanner.nextLine(); // Leer toda la línea, incluidos los espacios en blanco

    System.out.println("Ingrese el modelo del vehículo:");
    String modelo = scanner.nextLine(); // Leer toda la línea, incluidos los espacios en blanco

    System.out.println("Ingrese el propietario del vehículo:");
    String propietario = scanner.nextLine(); // Leer toda la línea, incluidos los espacios en blanco

    matriz.insertar(placa, color, linea, modelo, propietario); // Insertar el vehículo en la matriz

    System.out.println("\nVehículo ingresado correctamente.");
}

// Método para buscar un vehículo en la matriz ortogonal
private static void buscarVehiculo(MatrizOrtogonal matriz, Scanner scanner) {
    boolean nuevaBusqueda = true; // Variable para controlar si se debe realizar una nueva búsqueda
    while (nuevaBusqueda) {
        System.out.println("\nBUSQUEDA");
        System.out.println("Escriba el criterio de búsqueda (placa, color, linea, modelo, propietario):");
        String criterioBusqueda = scanner.next().toLowerCase(); // Convertir a minúsculas
        scanner.nextLine(); // Consumir el salto de línea

        // Verificar si el criterio de búsqueda es válido
        if (!criterioBusqueda.equals("placa") && !criterioBusqueda.equals("color") && !criterioBusqueda.equals("linea")
                && !criterioBusqueda.equals("modelo") && !criterioBusqueda.equals("propietario")) {
            System.out.println("Criterio de búsqueda no válido.");
            System.out.println("¿Desea hacer una nueva búsqueda? (s/n)");
            String respuesta = scanner.next().toLowerCase(); // Convertir a minúsculas
            if (!respuesta.equals("s")) {
                nuevaBusqueda = false; // Salir del bucle si la respuesta no es 's'
            }
            continue; // Saltar al inicio del bucle
        }

        System.out.println("Ingrese " + criterioBusqueda + " a buscar:");
        String valorBusqueda = scanner.nextLine().toLowerCase(); // Convertir a minúsculas

        Nodo encontrado = matriz.buscar(valorBusqueda, criterioBusqueda); // Buscar el vehículo en la matriz
        if (encontrado != null) {
            System.out.println("Vehículo encontrado - Placa: " + encontrado.placa + ", Propietario: " + encontrado.propietario);
        } else {
            System.out.println("Vehículo no encontrado.");
        }

        System.out.println("¿Desea hacer una nueva búsqueda? (s/n)");
        String respuesta = scanner.next().toLowerCase(); // Convertir a minúsculas
        if (!respuesta.equals("s")) {
            nuevaBusqueda = false; // Salir del bucle si la respuesta no es 's'
        }
    }
}





// Método para eliminar un vehículo de la matriz ortogonal
private static void eliminarVehiculo(MatrizOrtogonal matriz, Scanner scanner) {
    System.out.println("\nELIMINAR VEHICULO");
    System.out.println("Escriba el criterio de eliminación (placa, color, linea, modelo, propietario):");
    String criterioEliminar = scanner.next().toLowerCase(); // Convertir a minúsculas
    scanner.nextLine(); // Consumir el salto de línea
    System.out.println("Ingrese " + criterioEliminar + " del vehículo a eliminar:");
    String valorEliminar = scanner.nextLine().toLowerCase().trim(); // Convertir a minúsculas y eliminar espacios en blanco al inicio y al final

    // Validar que el valor ingresado no sea vacío
    if (valorEliminar.isEmpty()) {
        System.out.println("El valor ingresado no puede estar vacío. Por favor, inténtelo de nuevo.");
        return; // Salir del método si el valor está vacío
    }

    // Buscar el vehículo antes de eliminarlo
    Nodo encontradoAntes = matriz.buscar(valorEliminar, criterioEliminar);

    matriz.eliminar(valorEliminar, criterioEliminar); // Eliminar el vehículo de la matriz

    // Buscar el vehículo después de eliminarlo
    Nodo encontradoDespues = matriz.buscar(valorEliminar, criterioEliminar);

    if (encontradoAntes != null && encontradoDespues == null) {
        System.out.println("Vehículo eliminado correctamente.");
    } else {
        System.out.println("No se pudo eliminar el vehículo.");
    }
}


}







