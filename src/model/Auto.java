package model;

// Clase que representa un Auto, hereda de Vehiculo
public class Auto extends Vehiculo {

    // Constructor que utiliza el constructor de la clase padre
    public Auto(String patente, String marca, String modelo, int horasEstimadas) {
        super(patente, marca, modelo, horasEstimadas);
    }

    // Calcula el costo en base a las horas estimadas
    @Override
    public double calcularCosto() {
        return horasEstimadas * 1000;
    }

    // Devuelve el espacio que ocupa un auto en el garage
    @Override
    public int getEspacio() {
        return 2;
    }
}