package model;

public class Auto extends Vehiculo {

    public Auto(String patente, String marca, String modelo, int horasEstimadas){
        super(patente, marca, modelo, horasEstimadas);
    }

    @Override
    public double calcularCosto(){
        return horasEstimadas * 1000;
    }

    @Override
    public int getEspacio(){
        return 2;
    }
}
