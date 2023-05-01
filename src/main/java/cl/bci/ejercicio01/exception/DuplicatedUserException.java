package cl.bci.ejercicio01.exception;

public class DuplicatedUserException extends Exception{

    public DuplicatedUserException(String errorMessage) {
        super(errorMessage);
    }

}
