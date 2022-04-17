package app.message;

import java.text.Collator;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.springframework.http.HttpStatus;

public class Message {

    protected String code = "";
    protected String description = "";
    protected List<Object> parameters = Collections.emptyList();
    protected List<ParamsType> paramsType = Collections.emptyList();
    protected HttpStatus httpStatus = null;

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return MessageFormat.format(description, parameters); 
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public void setParameters(List<Object> parameters) throws MessageParametersLengthException, MessageParamTypeException {
        checkParamsTypeLength(parameters, this.paramsType);
        checkParamsTypeIsMatch(parameters, this.paramsType);
        this.parameters = parameters;
    }

    public List<ParamsType> getParamsType() {
        return this.paramsType;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

	public enum ParamsType {
		STRING("String"),
        INTEGER("Integer"),
        DOUBLE("Double"),
        BOOLEAN("Boolean");

        private String value;
        private final static Map<String, ParamsType> CONSTANTS = new HashMap<String, ParamsType>();

        static {
            for (ParamsType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ParamsType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ParamsType fromValue(String value) {
            ParamsType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    protected int getDescParamsLength(String description) {
        Pattern pattern = Pattern.compile("\\{\\d+\\}");
        Matcher matcher = pattern.matcher(description);
        int ctr = 0;
        while (matcher.find()) {
            ctr++;
        }
        return ctr;
    }

    protected void checkDescTypeLength(List<ParamsType> paramsTypes, String description) throws MessageParametersLengthException {
        int descParamsLength = getDescParamsLength(description);
        if (paramsType.size() != descParamsLength)
            throw new MessageParametersLengthException(paramsType, descParamsLength);
    }

    protected void checkParamsTypeLength(List<Object> parameters, List<ParamsType> paramsTypes) throws MessageParametersLengthException {
        if (parameters.size() != paramsType.size())
            throw new MessageParametersLengthException(parameters, paramsType);
    }

    protected void checkParamsTypeIsMatch(List<Object> parameters, List<ParamsType> paramsTypes) throws MessageParamTypeException {
        for (int i = 0; i < parameters.size(); i++) {
            Object param = parameters.get(i);
            switch (paramsType.get(i)) {
                case STRING:
                    if (!(param instanceof String))
                        throw new MessageParamTypeException(param, ParamsType.STRING);
                    break;
                case INTEGER:
                    if (!(param instanceof Integer))
                        throw new MessageParamTypeException(param, ParamsType.INTEGER);
                    break;
                case DOUBLE:
                    if (!(param instanceof Double))
                        throw new MessageParamTypeException(param, ParamsType.DOUBLE);
                    break;
                case BOOLEAN:
                    if (!(param instanceof Boolean))
                        throw new MessageParamTypeException(param, ParamsType.BOOLEAN);
                    break;
                default:
                    break;
                
            }
        }
    }

}
