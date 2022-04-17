package app.utils;

public class StringLengthException extends Exception {
    
    // private final String NOT_EQUAL_MESSAGE = 

    // public enum ErrorType {
    //     NOT_EQUAL,
    //     NOT_IN_RANGE,
    //     TOO_LONG,
    //     TOO_SHORT
    // }

    public StringLengthException(String message, Throwable cause) {
        super(message, cause);
    }
}
