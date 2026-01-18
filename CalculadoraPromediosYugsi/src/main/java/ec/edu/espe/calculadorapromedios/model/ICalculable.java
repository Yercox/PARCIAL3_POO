package ec.edu.espe.calculadorapromedios.model;

public interface ICalculable {
    double calcularPromedio(double n1, double n2, double n3);
    String obtenerEstado(double promedio);
}