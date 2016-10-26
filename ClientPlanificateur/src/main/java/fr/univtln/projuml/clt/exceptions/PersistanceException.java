package fr.univtln.projuml.clt.exceptions;

/**
 * Created by tomy- on 21/10/2016.
 */
public class PersistanceException extends Exception{
    private Exception exception;

    public PersistanceException(String message) {
        super(message);
    }

    public PersistanceException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
