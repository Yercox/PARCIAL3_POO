package com.tarea.patrones.factory;


public class Revista implements Recurso {
    private String titulo;

    public Revista(String titulo, String edicion) {
        this.titulo = titulo;
    }

    @Override
    public void prestar() {
        System.out.println("Revista prestada: " + titulo + " (7 días máximo)");
    }

    @Override
    public void devolver() {
        System.out.println("Revista devuelta: " + titulo);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}