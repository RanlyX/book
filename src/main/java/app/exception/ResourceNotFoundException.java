package app.exception;

import java.util.List;

import app.message.MessageParamTypeException;
import app.message.MessageParametersLengthException;
import app.message.NotFoundExceptionMessage;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(List<Object> parameters) throws MessageParametersLengthException, MessageParamTypeException {
        super(new NotFoundExceptionMessage(parameters));
    }

}
