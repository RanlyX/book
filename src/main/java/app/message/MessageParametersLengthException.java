package app.message;

import java.util.List;

import app.message.Message.ParamsType;

public class MessageParametersLengthException extends Exception {

    public MessageParametersLengthException(List<ParamsType> paramsType, int descParamsLength) {
        super(String.format("Message parameters type length is %d, description parameters length is %d, not match", paramsType.size(), descParamsLength));
    }

    public MessageParametersLengthException(List<Object> parameters, List<ParamsType> paramsType) {
        super(String.format("Message parameters length is %d, parameters type length is %d, not match", parameters.size(), paramsType.size()));
    }

}
