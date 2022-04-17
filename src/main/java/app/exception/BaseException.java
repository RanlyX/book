package app.exception;

import org.springframework.http.HttpStatus;

import app.message.Message;

public class BaseException extends Exception {

    private Message message;
    private Throwable cause;

    public BaseException(Message message) {
        this.message = message;
    }
    
    public BaseException(Message message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    public String getMessage() {
        return message.getDescription();
    }

    public HttpStatus getHttpStatus() {
        return message.getHttpStatus();
    }

    public Message getBaseMessage() {
        return message;
    }

}
