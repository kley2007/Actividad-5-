package com.example;

/**
 * Clase principal: demuestra herencia y polimorfismo.
 */
public class Main {

    public static void main(String[] args) {

        // Creamos objetos de las tres subclases.
        Computador computador = new Computador(
                "Lenovo", "ThinkPad E14", 3200000, 2023, 16, true
        );

        Smartphone smartphone = new Smartphone(
                "Samsung", "Galaxy S24", 2800000, 2024, 256, 88
        );

        Tablet tablet = new Tablet(
                "Apple", "iPad Air", 3100000, 2022, 10.9, true
        );

        // Arreglo de la clase padre que almacena objetos de distintas subclases.
        DispositivoTecnologico[] inventario = {
                computador,
                smartphone,
                tablet
        };

        System.out.println("===== SISTEMA DE GESTIÓN DE DISPOSITIVOS =====");

        // Polimorfismo: Java ejecuta la versión sobrescrita
        // de cada objeto según su tipo real.
        for (DispositivoTecnologico dispositivo : inventario) {
            System.out.println("\n" + dispositivo);
            System.out.printf("Costo estimado de mantenimiento: $%,.2f%n",
                    dispositivo.calcularCostoMantenimiento());
        }

        // Demostración de validación y manejo de excepciones.
        try {
            smartphone.setSaludBateria(150);
        } catch (IllegalArgumentException e) {
            System.out.println("\nValidación correcta: " + e.getMessage());
        }
    }
}
