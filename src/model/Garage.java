package model;
import exceptions.GarageLlenoException;
import exceptions.HorasInvalidasException;
import exceptions.PatenteDuplicadaException;
import exceptions.VehiculoNoEncontradoException;
import model.Vehiculo;
import java.util.*;

public class Garage {
    protected int capacidadMaxima;
    protected List<Vehiculo> vehiculos;
    private int calcularEspacioOcupado(){
        return vehiculos.stream().mapToInt(Vehiculo::getEspacio).sum();
    }

    public Garage (int capacidadMaxima, List<Vehiculo> vehiculos){
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculos = vehiculos;
    }

    public void registrarEntrada(Vehiculo v) throws GarageLlenoException, PatenteDuplicadaException, HorasInvalidasException {
        if (v.getHorasEstimadas() <= 0){
            throw new HorasInvalidasException("Las horas deben ser mayores a 0.");
        }

        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPatente().equalsIgnoreCase(v.getPatente())){
                throw new PatenteDuplicadaException("La patente ya existe.");
            }
        }

        int espacioOcupado = calcularEspacioOcupado();
        if (espacioOcupado + v.getEspacio() > capacidadMaxima){
            throw new GarageLlenoException("No hay espacio suficiente.");
        }

        vehiculos.add(v);
        System.out.println("Vehiculo ingresado correctamente.");
    }

    public void registrarSalida(String patente) throws VehiculoNoEncontradoException{
        Vehiculo vehiculoEncontrado = null;

        for (Vehiculo v : vehiculos){
            if (v.getPatente().equalsIgnoreCase(patente)){
                vehiculoEncontrado = v;
                break;
            }
        }

        if (vehiculoEncontrado == null){
            throw new VehiculoNoEncontradoException("Vehiculo no encontrado.");
        }

        double costo = vehiculoEncontrado.calcularCosto();

        vehiculos.remove(vehiculoEncontrado);

        System.out.println("=== Salida Registrada ===");
        vehiculoEncontrado.mostrarDatos();
        System.out.println("Costo total: $" + costo);
    }

    public void listarVehiculos(){
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos en el garage.");
            return;
        }
        System.out.println("=== VEHICULOS ESTACIONADOS ===");

        for (Vehiculo v : vehiculos){
            v.mostrarDatos();
            System.out.println("-------------------------------------");
        }
    }

    public int calcularEspacioDisponible(){
        return capacidadMaxima - calcularEspacioOcupado();
    }
}
