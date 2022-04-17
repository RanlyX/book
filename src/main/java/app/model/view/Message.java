package app.model.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import app.message.Message.ParamsType;

@JsonPropertyOrder({ "Code", "Description", "Parameters", "ParameterTypes" })
public class Message {

    @JsonProperty("Code")
    private String code;

    public String getCode() {
        return code;
    }

    public Message setCode(String code) {
        this.code = code;
        return this;
    }

    @JsonProperty("Description")
    private String description;

    public String getDescription() {
        return description;
    }

    public Message setDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("Parameters")
    private List<Object> parameters;

    public List<Object> getParameters() {
        return parameters;
    }

    public Message setParameters(List<Object> parameters) {
        this.parameters = parameters;
        return this;
    }

    @JsonProperty("ParameterTypes")
    private List<ParamsType> parameterTypes;

    public List<ParamsType> getParameterTypes() {
        return parameterTypes;
    }

    public Message setParameterTypes(List<ParamsType> parameterTypes) {
        this.parameterTypes = parameterTypes;
        return this;
    }

}
