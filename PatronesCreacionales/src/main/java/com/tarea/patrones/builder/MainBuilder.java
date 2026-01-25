package com.tarea.patrones.builder;
import java.util.Scanner;

public class MainBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CONSTRUCTOR INTERACTIVO DE PRÉSTAMOS ===\n");

        System.out.println("Vamos a crear un préstamo paso a paso:");

        System.out.print("\n1. Nombre completo del usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("2. Código del recurso (ISBN/ISSN/Código): ");
        String recurso = scanner.nextLine();

        System.out.print("3. Duración en días (7-30): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n4. Opciones adicionales:");

        System.out.print("   ¿Renovación automática? (si/no): ");
        boolean renovacion = scanner.nextLine().equalsIgnoreCase("si");

        System.out.print("   ¿Notificaciones por email? (si/no): ");
        boolean email = scanner.nextLine().equalsIgnoreCase("si");

        System.out.print("   ¿Notificaciones por SMS? (si/no): ");
        boolean sms = scanner.nextLine().equalsIgnoreCase("si");

        System.out.print("5. Observaciones (opcional): ");
        String observaciones = scanner.nextLine();
        PrestamoBuilder builder = new PrestamoBuilder()
                .usuario(usuario)
                .recurso(recurso)
                .duracion(duracion);

        if (renovacion) builder.renovacionAutomatica();
        if (email) builder.notificacionesEmail();
        if (sms) builder.notificacionesSMS();
        if (!observaciones.isEmpty()) builder.observaciones(observaciones);

        try {
            Prestamo prestamo = builder.build();

            System.out.println("\n" + "=".repeat(40));
            System.out.println("PRÉSTAMO CREADO EXITOSAMENTE");
            System.out.println("=".repeat(40));
            prestamo.mostrarDetalles();

            System.out.println("\nProcesando préstamo...");
            Thread.sleep(1000);
            System.out.println("Registrado en base de datos");
            Thread.sleep(800);
            System.out.println("Notificaciones configuradas");
            Thread.sleep(600);
            System.out.println("Préstamo listo para entrega");

        } catch (Exception e) {
            System.out.println("Error al crear préstamo: " + e.getMessage());
        }

        scanner.close();
    }
}