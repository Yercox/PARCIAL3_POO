package ec.edu.espe.calculadorapromedios.model;

public class GradeManager implements ICalculable {

    @Override
    public double calcularPromedio(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }

    @Override
    public String obtenerEstado(double promedio) {
        return promedio >= 7 ? "APROBADO" : "REPROBADO";
    }
}