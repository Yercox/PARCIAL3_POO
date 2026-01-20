package com.espe;
import com.espe.gestion.curso.controller.CursoController;
import com.espe.gestion.curso.model.CursoRepository;
import com.espe.gestion.curso.view.CursoView;

public class Main {

    public static void main(String[] args) {
        CursoRepository repository = new CursoRepository();
        CursoView view = new CursoView();
        CursoController controller = new CursoController(repository, view);

        controller.iniciar();
    }
}
