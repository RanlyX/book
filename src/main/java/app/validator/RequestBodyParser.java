package app.validator;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class RequestBodyParser<T> {

    private String requestBody;
    private Class<?> requestClass;

    public RequestBodyParser(String requestBody, Class<?> requestClass) {
        this.requestBody = requestBody;
        this.requestClass = requestClass;
    }

    private JsonObject toJsonObject(String str) {
        return new Gson().fromJson(str, JsonObject.class);
    }

    private String getKeyName(Field field) {
		String fieldName = field.getName();
		return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	private Set<String> getRequestKeys(Field[] fields) {
		Set<String> keys = new HashSet<>();
		for (Field field : fields)
			keys.add(getKeyName(field));
		return keys;
	}

    private void checkUnknownProperty(JsonObject inputJson) throws Exception {
        Set<String> inputKeys = inputJson.keySet();
        Field[] fields = this.requestClass.getDeclaredFields();
		Set<String> requestKeys = getRequestKeys(fields);
		inputKeys.removeAll(requestKeys);
		if (inputKeys.size() > 0)
		 	throw new Exception("Unknown property: " + inputKeys);
    }

    // private

    public T parse() throws Exception {
        JsonObject inputJson = toJsonObject(this.requestBody);
        checkUnknownProperty(inputJson);

        return null;
    }
}
