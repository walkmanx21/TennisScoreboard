package exceptions;

public class PlayerAlreadyExistException extends RuntimeException{
    public PlayerAlreadyExistException(String message) {
        super(message);
    }
}
