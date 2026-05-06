package model;

public abstract class Vehiculo {
    protected String patente;
    protected String marca;
    protected String modelo;
    protected int horasEstimadas;

    //Constructor
    public Vehiculo (String patente, String marca, String modelo, int horasEstimadas){
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.horasEstimadas = horasEstimadas;
    }

    //Metodos abstractos para obtener el peso de los vehiculos y otro para calcular el costo.
    public abstract int getEspacio();
    public abstract double calcularCosto();

    public void mostrarDatos(){
        System.out.println("Patente: " + patente);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Horas: " + horasEstimadas);
    }

    public int getHorasEstimadas(){
        return horasEstimadas;
    }

    public String getPatente(){
        return patente;
    }

}