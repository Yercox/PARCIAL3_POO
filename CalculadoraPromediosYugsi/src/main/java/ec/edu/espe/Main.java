package ec.edu.espe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import ec.edu.espe.calculadorapromedios.model.GradeManager;
import ec.edu.espe.calculadorapromedios.view.MainFrame;
import ec.edu.espe.calculadorapromedios.controller.GradeController;

public class Main {

    public static void main(String[] args) {

        GradeManager model = new GradeManager();
        MainFrame view = new MainFrame();
        new GradeController(model, view);

        view.setVisible(true);
    }
}