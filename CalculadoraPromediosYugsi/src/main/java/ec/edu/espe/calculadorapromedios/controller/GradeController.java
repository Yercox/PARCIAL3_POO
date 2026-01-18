package ec.edu.espe.calculadorapromedios.controller;

import ec.edu.espe.calculadorapromedios.model.ICalculable;
import ec.edu.espe.calculadorapromedios.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GradeController implements ActionListener {

    private ICalculable model;
    private MainFrame view;

    public GradeController(ICalculable model, MainFrame view) {
        this.model = model;
        this.view = view;
        this.view.addCalcularListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = view.getNota1();
            double n2 = view.getNota2();
            double n3 = view.getNota3();


            if (!validarNota(n1) || !validarNota(n2) || !validarNota(n3)) {
                view.mostrarError("Las notas deben estar entre 0 y 10");
                return;
            }

            double promedio = model.calcularPromedio(n1, n2, n3);
            String estado = model.obtenerEstado(promedio);

            view.setResultado(promedio);
            view.mostrarEstado(estado);

        } catch (NumberFormatException ex) {
            view.mostrarError("Ingrese solo números");
        }
    }

    private boolean validarNota(double nota) {
        return nota >= 0 && nota <= 10;
    }
}