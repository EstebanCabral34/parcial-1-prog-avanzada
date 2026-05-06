package model;

import exceptions.GarageLlenoException;
import exceptions.HorasInvalidasException;
import exceptions.PatenteDuplicadaException;
import exceptions.VehiculoNoEncontradoException;

import java.util.*;

// Clase que representa el garage y gestiona los vehiculos
public class Garage {

    // Capacidad maxima de espacios disponibles
    protected int capacidadMaxima;

    // Lista de vehiculos almacenados
    protected List<Vehiculo> vehiculos;

    // Constructor que inicializa la capacidad y la lista
    public Garage(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculos = new ArrayList<>();
    }

    // Calcula el espacio total ocupado usando polimorfismo
    public int calcularEspacioOcupado() {
        return vehiculos.stream()
                .mapToInt(Vehiculo::getEspacio)
                .sum();
    }

    // Registra la entrada de un vehiculo validando reglas de negocio
    public void registrarEntrada(Vehiculo v)
            throws GarageLlenoException, PatenteDuplicadaException, HorasInvalidasException {

        // Validar horas
        if (v.getHorasEstimadas() <= 0) {
            throw new HorasInvalidasException("Las horas deben ser mayores a 0.");
        }

        // Validar patente duplicada
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equalsIgnoreCase(v.getPatente())) {
                throw new PatenteDuplicadaException("La patente ya existe.");
            }
        }

        // Validar espacio disponible
        int espacioOcupado = calcularEspacioOcupado();
        if (espacioOcupado + v.getEspacio() > capacidadMaxima) {
            throw new GarageLlenoException("No hay espacio suficiente.");
        }

        // Agregar vehiculo
        vehiculos.add(v);
        System.out.println("Vehiculo ingresado correctamente.");
    }

    // Registra la salida de un vehiculo segun su patente
    public void registrarSalida(String patente) throws VehiculoNoEncontradoException {

        Vehiculo vehiculoEncontrado = null;

        // Buscar vehiculo
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                vehiculoEncontrado = v;
                break;
            }
        }

        // Validar existencia
        if (vehiculoEncontrado == null) {
            throw new VehiculoNoEncontradoException("Vehiculo no encontrado.");
        }

        // Calcular costo antes de eliminar
        double costo = vehiculoEncontrado.calcularCosto();

        // Eliminar vehiculo
        vehiculos.remove(vehiculoEncontrado);

        // Mostrar resumen
        System.out.println("=== Salida Registrada ===");
        vehiculoEncontrado.mostrarDatos();
        System.out.println("Costo total: $" + costo);
    }

    // Lista todos los vehiculos del garage
    public void listarVehiculos() {

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos en el garage.");
            return;
        }

        System.out.println("=== VEHICULOS ESTACIONADOS ===");

        for (Vehiculo v : vehiculos) {
            v.mostrarDatos();
            System.out.println("-------------------------------------");
        }
    }

    // Calcula el espacio disponible
    public int calcularEspacioDisponible() {
        return capacidadMaxima - calcularEspacioOcupado();
    }

    // Devuelve la lista de vehiculos
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    // Muestra el estado actual del garage
    public void mostrarEstado() {

        int ocupado = calcularEspacioOcupado();
        int disponible = capacidadMaxima - ocupado;

        System.out.println("=== ESTADO DEL GARAGE ===");
        System.out.println("Capacidad total: " + capacidadMaxima);
        System.out.println("Espacio ocupado: " + ocupado);
        System.out.println("Espacio disponible: " + disponible);
    }
}