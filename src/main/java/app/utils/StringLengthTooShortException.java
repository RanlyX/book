package app.utils;

public class StringLengthTooShortException extends StringLengthException {
    public StringLengthTooShortException(String message, Throwable cause) {
        super(message, cause);
    }
}
