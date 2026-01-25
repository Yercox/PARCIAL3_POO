package com.tarea.patrones.singleton;


public class ConfiguracionBiblioteca {

    private static volatile ConfiguracionBiblioteca instancia;

    private String nombreBiblioteca;
    private int maxUsuarios;
    private boolean mantenimiento;

    private ConfiguracionBiblioteca() {
        this.nombreBiblioteca = "Biblioteca sin nombre";
        this.maxUsuarios = 100;
        this.mantenimiento = false;
    }

    // Método CORREGIDO con doble verificación para multi-hilo
    public static ConfiguracionBiblioteca getInstance() {
        if (instancia == null) {  // 1ª verificación (rápida, sin synchronized)
            synchronized (ConfiguracionBiblioteca.class) { // Bloqueo solo si es necesario
                if (instancia == null) {  // 2ª verificación (dentro del bloqueo)
                    instancia = new ConfiguracionBiblioteca();
                }
            }
        }
        return instancia;
    }

    // Getters y Setters
    public void setNombreBiblioteca(String nombre) {
        this.nombreBiblioteca = nombre;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setMaxUsuarios(int max) {
        this.maxUsuarios = max;
    }

    public int getMaxUsuarios() {
        return maxUsuarios;
    }

    public void setMantenimiento(boolean mant) {
        this.mantenimiento = mant;
    }

    public boolean isMantenimiento() {
        return mantenimiento;
    }

    public void mostrarConfiguracion() {
        System.out.println("=== Configuración Biblioteca ===");
        System.out.println("Nombre: " + nombreBiblioteca);
        System.out.println("Máx. usuarios: " + maxUsuarios);
        System.out.println("Modo mantenimiento: " + (mantenimiento ? "SÍ" : "NO"));
    }
}