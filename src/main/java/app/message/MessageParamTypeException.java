package app.message;

import app.message.Message.ParamsType;

public class MessageParamTypeException extends Exception {
    
    public MessageParamTypeException(Object param, ParamsType paramsType) {
        super(String.format("Message parameter \"%s\" type is not \"%s\"", param.toString(), paramsType.value()));
    }

}
