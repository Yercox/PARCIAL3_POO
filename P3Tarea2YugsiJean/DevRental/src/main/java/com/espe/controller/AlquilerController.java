package com.espe.controller;

import com.espe.service.VehiculoService;
import com.espe.model.Vehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AlquilerController implements ActionListener {
    private VehiculoService service;

    public AlquilerController(VehiculoService service) {
        this.service = service;
        System.out.println("AlquilerController inicializado");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        System.out.println("Evento recibido: " + command);

        if ("REGISTRAR_VEHICULO".equals(command)) {
        }
    }



    public void registrarVehiculo(String placa, String marca, int modelo, double precioDia) {
        try {
            Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, precioDia);
            service.registrarVehiculo(vehiculo);
        } catch (Exception e) {
            throw new RuntimeException("Error en el controlador: " + e.getMessage(), e);
        }
    }
}