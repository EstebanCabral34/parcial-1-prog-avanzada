package exceptions;

// Excepcion que se lanza cuando no hay espacio disponible en el garage
public class GarageLlenoException extends Exception {

    // Constructor que recibe el mensaje de error
    public GarageLlenoException(String mensaje) {
        super(mensaje);
    }
}