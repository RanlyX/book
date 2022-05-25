package app.validator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import app.property.Nullable;

public interface NullablePropertyChecker<R> extends BaseValidator<R, Nullable> {
    
    default void checkNullable(R r, Class<R> clazz) throws Exception {
		// Unknown reason cannot use
		// Class<T> clazz = (Class<T>) ((ParameterizedType)
		// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Constructor<?> constructor = clazz.getDeclaredConstructors()[1];
		@SuppressWarnings("unchecked")
		R request = (R) constructor.newInstance(r);
		Field[] fields = clazz.getDeclaredFields();
		Map<Field, Method> getterMapper = getGetterMapper(clazz);
		Map<Field, Nullable> inputFieldPropertyMapper = getInputFieldPropertyMapper(clazz, Nullable.class);
		for (Field field : fields) {
			Method getter = getterMapper.get(field);
			Nullable rq = inputFieldPropertyMapper.get(field);
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
