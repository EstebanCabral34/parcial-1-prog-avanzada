package exceptions;

// Excepcion que se lanza cuando no se encuentra un vehiculo por su patente
public class VehiculoNoEncontradoException extends Exception {

    // Constructor que recibe el mensaje de error
    public VehiculoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}