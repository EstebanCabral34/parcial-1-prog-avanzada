package exceptions;

// Excepcion que se lanza cuando se intenta ingresar una patente ya existente
public class PatenteDuplicadaException extends Exception {

    // Constructor que recibe el mensaje de error
    public PatenteDuplicadaException(String mensaje) {
        super(mensaje);
    }
}