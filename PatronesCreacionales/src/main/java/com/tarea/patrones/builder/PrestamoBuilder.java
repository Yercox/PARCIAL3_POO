package com.tarea.patrones.builder;

public class PrestamoBuilder {
    private Prestamo prestamo;

    public PrestamoBuilder() {
        prestamo = new Prestamo();
    }

    public PrestamoBuilder usuario(String usuario) {
        prestamo.usuario = usuario;
        return this;
    }

    public PrestamoBuilder recurso(String recurso) {
        prestamo.recurso = recurso;
        return this;
    }

    public PrestamoBuilder duracion(int dias) {
        prestamo.duracionDias = dias;
        return this;
    }

    public PrestamoBuilder renovacionAutomatica() {
        prestamo.renovacionAutomatica = true;
        return this;
    }

    public PrestamoBuilder notificacionesEmail() {
        prestamo.notificacionesEmail = true;
        return this;
    }

    public PrestamoBuilder notificacionesSMS() {
        prestamo.notificacionesSMS = true;
        return this;
    }

    public PrestamoBuilder observaciones(String obs) {
        prestamo.observaciones = obs;
        return this;
    }

    public Prestamo build() {

        if (prestamo.usuario == null || prestamo.usuario.isEmpty()) {
            throw new IllegalStateException("Usuario es requerido");
        }
        if (prestamo.recurso == null || prestamo.recurso.isEmpty()) {
            throw new IllegalStateException("Recurso es requerido");
        }
        if (prestamo.duracionDias <= 0) {
            prestamo.duracionDias = 7;
        }
        return prestamo;
    }
}