package app.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

public interface RequestBodyMapperFactory<T> {
    default T getRequestObject(String requestBody, Class<T> requestClass) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());
        Object requestObject = mapper.readValue(requestBody, requestClass);
        return (T) requestObject;
    }
}
