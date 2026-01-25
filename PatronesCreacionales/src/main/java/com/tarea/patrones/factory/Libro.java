package com.tarea.patrones.factory;

public class Libro implements Recurso {
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = generarISBN();
    }

    private String generarISBN() {
        // Generar un ISBN ficticio
        return "978-" + (int)(Math.random() * 10000) + "-" +
                (int)(Math.random() * 10000) + "-" +
                (int)(Math.random() * 10);
    }

    @Override
    public void prestar() {
        System.out.println("Libro prestado: \"" + titulo + "\"");
        System.out.println("   Autor: " + autor);
        System.out.println("   ISBN: " + isbn);
        System.out.println("   Plazo: 21 días");
    }

    @Override
    public void devolver() {
        System.out.println(" Libro devuelto: \"" + titulo + "\"");
        System.out.println("   Gracias por devolverlo a tiempo");
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }
}