package com.espe.service;

import com.espe.repository.IVehiculoRepository;
import com.espe.model.Vehiculo;

public class VehiculoService {
    private IVehiculoRepository repository;

    public VehiculoService(IVehiculoRepository repository) {
        this.repository = repository;
        System.out.println("VehiculoService inicializado con DIP");
    }

    public void registrarVehiculo(Vehiculo v) {
        if (v == null) {
            throw new IllegalArgumentException("El vehiculo no puede ser nulo");
        }

        if (v.getPrecioDia() <= 0) {
            throw new IllegalArgumentException("El precio por dia debe ser mayor a cero");
        }

        System.out.println("Procesando registro de vehiculo: " + v.getPlaca());

        repository.guardar(v);

        System.out.println("Vehiculo registrado exitosamente");
    }

    public IVehiculoRepository getRepository() {
        return repository;
    }
}