package app.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class NotFoundExceptionMessage extends Message {

    private final String CODE = this.getClass().getName();
    private final String DESCRIPTION = "Service resources \"{1}\" not found";
    private List<ParamsType> PARAMS_TYPE = new ArrayList<>(Arrays.asList(ParamsType.STRING));
    private final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
    public NotFoundExceptionMessage(List<Object> parameters) throws MessageParametersLengthException, MessageParamTypeException {
        System.out.println(PARAMS_TYPE.size());
    
        checkDescTypeLength(this.PARAMS_TYPE, this.DESCRIPTION);
        checkParamsTypeLength(parameters, this.PARAMS_TYPE);
        checkParamsTypeIsMatch(parameters, this.PARAMS_TYPE);
        this.code = this.CODE;
        this.description = this.DESCRIPTION;
        this.paramsType = this.PARAMS_TYPE;
        this.parameters = parameters;
        this.httpStatus = this.HTTP_STATUS;
    }

}
