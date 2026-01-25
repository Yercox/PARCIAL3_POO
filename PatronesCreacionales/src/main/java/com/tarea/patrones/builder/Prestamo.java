package com.tarea.patrones.builder;


import com.tarea.patrones.singleton.ConfiguracionBiblioteca;

public class Prestamo {
    String usuario;
    String recurso;
    int duracionDias;
    boolean renovacionAutomatica;
    boolean notificacionesEmail;
    boolean notificacionesSMS;
    String observaciones;

    public void mostrarDetalles() {
        ConfiguracionBiblioteca config = ConfiguracionBiblioteca.getInstance();
        System.out.println("Biblioteca: " + config.getNombreBiblioteca());
        System.out.println("Detalles del préstamo:");
        System.out.println("  Usuario: " + usuario);
        System.out.println("  Recurso: " + recurso);
        System.out.println("  Duración: " + duracionDias + " días");
        System.out.println("  Renovación automática: " + (renovacionAutomatica ? "Sí" : "No"));
        System.out.println("  Notificaciones email: " + (notificacionesEmail ? "Sí" : "No"));
        System.out.println("  Notificaciones SMS: " + (notificacionesSMS ? "Sí" : "No"));
        if (observaciones != null) {
            System.out.println("  Observaciones: " + observaciones);
        }
    }
}