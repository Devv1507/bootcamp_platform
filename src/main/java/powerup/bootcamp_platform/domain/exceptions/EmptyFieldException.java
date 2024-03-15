package powerup.bootcamp_platform.domain.exceptions;

public class EmptyFieldException extends RuntimeException{
    public EmptyFieldException (String message){
        super(message);
    }
}
