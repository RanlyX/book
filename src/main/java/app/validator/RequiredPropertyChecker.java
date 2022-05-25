package app.validator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import app.property.Required;

public interface RequiredPropertyChecker<R> extends BaseValidator<R, Required> {

    default void checkRequired(R r, Class<R> clazz) throws Exception {
		// Unknown reason cannot use
		// Class<T> clazz = (Class<T>) ((ParameterizedType)
		// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Constructor<?> constructor = clazz.getDeclaredConstructors()[1];
		@SuppressWarnings("unchecked")
		R request = (R) constructor.newInstance(r);
		Field[] fields = clazz.getDeclaredFields();
		Map<Field, Method> getterMapper = getGetterMapper(clazz);
		Map<Field, Required> inputFieldPropertyMapper = getInputFieldPropertyMapper(clazz, Required.class);
		for (Field field : fields) {
			Method getter = getterMapper.get(field);
			Required rq = inputFieldPropertyMapper.get(field);
			if (rq != null && getter != null) {
				Object fieldObject = getter.invoke(request);
				// if property is required, but not found
				if (rq.value() && fieldObject == null) {
					throw new Exception("Missing " + field.getName() + ", the property is required.");
				} 
			}
		}
	}

}
