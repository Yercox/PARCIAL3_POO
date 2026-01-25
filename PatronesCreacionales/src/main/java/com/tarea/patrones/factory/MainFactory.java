package com.tarea.patrones.factory;

import java.util.Scanner;

public class MainFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== DEMO INTERACTIVA FACTORY METHOD ===\n");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Nuevo Recurso ---");
            System.out.println("Tipos disponibles:");
            System.out.println("1. libro");
            System.out.println("2. revista");
            System.out.println("3. audiovisual");

            System.out.print("\nSelecciona tipo (nombre o número): ");
            String tipo = scanner.nextLine().toLowerCase();

            switch (tipo) {
                case "1": tipo = "libro"; break;
                case "2": tipo = "revista"; break;
                case "3": tipo = "audiovisual"; break;
            }

            System.out.print("Título del recurso: ");
            String titulo = scanner.nextLine();

            try {
                Recurso recurso = RecursoFactory.crearRecurso(tipo, titulo);

                System.out.println("\nAcciones disponibles:");
                System.out.println("1. Prestar");
                System.out.println("2. Devolver");
                System.out.println("3. Mostrar información");
                System.out.print("Selecciona acción (1-3): ");
                String accion = scanner.nextLine();

                switch (accion) {
                    case "1":
                        recurso.prestar();
                        break;
                    case "2":
                        recurso.devolver();
                        break;
                    case "3":
                        System.out.println("Recurso: " + recurso.getTitulo());
                        System.out.println("Tipo: " + recurso.getClass().getSimpleName());
                        break;
                    default:
                        System.out.println("Acción no válida");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("\n¿Crear otro recurso? (si/no): ");
            continuar = scanner.nextLine().equalsIgnoreCase("si");
        }

        System.out.println("\n¡Gracias por usar el sistema!");
        scanner.close();
    }
}