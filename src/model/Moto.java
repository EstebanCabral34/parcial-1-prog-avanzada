package model;

// Clase que representa una Moto, hereda de Vehiculo
public class Moto extends Vehiculo {

    // Constructor que utiliza el constructor de la clase padre
    public Moto(String patente, String marca, String modelo, int horasEstimadas) {
        super(patente, marca, modelo, horasEstimadas);
    }

    // Calcula el costo en base a las horas estimadas
    @Override
    public double calcularCosto() {
        return horasEstimadas * 700;
    }

    // Devuelve el espacio que ocupa una moto en el garage
    @Override
    public int getEspacio() {
        return 1;
    }
}