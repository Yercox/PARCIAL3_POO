package com.espe.gestion.curso.controller;

import com.espe.gestion.curso.excepciones.GestionCursosException;
import com.espe.gestion.curso.excepciones.ValidacionCursoException;
import com.espe.gestion.curso.model.Curso;
import com.espe.gestion.curso.model.CursoRepository;
import com.espe.gestion.curso.view.CursoView;

import java.util.Optional;

public class CursoController {

    private final CursoRepository cursoRepository;
    private final CursoView cursoView;

    public CursoController(CursoRepository cursoRepository, CursoView cursoView) {
        this.cursoRepository = cursoRepository;
        this.cursoView = cursoView;
    }

    public void iniciar() {
        while (true) {
            int opcion = cursoView.mostrarMenu();
            try {
                switch (opcion) {
                    case 1 -> agregarCurso();
                    case 2 -> verCursos();
                    case 3 -> actualizarCurso();
                    case 4 -> eliminarCurso();
                    case 5 -> {
                        cursoView.mostrarMensaje("Saliendo del sistema...");
                        return;
                    }
                    default -> cursoView.mostrarMensaje("Opción no válida.");
                }
            } catch (Exception e) {
                cursoView.mostrarMensaje("Error: " + e.getMessage());
            }
        }
    }

    private void validarCurso(Curso curso) throws ValidacionCursoException {
        if (curso.getNombre() == null || curso.getNombre().trim().isEmpty()) {
            throw new ValidacionCursoException("El nombre del curso no puede estar vacío.");
        }
        if (curso.getCreditos() <= 0) {
            throw new ValidacionCursoException("Los créditos deben ser mayores a cero.");
        }
    }

    private void agregarCurso() throws ValidacionCursoException {
        Curso curso = cursoView.obtenerDatosCurso();
        validarCurso(curso);
        cursoRepository.guardar(curso);
        cursoView.mostrarMensaje("Curso agregado con ID: " + curso.getId());
    }

    private void verCursos() {
        cursoView.mostrarCursos(cursoRepository.buscarTodos());
    }

    private void actualizarCurso() throws GestionCursosException, ValidacionCursoException {
        String id = cursoView.obtenerIdCurso();
        Optional<Curso> cursoExistente = cursoRepository.buscarPorId(id);

        if (cursoExistente.isEmpty()) {
            throw new GestionCursosException("Curso no encontrado.");
        }

        Curso nuevosDatos = cursoView.obtenerDatosCurso();
        Curso curso = cursoExistente.get();

        curso.setNombre(nuevosDatos.getNombre());
        curso.setProfesor(nuevosDatos.getProfesor());
        curso.setCreditos(nuevosDatos.getCreditos());

        validarCurso(curso);
        cursoRepository.guardar(curso);
        cursoView.mostrarMensaje("Curso actualizado correctamente.");
    }

    private void eliminarCurso() throws GestionCursosException {
        String id = cursoView.obtenerIdCurso();
        if (!cursoRepository.eliminarPorId(id)) {
            throw new GestionCursosException("No se encontró el curso a eliminar.");
        }
        cursoView.mostrarMensaje("Curso eliminado correctamente.");
    }
}
