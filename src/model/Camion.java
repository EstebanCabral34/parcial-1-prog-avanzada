package model;

// Clase que representa un Camion, hereda de Vehiculo
public class Camion extends Vehiculo {

    // Constructor que utiliza el constructor de la clase padre
    public Camion(String patente, String marca, String modelo, int horasEstimadas) {
        super(patente, marca, modelo, horasEstimadas);
    }

    // Calcula el costo en base a las horas estimadas
    @Override
    public double calcularCosto() {
        return horasEstimadas * 1500;
    }

    // Devuelve el espacio que ocupa un camion en el garage
    @Override
    public int getEspacio() {
        return 4;
    }
}