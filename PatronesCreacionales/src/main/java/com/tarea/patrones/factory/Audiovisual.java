package com.tarea.patrones.factory;

public class Audiovisual implements Recurso {
    private String titulo;

    public Audiovisual(String titulo, int duracion) {
        this.titulo = titulo;
    }

    @Override
    public void prestar() {
        System.out.println("Material audiovisual prestado: " + titulo + " (3 días máximo)");
    }

    @Override
    public void devolver() {
        System.out.println("Material audiovisual devuelto: " + titulo);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}