package service;

import exceptions.GarageLlenoException;
import exceptions.HorasInvalidasException;
import exceptions.PatenteDuplicadaException;
import exceptions.VehiculoNoEncontradoException;
import model.*;

import java.util.List;

// Clase de servicio que actua como intermediaria entre la UI y el Garage
public class GarageService {

    // Referencia al garage
    private Garage garage;

    // Constructor
    public GarageService(Garage garage) {
        this.garage = garage;
    }

    // Metodo para ingresar un vehiculo delegando en Garage
    public void ingresarVehiculo(Vehiculo v)
            throws GarageLlenoException, PatenteDuplicadaException, HorasInvalidasException {

        garage.registrarEntrada(v);
    }

    // Metodo para egresar un vehiculo segun patente
    public void egresarVehiculo(String patente)
            throws VehiculoNoEncontradoException {

        garage.registrarSalida(patente);
    }

    // Busca un vehiculo por patente dentro del garage
    public Vehiculo buscarVehiculo(String patente)
            throws VehiculoNoEncontradoException {

        for (Vehiculo v : garage.getVehiculos()) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }

        throw new VehiculoNoEncontradoException("Vehiculo no encontrado");
    }

    // Genera un reporte general del estado del garage
    public void generarReporte() {

        List<Vehiculo> vehiculos = garage.getVehiculos();

        int motos = 0, autos = 0, camiones = 0;
        double recaudacion = 0;

        // Recorre los vehiculos para contar y sumar costos
        for (Vehiculo v : vehiculos) {
            recaudacion += v.calcularCosto();

            if (v instanceof Moto) motos++;
            else if (v instanceof Auto) autos++;
            else if (v instanceof Camion) camiones++;
        }

        // Muestra los datos del reporte
        System.out.println("=== REPORTE ===");
        System.out.println("Total: " + vehiculos.size());
        System.out.println("Motos: " + motos);
        System.out.println("Autos: " + autos);
        System.out.println("Camiones: " + camiones);
        System.out.println("Espacio ocupado: " + garage.calcularEspacioOcupado());
        System.out.println("Espacio disponible: " + garage.calcularEspacioDisponible());
        System.out.println("Recaudacion: $" + recaudacion);
    }
}