package exceptions;

public class PatenteDuplicadaException extends RuntimeException {
    public PatenteDuplicadaException(String message) {
        super(message);
    }
}
