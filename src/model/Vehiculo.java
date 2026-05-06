package model;

// Clase abstracta que vehiculo
public abstract class Vehiculo {

    // Atributos comunes a todos los vehiculos
    protected String patente;
    protected String marca;
    protected String modelo;
    protected int horasEstimadas;

    // Constructor base
    public Vehiculo(String patente, String marca, String modelo, int horasEstimadas) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.horasEstimadas = horasEstimadas;
    }

    // Metodos abstractos que cada tipo de vehículo debe implementar
    public abstract int getEspacio();       // espacio que ocupa en el garage
    public abstract double calcularCosto(); // costo según horas

    // Muestra los datos basicos del vehículo
    public void mostrarDatos() {
        System.out.println("Patente: " + patente);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Horas: " + horasEstimadas);
    }

    // Devuelve las horas estimadas de estadia
    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    // Devuelve la patente del vehiculo
    public String getPatente() {
        return patente;
    }
}