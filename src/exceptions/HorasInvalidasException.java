package exceptions;

// Excepcion que se lanza cuando las horas ingresadas no son validas
public class HorasInvalidasException extends Exception {

    // Constructor que recibe el mensaje de error
    public HorasInvalidasException(String mensaje) {
        super(mensaje);
    }
}