package com.tarea.patrones;
import com.tarea.patrones.singleton.ConfiguracionBiblioteca;
import com.tarea.patrones.factory.*;
import com.tarea.patrones.builder.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                System.out.println("=== SISTEMA DE BIBLIOTECA ===\n");

        System.out.println("1. SINGLETON - Configurar Biblioteca");
        ConfiguracionBiblioteca config = ConfiguracionBiblioteca.getInstance();

        System.out.print("Ingresa nombre de la biblioteca: ");
        String nombre = scanner.nextLine();
        config.setNombreBiblioteca(nombre);

        System.out.print("Ingresa máximo de usuarios: ");
        int maxUsuarios = scanner.nextInt();
        config.setMaxUsuarios(maxUsuarios);
        scanner.nextLine();

        System.out.print("¿Está en mantenimiento? (si/no): ");
        String mantenimiento = scanner.nextLine();
        config.setMantenimiento(mantenimiento.equalsIgnoreCase("si"));

        System.out.println("\nConfiguración guardada:");
        config.mostrarConfiguracion();

        System.out.println("\n" + "=".repeat(50));

        System.out.println("2. PATRÓN FACTORY - Creación de Recursos");
        System.out.println("=".repeat(50));

        System.out.println("Tipos disponibles: libro, revista, audiovisual");
        System.out.print("Ingresa tipo de recurso: ");
        String tipo = scanner.nextLine();

        System.out.print("Ingresa título del recurso: ");
        String titulo = scanner.nextLine();

        try {
            Recurso recurso = RecursoFactory.crearRecurso(tipo, titulo);
            recurso.prestar();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("3. PATRÓN BUILDER - Préstamo Personalizado");
        System.out.println("=".repeat(50));

        System.out.print("Nombre del usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Código del recurso (ISBN o código): ");
        String codigoRecurso = scanner.nextLine();

        System.out.print("Duración del préstamo (días): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Renovación automática? (si/no): ");
        boolean renovacion = scanner.nextLine().equalsIgnoreCase("si");

        System.out.print("¿Notificaciones por email? (si/no): ");
        boolean email = scanner.nextLine().equalsIgnoreCase("si");

        System.out.print("Observaciones (opcional): ");
        String observaciones = scanner.nextLine();

        PrestamoBuilder builder = new PrestamoBuilder()
                .usuario(usuario)
                .recurso(codigoRecurso)
                .duracion(duracion);

        if (renovacion) builder.renovacionAutomatica();
        if (email) builder.notificacionesEmail();
        if (!observaciones.isEmpty()) builder.observaciones(observaciones);

        Prestamo prestamo = builder.build();

        System.out.println("\n" + "".repeat(50));
        System.out.println("PRÉSTAMO CREADO EXITOSAMENTE");
        System.out.println("★".repeat(50));
        prestamo.mostrarDetalles();


        scanner.close();
    }
}