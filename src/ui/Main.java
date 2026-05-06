package ui;

import model.*;
import service.GarageService;
import exceptions.*;

import java.util.Scanner;

// Clase principal que contiene la interfaz por consola
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Solicita la capacidad del garage
        System.out.print("Ingrese capacidad maxima del garage: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        // Inicializa el sistema
        Garage garage = new Garage(capacidad);
        GarageService service = new GarageService(garage);

        int opcion;

        // Menu principal
        do {
            System.out.println("\n=== SISTEMA DE GARAGE ===");
            System.out.println("1. Registrar ingreso");
            System.out.println("2. Registrar salida");
            System.out.println("3. Listar vehiculos");
            System.out.println("4. Estado del garage");
            System.out.println("5. Reportes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            try {
                switch (opcion) {

                    case 1:
                        registrarIngreso(scanner, service);
                        break;

                    case 2:
                        System.out.print("Ingrese patente: ");
                        String patenteSalida = scanner.nextLine();
                        service.egresarVehiculo(patenteSalida);
                        break;

                    case 3:
                        garage.listarVehiculos();
                        break;

                    case 4:
                        garage.mostrarEstado();
                        break;

                    case 5:
                        service.generarReporte();
                        break;

                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                }

            } catch (GarageLlenoException |
                     PatenteDuplicadaException |
                     VehiculoNoEncontradoException |
                     HorasInvalidasException e) {

                // Manejo de errores de negocio
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                // Manejo de errores generales
                System.out.println("Error inesperado: " + e.getMessage());
            }

        } while (opcion != 6);

        scanner.close();
    }

    // Metodo auxiliar para registrar el ingreso de un vehiculo
    private static void registrarIngreso(Scanner scanner, GarageService service)
            throws GarageLlenoException, PatenteDuplicadaException, HorasInvalidasException {

        // Seleccion del tipo de vehiculo
        System.out.println("Tipo de vehiculo (1-Moto, 2-Auto, 3-Camion): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        // Datos del vehiculo
        System.out.print("Patente: ");
        String patente = scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Horas estimadas: ");
        int horas = scanner.nextInt();
        scanner.nextLine();

        Vehiculo v;

        // Creacion del vehiculo segun el tipo
        switch (tipo) {
            case 1:
                v = new Moto(patente, marca, modelo, horas);
                break;
            case 2:
                v = new Auto(patente, marca, modelo, horas);
                break;
            case 3:
                v = new Camion(patente, marca, modelo, horas);
                break;
            default:
                System.out.println("Tipo invalido.");
                return;
        }

        // Delega el ingreso al service
        service.ingresarVehiculo(v);
    }
}