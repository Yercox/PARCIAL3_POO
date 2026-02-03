package com.espe.model;

public class Vehiculo {
    private String placa;
    private String marca;
    private int modelo;
    private double precioDia;

    public Vehiculo(String placa, String marca, int modelo, double precioDia) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precioDia = precioDia;
    }

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " - Placa: " + placa;
    }
}