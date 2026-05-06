package model;

public class Camion extends Vehiculo {
    public Camion(String patente, String marca, String modelo, int horasEstimadas){
        super(patente, marca, modelo, horasEstimadas);
    }

    @Override
    public double calcularCosto(){
        return horasEstimadas * 1500;
    }

    @Override
    public int getEspacio(){
        return 4;
    }
}
