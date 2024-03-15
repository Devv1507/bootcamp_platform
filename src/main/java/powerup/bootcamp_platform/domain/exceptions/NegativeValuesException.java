package powerup.bootcamp_platform.domain.exceptions;

public class NegativeValuesException extends RuntimeException{
    public NegativeValuesException(String message){
        super(message);
    }
}