package exceptions;

public class SameNamesException extends RuntimeException {
    public SameNamesException(String message) {
        super(message);
    }
}
