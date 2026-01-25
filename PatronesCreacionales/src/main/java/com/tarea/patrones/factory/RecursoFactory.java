package com.tarea.patrones.factory;
import java.util.Scanner;

public class RecursoFactory {

    public static Recurso crearRecurso(String tipo, String titulo) {
        switch (tipo.toLowerCase()) {
            case "libro":
                System.out.print("Ingresa autor del libro: ");
                Scanner scanner = new Scanner(System.in);
                String autor = scanner.nextLine();
                return new Libro(titulo, autor);

            case "revista":
                System.out.print("Ingresa número de edición: ");
                scanner = new Scanner(System.in);
                String edicion = scanner.nextLine();
                return new Revista(titulo, edicion);

            case "audiovisual":
                System.out.print("Ingresa duración (minutos): ");
                scanner = new Scanner(System.in);
                int duracion = scanner.nextInt();
                return new Audiovisual(titulo, duracion);

            default:
                throw new IllegalArgumentException("Tipo de recurso no válido: " + tipo);
        }
    }
}